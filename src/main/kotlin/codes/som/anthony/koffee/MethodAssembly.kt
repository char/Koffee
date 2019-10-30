package codes.som.anthony.koffee

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.labels.LabelRegistry
import codes.som.anthony.koffee.labels.LabelScope
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TryCatchBlockNode

class MethodAssembly(val node: MethodNode) : InstructionAssembly, TryCatchContainer, LabelScope {
    override val instructions: InsnList
        get() = node.instructions

    override val tryCatchBlocks: MutableList<TryCatchBlockNode>
        get() = node.tryCatchBlocks

    override val L = LabelRegistry(this)

    var maxStack: Int
        get() = node.maxStack
        set(value) { node.maxStack = value }
    
    var maxLocals: Int
        get() = node.maxLocals
        set(value) { node.maxLocals = value }
}

fun MethodNode.koffee(routine: MethodAssembly.() -> Unit): MethodNode {
    val assembly = MethodAssembly(this)
    routine(assembly)
    return assembly.node
}
