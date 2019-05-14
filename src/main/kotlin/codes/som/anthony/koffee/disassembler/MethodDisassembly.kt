package codes.som.anthony.koffee.disassembler

import codes.som.anthony.koffee.disassembler.data.opcodeNameMap
import codes.som.anthony.koffee.disassembler.util.DisassemblyContext
import codes.som.anthony.koffee.disassembler.util.SourceCodeGenerator
import org.objectweb.asm.Label
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*

fun disassembleMethods(node: ClassNode, codegen: SourceCodeGenerator, context: DisassemblyContext) {
    if (!node.methods.isNullOrEmpty()) {
        for (method in node.methods) {
            disassembleMethod(method, codegen, context)
        }
    }
}

fun disassembleInstructions(first: AbstractInsnNode, last: AbstractInsnNode? = null, node: ClassNode, method: MethodNode): String {
    val codegen = SourceCodeGenerator()
    val context = DisassemblyContext(node.name)
    disassembleInstructions(codegen, first, last, getJumpTargets(method), context)
    return codegen.toString()
}

private fun getJumpTargets(method: MethodNode): List<Label> {
    val jumpTargetSet = mutableSetOf<LabelNode>()
    for (instruction in method.instructions) {
        when (instruction) {
            is JumpInsnNode -> {
                jumpTargetSet.add(instruction.label)
            }

            is LookupSwitchInsnNode -> {
                jumpTargetSet.add(instruction.dflt)
                jumpTargetSet.addAll(instruction.labels)
            }

            is TableSwitchInsnNode -> {
                jumpTargetSet.add(instruction.dflt)
                jumpTargetSet.addAll(instruction.labels)
            }
        }
    }

    return jumpTargetSet
            .sortedBy { method.instructions.indexOf(it) }
            .map { it.label }
}

private fun disassembleMethod(method: MethodNode, codegen: SourceCodeGenerator, context: DisassemblyContext) {
    val returnType = Type.getReturnType(method.desc)
    val parameterTypes = Type.getArgumentTypes(method.desc)

    with (codegen) {
        append("\n")
        appendIndentation()
        append("method(")
        append(disassembleAccess(method.access))
        append(", ")
        append(disassembleValue(method.name, context))
        append(", ")
        append(disassembleType(returnType, context))
        if (parameterTypes.isNotEmpty()) {
            append(", ")
            for ((index, parameterType) in parameterTypes.withIndex()) {
                append(disassembleType(parameterType, context))

                if (index != parameterTypes.lastIndex)
                    append(", ")
            }
        }

        if (!method.signature.isNullOrEmpty()) {
            append(", signature = ")
            append(disassembleValue(method.signature, context))
        }
        if (!method.exceptions.isNullOrEmpty()) {
            append(", exceptions = ")
            append(disassembleValue(method.exceptions.map(Type::getObjectType).toTypedArray(), context))
        }

        append(") ")

        if (method.instructions.size() == 0) {
            append("{}")
        } else {
            append("{\n")
            indent()
            disassembleInstructions(codegen, method.instructions.first, null, getJumpTargets(method), context)
            dedent()
            appendLine("}")
        }
    }
}

private fun disassembleInstructions(codegen: SourceCodeGenerator,
                                    first: AbstractInsnNode, last: AbstractInsnNode? = null,
                                    jumpTargets: List<Label>, context: DisassemblyContext) {
    var current: AbstractInsnNode? = first
    while (current != null) {
        val instruction = current
        current = current.next

        if (instruction.opcode == -1 && !(instruction is LabelNode && instruction.label in jumpTargets))
            continue

        if (instruction is LabelNode)
            codegen.append("\n")

        codegen.appendLine(disassembleInstruction(instruction, jumpTargets, context))

        if (instruction == last)
            break
    }
}

private fun disassembleInstruction(insn: AbstractInsnNode, jumpTargets: List<Label>, context: DisassemblyContext): String {
    if (insn is LabelNode && insn.label in jumpTargets) {
        return "+${disassembleLabel(insn.label, jumpTargets)}"
    }

    val opcodeName = disassembleOpcode(insn.opcode)

    return when (insn) {
        is InsnNode -> {
            return opcodeName
        }

        is VarInsnNode -> if (insn.`var` in 0 .. 3) {
            "${opcodeName}_${insn.`var`}"
        } else {
            "$opcodeName(${insn.`var`})"
        }

        is IincInsnNode -> "$opcodeName(${insn.`var`}, ${insn.incr})"

        is LdcInsnNode -> "$opcodeName(${disassembleValue(insn.cst, context)})"

        is FieldInsnNode -> "$opcodeName(" +
                "${disassembleType(Type.getObjectType(insn.owner), context)}, " +
                "${disassembleValue(insn.name, context)}, " +
                "${disassembleType(Type.getType(insn.desc), context)})"

        is MethodInsnNode -> {
            val returnType = Type.getReturnType(insn.desc)
            val parameterTypes = Type.getArgumentTypes(insn.desc)

            return buildString {
                append(opcodeName)
                append("(")
                append(disassembleType(Type.getObjectType(insn.owner), context))
                append(", ")
                append(disassembleValue(insn.name, context))
                append(", ")
                append(disassembleType(returnType, context))
                for (parameterType in parameterTypes) {
                    append(", ")
                    append(disassembleType(parameterType, context))
                }
                append(")")
            }
        }

        is JumpInsnNode -> "$opcodeName(${disassembleLabel(insn.label.label, jumpTargets)})"

        is TypeInsnNode -> buildString {
            append(opcodeName)
            append("(")
            append(disassembleType(Type.getObjectType(insn.desc), context))
            append(")")
        }

        is TableSwitchInsnNode -> buildString {
            append(opcodeName)
            append("(")
            append(disassembleValue(insn.min, context))
            append(", ")
            append(disassembleValue(insn.max, context))
            append(", ")
            append(disassembleLabel(insn.dflt.label, jumpTargets))
            append(", ")
            for ((i, label) in insn.labels.withIndex()) {
                append(disassembleLabel(label.label, jumpTargets))
                if (i != insn.labels.lastIndex)
                    append(", ")
            }

            append(")")
        }

        is LookupSwitchInsnNode -> buildString {
            append(opcodeName)
            append("(")
            append(disassembleLabel(insn.dflt.label, jumpTargets))
            append(", ")
            for (i in insn.keys.indices) {
                val key = insn.keys[i]
                val label = insn.labels[i]

                append(disassembleValue(key, context))
                append(" to ")
                append(disassembleLabel(label.label, jumpTargets))

                if (i != insn.keys.lastIndex)
                    append(", ")
            }
            append(")")
        }

        is IntInsnNode -> "$opcodeName(${insn.operand})"

        else -> "// <unsupported $opcodeName>"
    }
}

private fun disassembleLabel(label: Label, jumpTargets: List<Label>) = buildString {
    val labelIndex = jumpTargets.indexOf(label) + 1
    append("L[")
    append(labelIndex)
    append("]")
}

private fun disassembleOpcode(opcode: Int): String {
    return opcodeNameMap[opcode] ?: "bytecode $opcode"
}
