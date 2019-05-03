package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import codes.som.anthony.koffee.KoffeeLabel
import org.objectweb.asm.tree.LookupSwitchInsnNode
import org.objectweb.asm.tree.TableSwitchInsnNode

fun ASM.tableswitch(min: Int, max: Int, defaultLabel: KoffeeLabel, vararg labels: KoffeeLabel) {
    val labelNodes = Array(labels.size, { labels[it].labelNode })
    node.instructions.add(TableSwitchInsnNode(min, max, defaultLabel.labelNode, *labelNodes))
}

fun ASM.lookupswitch(defaultLabel: KoffeeLabel, vararg branches: Pair<Int, KoffeeLabel>) {
    val keys = IntArray(branches.size, { branches[it].first })
    val labels = Array(branches.size, { branches[it].second.labelNode })

    node.instructions.add(LookupSwitchInsnNode(defaultLabel.labelNode, keys, labels))
}
