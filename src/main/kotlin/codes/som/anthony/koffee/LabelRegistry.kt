package codes.som.anthony.koffee

import org.objectweb.asm.tree.LabelNode
import org.objectweb.asm.tree.MethodNode

class LabelRegistry(private val node: MethodNode) {
    private val labels = mutableMapOf<String, KoffeeLabel>()

    operator fun get(index: Int) = this["label_$index"]
    operator fun get(name: String): KoffeeLabel {
        return labels.getOrPut(name, { KoffeeLabel(node) })
    }
}

class KoffeeLabel(private val node: MethodNode) {
    val labelNode = LabelNode()

    operator fun unaryPlus() {
        node.instructions.add(labelNode)
    }
}
