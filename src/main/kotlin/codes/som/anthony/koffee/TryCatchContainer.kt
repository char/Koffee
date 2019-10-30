package codes.som.anthony.koffee

import org.objectweb.asm.tree.TryCatchBlockNode

interface TryCatchContainer {
    val tryCatchBlocks: MutableList<TryCatchBlockNode>
}
