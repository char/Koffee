package codes.som.anthony.koffee

import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TryCatchBlockNode

interface LabelScope { val L: LabelRegistry }

abstract class ASM(internal val instructions: InsnList, internal val tryCatchBlocks: MutableList<TryCatchBlockNode>) : LabelScope, TypesAccess, ModifiersAccess {
    override val L = LabelRegistry(instructions)

    fun scope(routine: LabelScope.() -> Unit) {
        routine(object : LabelScope {
            override val L = LabelRegistry(instructions)
        })
    }
}

class MethodAssemblyContext(node: MethodNode) : ASM(node.instructions, node.tryCatchBlocks)
