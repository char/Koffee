package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import codes.som.anthony.koffee.LabelWrapper
import org.objectweb.asm.tree.LookupSwitchInsnNode
import org.objectweb.asm.tree.TableSwitchInsnNode

fun InsnASM.tableswitch(min: Int, max: Int, defaultLabel: LabelWrapper, vararg labels: LabelWrapper) {
    val labelNodes = Array(labels.size, { labels[it].labelNode })
    instructions.add(TableSwitchInsnNode(min, max, defaultLabel.labelNode, *labelNodes))
}
fun InsnASM.lookupswitch(defaultLabel: LabelWrapper, vararg branches: Pair<Int, LabelWrapper>) {
    val keys = IntArray(branches.size, { branches[it].first })
    val labels = Array(branches.size, { branches[it].second.labelNode })

    instructions.add(LookupSwitchInsnNode(defaultLabel.labelNode, keys, labels))
}
