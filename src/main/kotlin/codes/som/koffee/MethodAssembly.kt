package codes.som.koffee

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.labels.LabelRegistry
import codes.som.koffee.labels.LabelScope
import codes.som.koffee.sugar.ModifiersAccess
import codes.som.koffee.sugar.TypesAccess
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TryCatchBlockNode

public class MethodAssembly(public val node: MethodNode) : InstructionAssembly, TryCatchContainer, LabelScope, ModifiersAccess, TypesAccess {
    override val instructions: InsnList
        get() = node.instructions

    override val tryCatchBlocks: MutableList<TryCatchBlockNode>
        get() = node.tryCatchBlocks

    override val L: LabelRegistry = LabelRegistry(this)

    public var maxStack: Int
        get() = node.maxStack
        set(value) { node.maxStack = value }
    
    public var maxLocals: Int
        get() = node.maxLocals
        set(value) { node.maxLocals = value }
}

public fun MethodNode.koffee(routine: MethodAssembly.() -> Unit): MethodNode {
    val assembly = MethodAssembly(this)
    routine(assembly)
    return assembly.node
}
