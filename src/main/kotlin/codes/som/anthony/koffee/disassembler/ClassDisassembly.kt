package codes.som.anthony.koffee.disassembler

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassReader.EXPAND_FRAMES
import org.objectweb.asm.tree.ClassNode
import java.util.zip.ZipFile

fun disassemble(node: ClassNode) = buildString {
    append("name = ")
    append(disassembleValue(node.name))
    val classAccessSpecifier = disassembleAccess(node.access)
    if (classAccessSpecifier.isNotEmpty()) {
        append("\naccess = ")
        append(classAccessSpecifier)
    }
    append("\nversion = ")
    append(node.version)
    append("\n")

    if (node.fields.isNotEmpty()) {
        append("\n")
        for (field in node.fields) {
            append(disassembleField(field))
            append("\n")
        }
    }

    if (node.methods.isNotEmpty()) {
        append("\n")
        for (method in node.methods) {
            append("\n")
            append(disassembleMethod(method))
            if (method.instructions.size() != 0)
                append("\n")
        }
    }
}
