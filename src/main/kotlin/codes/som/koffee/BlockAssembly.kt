package codes.som.koffee

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.labels.LabelRegistry
import codes.som.koffee.labels.LabelScope
import codes.som.koffee.sugar.ModifiersAccess
import codes.som.koffee.sugar.TypesAccess
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.TryCatchBlockNode

/**
 * A higher-level representation of ASM's [InsnList], also supporting [TryCatchBlockNode]s and label management.
 */
public class BlockAssembly(override val instructions: InsnList, override val tryCatchBlocks: MutableList<TryCatchBlockNode>) :
        InstructionAssembly, TryCatchContainer, LabelScope, ModifiersAccess, TypesAccess {
    override val L: LabelRegistry = LabelRegistry(this)
}

/**
 * Create an [InsnList] and the [TryCatchBlockNode]s used to represent an instruction list,
 * using a [BlockAssembly].
 */
public fun assembleBlock(routine: BlockAssembly.() -> Unit): Pair<InsnList, List<TryCatchBlockNode>> {
    val blockAssembly = BlockAssembly(InsnList(), mutableListOf())
    routine(blockAssembly)
    return Pair(blockAssembly.instructions, blockAssembly.tryCatchBlocks)
}

/**
 * Using this InsnList, return a new InsnList with the given [tryCatchBlocks]
 * and the modifications from a [BlockAssembly].
 */
public fun InsnList.koffee(tryCatchBlocks: MutableList<TryCatchBlockNode> = mutableListOf(), routine: BlockAssembly.() -> Unit): Pair<InsnList, List<TryCatchBlockNode>> {
    val blockAssembly = BlockAssembly(this, tryCatchBlocks)
    routine(blockAssembly)
    return Pair(blockAssembly.instructions, blockAssembly.tryCatchBlocks)
}
