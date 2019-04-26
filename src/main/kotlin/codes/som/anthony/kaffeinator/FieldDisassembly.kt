package codes.som.anthony.kaffeinator

import org.objectweb.asm.Type
import org.objectweb.asm.tree.FieldNode

fun disassembleField(field: FieldNode) = buildString {
    append("field(")
    append(disassembleAccess(field.access))
    append(", type(\"")
    val fieldType = Type.getType(field.desc)
    append(fieldType.internalName)
    append("\"), \"")
    append(field.name)
    append("\"")
    if (field.signature != null || field.value != null) {
        append(", ")
        append(disassembleValue(field.signature))
        append(", ")
        append(disassembleValue(field.value))
    }
    append(")")
}
