package codes.som.anthony.kaffeinator

import codes.som.anthony.kaffeinator.data.opcodeNameMap
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*

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
    if (method.signature != null || !method.exceptions.isNullOrEmpty()) {
        append(", ")
        append(disassembleValue(method.signature))
        append(", ")
        append(disassembleValue(method.exceptions.map(Type::getObjectType)))
    }
    append(")")

    if (method.instructions.size() == 0) {
        append(" {}")
    } else {
        append(" {")

        val indentation = " ".repeat(4)
        for (instruction in method.instructions) {
            if (instruction.opcode == -1)
                continue

            append("\n")
            append(indentation)
            append(disassembleInstruction(instruction))
        }
        append("\n}")
    }
}

fun disassembleOpcode(opcode: Int): String {
    return opcodeNameMap[opcode] ?: "bytecode $opcode"
}

fun disassembleInstruction(insn: AbstractInsnNode): String {
    return when (insn) {
        is InsnNode -> {
            return disassembleOpcode(insn.opcode)
        }

        is VarInsnNode -> if (insn.`var` in 0 .. 3) {
            "${disassembleOpcode(insn.opcode)}_${insn.`var`}"
        } else {
            "${disassembleOpcode(insn.opcode)}(${insn.`var`})"
        }

        is LdcInsnNode -> "${disassembleOpcode(insn.opcode)}(${disassembleValue(insn.cst)})"

        is FieldInsnNode -> "${disassembleOpcode(insn.opcode)}(" +
                "${disassembleType(Type.getObjectType(insn.owner))}, " +
                "${disassembleValue(insn.name)}, " +
                "${disassembleType(Type.getType(insn.desc))})"

        is MethodInsnNode -> {
            val returnType = Type.getReturnType(insn.desc)
            val parameterTypes = Type.getArgumentTypes(insn.desc)

            return buildString {
                append(disassembleOpcode(insn.opcode))
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

        else -> "<unsupported instruction>"
    }
}
