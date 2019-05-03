package codes.som.anthony.koffee

import org.objectweb.asm.ClassWriter
import org.objectweb.asm.ClassWriter.COMPUTE_FRAMES
import org.objectweb.asm.tree.ClassNode

fun assemble(routine: ClassAssemblyContext.() -> Unit): ClassNode {
    val assemblyContext = ClassAssemblyContext()
    routine(assemblyContext)

    return assemblyContext.node
}

fun assemble(node: ClassNode): ByteArray {
    val writer = ClassWriter(COMPUTE_FRAMES)
    node.accept(writer)
    return writer.toByteArray()
}
