package codes.som.anthony.koffee

import org.objectweb.asm.ClassWriter
import org.objectweb.asm.ClassWriter.COMPUTE_FRAMES

fun assemble(routine: ClassAssemblyContext.() -> Unit): ByteArray {
    val writer = ClassWriter(COMPUTE_FRAMES)

    val assemblyContext = ClassAssemblyContext()
    routine(assemblyContext)

    assemblyContext.node.accept(writer)
    return writer.toByteArray()
}
