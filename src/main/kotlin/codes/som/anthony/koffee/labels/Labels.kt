package codes.som.anthony.koffee.labels

import org.objectweb.asm.Label
import org.objectweb.asm.tree.LabelNode

/**
 * Currently, the LabelLike classes are: [LabelNode], [Label], and [KoffeeLabel].
 *
 * However, since we can't declare union typedefs in Kotlin, we have to set the value to 'Any'.
 */
typealias LabelLike = Any

fun coerceLabel(value: LabelLike): LabelNode {
    return when (value) {
        is LabelNode -> value
        is Label -> LabelNode(value)

        is KoffeeLabel -> value.label

        else -> error("Non label-like object passed to coerceLabel()")
    }
}
