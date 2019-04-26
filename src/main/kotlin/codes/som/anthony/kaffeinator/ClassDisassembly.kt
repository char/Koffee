package codes.som.anthony.kaffeinator

import codes.som.anthony.koffee.assemble
import codes.som.anthony.koffee.insnsyntax.jvm._return
import codes.som.anthony.koffee.insnsyntax.jvm.getstatic
import codes.som.anthony.koffee.insnsyntax.jvm.invokevirtual
import codes.som.anthony.koffee.insnsyntax.jvm.ldc
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassReader.EXPAND_FRAMES
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import java.io.PrintStream
import java.lang.StringBuilder


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
            append(disassembleMethod(method))
            append("\n")
        }
    }
}

fun main() {
    /* val buffer = assemble {
        name = "HelloWorld"
        access = public

        field(public + static, type(String::class), "value")

        method(public + static, void, "main", type(Array<String>::class)) {
            getstatic(type(System::class), "out", type(PrintStream::class))
            ldc("Hello, world!")
            invokevirtual(type(PrintStream::class), void, "println", type(String::class))
            _return
        }
    } */

    val node = ClassNode()
    ClassReader(java.lang.Object::class.java.getResourceAsStream("Object.class")).accept(node, EXPAND_FRAMES)

    println(disassemble(node))
}
