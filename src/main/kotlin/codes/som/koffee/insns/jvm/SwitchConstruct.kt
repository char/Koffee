package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.labels.LabelLike
import codes.som.koffee.labels.coerceLabel
import org.objectweb.asm.tree.LookupSwitchInsnNode
import org.objectweb.asm.tree.TableSwitchInsnNode

public fun InstructionAssembly.tableswitch(min: Int, max: Int, defaultLabel: LabelLike, vararg labels: LabelLike) {
    val labelNodes = Array(labels.size) { coerceLabel(labels[it]) }
    instructions.add(TableSwitchInsnNode(min, max, coerceLabel(defaultLabel), *labelNodes))
}
public fun InstructionAssembly.lookupswitch(defaultLabel: LabelLike, vararg branches: Pair<Int, LabelLike>) {
    val keys = IntArray(branches.size) { branches[it].first }
    val labels = Array(branches.size) { coerceLabel(branches[it].second) }
    instructions.add(LookupSwitchInsnNode(coerceLabel(defaultLabel), keys, labels))
}
