package codes.som.anthony.koffee

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.labels.LabelRegistry
import codes.som.anthony.koffee.labels.LabelScope
import codes.som.anthony.koffee.sugar.ModifiersAccess
import codes.som.anthony.koffee.sugar.TypesAccess
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.TryCatchBlockNode

class BlockAssembly(override val instructions: InsnList, override val tryCatchBlocks: MutableList<TryCatchBlockNode>) :
        InstructionAssembly, TryCatchContainer, LabelScope, ModifiersAccess, TypesAccess {
    override val L = LabelRegistry(this)
}

fun assembleBlock(routine: BlockAssembly.() -> Unit): Pair<InsnList, List<TryCatchBlockNode>> {
    val blockAssembly = BlockAssembly(InsnList(), mutableListOf())
    routine(blockAssembly)
    return Pair(blockAssembly.instructions, blockAssembly.tryCatchBlocks)
}

fun InsnList.koffee(tryCatchBlocks: MutableList<TryCatchBlockNode> = mutableListOf(), routine: BlockAssembly.() -> Unit): Pair<InsnList, List<TryCatchBlockNode>> {
    val blockAssembly = BlockAssembly(this, tryCatchBlocks)
    routine(blockAssembly)
    return Pair(blockAssembly.instructions, blockAssembly.tryCatchBlocks)
}
