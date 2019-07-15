package codes.som.anthony.koffee

import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.TryCatchBlockNode

interface InsnASM : TypesAccess, ModifiersAccess { val instructions: InsnList }
interface LabelScope { val L: LabelRegistry }

interface LabelledASM : InsnASM, LabelScope

interface TryCatchContainer { val tryCatchBlocks: MutableList<TryCatchBlockNode> }

interface ASM : LabelledASM, TryCatchContainer

fun ASM.scope(routine: LabelScope.() -> Unit) {
    val self = this

    routine(object : LabelScope {
        override val L = self.L.scope(instructions)
    })
}

fun ASM.mergeFrom(asm: ASM, label: LabelWrapper) {
    instructions.insert(label.labelNode, asm.instructions)
    tryCatchBlocks.addAll(asm.tryCatchBlocks)
}

abstract class AbstractASMImpl(override val instructions: InsnList,
        override val tryCatchBlocks: MutableList<TryCatchBlockNode>) : ASM
