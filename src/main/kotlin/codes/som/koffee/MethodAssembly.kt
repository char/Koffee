package codes.som.koffee

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.labels.LabelRegistry
import codes.som.koffee.labels.LabelScope
import codes.som.koffee.sugar.ModifiersAccess
import codes.som.koffee.sugar.TypesAccess
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TryCatchBlockNode

/**
 * A higher-level representation of ASM's [MethodNode].
 */
public class MethodAssembly(public val node: MethodNode) : InstructionAssembly, TryCatchContainer, LabelScope, ModifiersAccess, TypesAccess {
    override val instructions: InsnList
        get() = node.instructions

    override val tryCatchBlocks: MutableList<TryCatchBlockNode>
        get() = node.tryCatchBlocks

    override val L: LabelRegistry = LabelRegistry(this)

    /**
     * The maximum stack size of this method. This is the maximum number of items that
     * can be pushed onto the stack before requiring the removal of items from the stack.
     */
    public var maxStack: Int
        get() = node.maxStack
        set(value) { node.maxStack = value }

    /**
     * The maximum number of local variables of this method. This defines
     * the highest slot index used for local variables.
     */
    public var maxLocals: Int
        get() = node.maxLocals
        set(value) { node.maxLocals = value }
}

/**
 * Get a [MethodAssembly] from this MethodNode, and return the modified node.
 */
public fun MethodNode.koffee(routine: MethodAssembly.() -> Unit): MethodNode {
    val assembly = MethodAssembly(this)
    routine(assembly)
    return assembly.node
}
