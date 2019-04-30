package codes.som.anthony.koffee

import org.objectweb.asm.tree.MethodNode

interface LabelScope { val L: LabelRegistry }
abstract class ASM(internal val node: MethodNode) : LabelScope {
    override val L = LabelRegistry(node)

    fun labelScope(routine: LabelScope.() -> Unit) {
        routine(object : LabelScope {
            override val L = LabelRegistry(node)
        })
    }
}

class MethodAssemblyContext(node: MethodNode) : ASM(node)
