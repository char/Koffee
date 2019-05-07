package codes.som.anthony.koffee.disassembler

import codes.som.anthony.koffee.disassembler.util.DisassemblyContext
import codes.som.anthony.koffee.disassembler.data.accessFlagNameMap
import org.objectweb.asm.Type
import org.objectweb.asm.Type.*

fun disassembleValue(value: Any?, context: DisassemblyContext): String {
    return when (value) {
        null -> "null"

        is List<*> -> buildString {
            append("listOf(")
            for ((index, listValue) in value.withIndex()) {
                append(disassembleValue(listValue, context))
                if (index != value.lastIndex)
                    append(", ")
            }
            append(")")
        }

        is Array<*> -> buildString {
            append("arrayOf(")
            for ((index, arrayValue) in value.withIndex()) {
                append(disassembleValue(arrayValue, context))
                if (index != value.lastIndex)
                    append(", ")
            }
            append(")")
        }

        is String -> "\"$value\""
        is Float -> "${value}F"
        is Number -> "$value"

        is Type -> disassembleType(value, context)

        else -> error("Unknown value type for disassembly")
    }
}

fun disassembleType(type: Type, context: DisassemblyContext): String {
    if (type.sort == OBJECT || type.sort == ARRAY) {
        if (type.internalName == context.currentType)
            return "self"

        return "type(${disassembleValue(type.internalName, context)})"
    }

    return when (type) {
        VOID_TYPE -> "void"
        CHAR_TYPE -> "char"
        BYTE_TYPE -> "byte"
        SHORT_TYPE -> "short"
        INT_TYPE -> "int"
        FLOAT_TYPE -> "float"
        LONG_TYPE -> "long"
        DOUBLE_TYPE -> "double"
        BOOLEAN_TYPE -> "boolean"

        else -> error("Unknown primitive")
    }
}

fun disassembleAccess(access: Int): String {
    return accessFlagNameMap.filter { (_, modifier) -> access and modifier != 0 }
            .map { (name, _) -> name }
            .joinToString(" + ")
}
