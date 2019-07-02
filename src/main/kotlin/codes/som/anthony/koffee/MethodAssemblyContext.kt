package codes.som.anthony.koffee

import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TryCatchBlockNode

class MethodAssemblyContext(node: MethodNode) : AbstractASMImpl(node.instructions, node.tryCatchBlocks) {
    override val L = LabelRegistry(instructions)
}
