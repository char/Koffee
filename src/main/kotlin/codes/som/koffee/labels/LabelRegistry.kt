package codes.som.koffee.labels

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.tree.LabelNode

/**
 * A wrapper around a [label] that can be easily added to an [InstructionAssembly].
 */
public class KoffeeLabel(private val insns: InstructionAssembly, internal val label: LabelNode) {
    /**
     * Add this label to the [InstructionAssembly].
     */
    public operator fun unaryPlus() {
        insns.instructions.add(label)
    }
}

/**
 * A storage for labels with a given [InstructionAssembly], so you don't
 * have to keep track of them yourself.
 */
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

    /**
     * Get a label by an [index].
     */
    public operator fun get(index: Int): KoffeeLabel = this["label_$index"]

    /**
     * Get a label by [name].
     */
    public operator fun get(name: String): KoffeeLabel {
        return KoffeeLabel(insns, labels.getOrPut(name, ::LabelNode))
    }
}
