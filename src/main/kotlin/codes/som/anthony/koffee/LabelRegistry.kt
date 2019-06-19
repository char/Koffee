package codes.som.anthony.koffee

import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.LabelNode

class LabelRegistry(private val instructions: InsnList) {
    private var labels = mutableMapOf<String, LabelNode>()

    fun copy(instructions: InsnList): LabelRegistry {
        return LabelRegistry(instructions)
                .also { it.labels = this.labels }
    }

    fun scope(instructions: InsnList): LabelRegistry {
        return LabelRegistry(instructions)
                .also { it.labels.putAll(this.labels) }
    }

    operator fun get(index: Int) = this["label_$index"]
    operator fun get(name: String): KoffeeLabel {
        return KoffeeLabel(instructions, labels.getOrPut(name, ::LabelNode))
    }
}

class KoffeeLabel(private val instructions: InsnList, override val labelNode: LabelNode) : LabelWrapper {
    operator fun unaryPlus() {
        instructions.add(labelNode)
    }
}

interface LabelWrapper {
    val labelNode: LabelNode
}

fun LabelNode.wrap(): LabelWrapper {
    val labelNode = this
    return object : LabelWrapper {
        override val labelNode = labelNode
    }
}
