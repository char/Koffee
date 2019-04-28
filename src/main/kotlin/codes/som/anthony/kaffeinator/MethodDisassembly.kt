package codes.som.anthony.kaffeinator

import codes.som.anthony.kaffeinator.data.opcodeNameMap
import org.objectweb.asm.Label
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*
import sun.text.normalizer.UTF16.append

fun disassembleMethod(method: MethodNode) = buildString {
    val returnType = Type.getReturnType(method.desc)
    val parameterTypes = Type.getArgumentTypes(method.desc)

    append("method(")
    append(disassembleAccess(method.access))
    append(", ")
    append(disassembleType(returnType))
    append(", ")
    append(disassembleValue(method.name))
    if (parameterTypes.isNotEmpty()) {
        append(", ")
        append(parameterTypes.joinToString(", ", transform = ::disassembleType))
    }
    if (method.signature != null) {
        append(", signature = ")
        append(disassembleValue(method.signature))
    }
    if (!method.exceptions.isNullOrEmpty()) {
        append(", exceptions = ")
        append(disassembleValue(method.exceptions.map(Type::getObjectType)))
    }
    append(")")

    if (method.instructions.size() == 0) {
        append(" {}")
    } else {
        append(" {")

        val jumpTargetSet = mutableSetOf<LabelNode>()
        for (instruction in method.instructions) {
            if (instruction is JumpInsnNode) {
                jumpTargetSet.add(instruction.label)
            }
        }

        val jumpTargets = jumpTargetSet
                .sortedBy { method.instructions.indexOf(it) }
                .map { it.label }

        for (instruction in method.instructions) {
            if (instruction.opcode == -1 && !(instruction is LabelNode && instruction in jumpTargetSet))
                continue

            append("\n")

            if (instruction !is LabelNode) append("    ")
            else append("\n    ")

            append(disassembleInstruction(instruction, jumpTargets))
        }
        append("\n}")
    }
}

fun disassembleOpcode(opcode: Int): String {
    return opcodeNameMap[opcode] ?: "bytecode $opcode"
}

fun disassembleInstruction(insn: AbstractInsnNode, jumpTargets: List<Label>): String {
    if (insn is LabelNode && insn.label in jumpTargets) {
        val labelIndex = jumpTargets.indexOf(insn.label) + 1
        return "+L[$labelIndex]"
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

        is LdcInsnNode -> "$opcodeName(${disassembleValue(insn.cst)})"

        is FieldInsnNode -> "$opcodeName(" +
                "${disassembleType(Type.getObjectType(insn.owner))}, " +
                "${disassembleValue(insn.name)}, " +
                "${disassembleType(Type.getType(insn.desc))})"

        is MethodInsnNode -> {
            val returnType = Type.getReturnType(insn.desc)
            val parameterTypes = Type.getArgumentTypes(insn.desc)

            return buildString {
                append(opcodeName)
                append("(")
                append(disassembleType(Type.getObjectType(insn.owner)))
                append(", ")
                append(disassembleType(returnType))
                append(", ")
                append(disassembleValue(insn.name))
                if (parameterTypes.isNotEmpty()) {
                    append(", ")
                    append(parameterTypes.joinToString(", ", transform = ::disassembleType))
                }
                append(")")
            }
        }

        is JumpInsnNode -> {
            val labelIndex = jumpTargets.indexOf(insn.label.label) + 1

            return buildString {
                append(opcodeName)
                append("(L[")
                append(labelIndex)
                append("])")
            }
        }

        is TypeInsnNode -> buildString {
            append(opcodeName)
            append("(")
            append(disassembleType(Type.getObjectType(insn.desc)))
            append(")")
        }

        else -> "<unsupported $opcodeName>"
    }
}
