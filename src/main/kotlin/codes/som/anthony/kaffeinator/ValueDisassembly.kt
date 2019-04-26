package codes.som.anthony.kaffeinator

import org.objectweb.asm.Type
import org.objectweb.asm.Type.*

fun disassembleValue(value: Any?): String {
    if (value is Type) {
        return disassembleType(value)
    }

    if (value is List<*>) {
        return buildString {
            append("listOf(")
            append(value.joinToString(", ", transform = ::disassembleValue))
            append(")")
        }
    }

    if (value is Array<*>) {
        return buildString {
            append("arrayOf(")
            value.joinToString(", ", transform = ::disassembleValue)
            append(")")
        }
    }

    if (value == null) {
        return "null"
    }

    if (value is String) {
        return "\"$value\""
    }

    if (value is Float) {
        return "${value}F"
    }

    return "$value"
}

fun disassembleType(type: Type): String {
    if (type.sort == OBJECT || type.sort == ARRAY) {
        return buildString {
            append("type(")
            append(disassembleValue(type.internalName))
            append(")")
        }
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
