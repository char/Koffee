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
        append(disassembleValue(method.exceptions.map(Type::getObjectType).toTypedArray()))
    }
    append(")")

    if (method.instructions.size() == 0) {
        append(" {}")
    } else {
        append(" {")

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

        is JumpInsnNode -> "$opcodeName(${disassembleLabel(insn.label.label, jumpTargets)})"

        is TypeInsnNode -> buildString {
            append(opcodeName)
            append("(")
            append(disassembleType(Type.getObjectType(insn.desc)))
            append(")")
        }

        is TableSwitchInsnNode -> buildString {
            append(opcodeName)
            append("(")
            append(disassembleValue(insn.min))
            append(", ")
            append(disassembleValue(insn.max))
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

                append(disassembleValue(key))
                append(" to ")
                append(disassembleLabel(label.label, jumpTargets))

                if (i != insn.keys.lastIndex)
                    append(", ")
            }
            append(")")
        }

        else -> "// <unsupported $opcodeName>"
    }
}

private fun disassembleLabel(label: Label, jumpTargets: List<Label>) = buildString {
    val labelIndex = jumpTargets.indexOf(label) + 1
    append("L[")
    append(labelIndex)
    append("]")
}
