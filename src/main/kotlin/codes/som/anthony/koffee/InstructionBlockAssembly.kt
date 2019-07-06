package codes.som.anthony.koffee

import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.TryCatchBlockNode

fun assembleBlock(routine: ASM.() -> Unit): Pair<InsnList, List<TryCatchBlockNode>> {
    val instructions = InsnList()
    val labelRegistry = LabelRegistry(instructions)
    val tryCatchBlocks = mutableListOf<TryCatchBlockNode>()

    val asm = object : ASM {
        override val tryCatchBlocks = tryCatchBlocks
        override val instructions = instructions
        override val L = labelRegistry
    }

    routine(asm)

    return Pair(instructions, tryCatchBlocks)
}
