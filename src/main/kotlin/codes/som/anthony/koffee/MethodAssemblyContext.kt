package codes.som.anthony.koffee

import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TryCatchBlockNode

interface InsnASM { val instructions: InsnList }
interface LabelScope { val L: LabelRegistry }

interface LabelledASM : InsnASM, LabelScope

interface TryCatchContainer { val tryCatchBlocks: MutableList<TryCatchBlockNode> }

interface ASM : LabelledASM, TryCatchContainer, TypesAccess, ModifiersAccess

abstract class AbstractASMImpl(override val instructions: InsnList, override val tryCatchBlocks: MutableList<TryCatchBlockNode>) : ASM {
    fun scope(routine: LabelScope.() -> Unit) {
        routine(object : LabelScope {
            override val L = this@AbstractASMImpl.L.scope(instructions)
        })
    }

    fun mergeFrom(asm: ASM, label: LabelWrapper) {
        instructions.insert(label.labelNode, asm.instructions)
        tryCatchBlocks.addAll(asm.tryCatchBlocks)
    }
}

class MethodAssemblyContext(node: MethodNode) : AbstractASMImpl(node.instructions, node.tryCatchBlocks) {
    override val L = LabelRegistry(instructions)
}
