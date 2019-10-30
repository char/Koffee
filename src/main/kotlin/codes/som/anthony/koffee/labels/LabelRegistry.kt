package codes.som.anthony.koffee.labels

import codes.som.anthony.koffee.insns.InstructionAssembly
import org.objectweb.asm.tree.LabelNode

class KoffeeLabel(private val insns: InstructionAssembly, internal val label: LabelNode) {
    operator fun unaryPlus() {
        insns.instructions.add(label)
    }
}

class LabelRegistry(private val insns: InstructionAssembly) {
    private var labels = mutableMapOf<String, LabelNode>()

    fun copy(insns: InstructionAssembly): LabelRegistry {
        return LabelRegistry(insns)
                .also { it.labels = this.labels }
    }

    fun scope(insns: InstructionAssembly): LabelRegistry {
        return LabelRegistry(insns)
                .also { it.labels.putAll(this.labels) }
    }

    operator fun get(index: Int) = this["label_$index"]
    operator fun get(name: String): KoffeeLabel {
        return KoffeeLabel(insns, labels.getOrPut(name, ::LabelNode))
    }
}
