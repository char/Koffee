package codes.som.koffee.labels

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.tree.LabelNode

public class KoffeeLabel(private val insns: InstructionAssembly, internal val label: LabelNode) {
    public operator fun unaryPlus() {
        insns.instructions.add(label)
    }
}

public class LabelRegistry(private val insns: InstructionAssembly) {
    private var labels = mutableMapOf<String, LabelNode>()

    public fun copy(insns: InstructionAssembly): LabelRegistry {
        return LabelRegistry(insns)
                .also { it.labels = this.labels }
    }

    public fun scope(insns: InstructionAssembly): LabelRegistry {
        return LabelRegistry(insns)
                .also { it.labels.putAll(this.labels) }
    }

    public operator fun get(index: Int): KoffeeLabel = this["label_$index"]
    public operator fun get(name: String): KoffeeLabel {
        return KoffeeLabel(insns, labels.getOrPut(name, ::LabelNode))
    }
}
