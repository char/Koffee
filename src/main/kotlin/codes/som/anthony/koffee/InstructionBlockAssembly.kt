package codes.som.anthony.koffee

import org.objectweb.asm.tree.InsnList

fun assembleBlock(routine: LabelledASM.() -> Unit): InsnList {
    val instructions = InsnList()
    val labelRegistry = LabelRegistry(instructions)

    val labelledASM = object : LabelledASM {
        override val instructions = instructions
        override val L = labelRegistry
    }

    routine(labelledASM)

    return instructions
}
