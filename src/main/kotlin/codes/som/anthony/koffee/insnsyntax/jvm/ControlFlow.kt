package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import codes.som.anthony.koffee.LabelRegistry
import codes.som.anthony.koffee.LabelScope
import codes.som.anthony.koffee.LabelWrapper
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.LabelNode
import org.objectweb.asm.tree.VarInsnNode

val InsnASM.ireturn: U get() {
    instructions.add(InsnNode(IRETURN))
}
val InsnASM.lreturn: U get() {
    instructions.add(InsnNode(LRETURN))
}
val InsnASM.freturn: U get() {
    instructions.add(InsnNode(FRETURN))
}
val InsnASM.dreturn: U get() {
    instructions.add(InsnNode(DRETURN))
}
val InsnASM.areturn: U get() {
    instructions.add(InsnNode(ARETURN))
}
val InsnASM.`return`: U get() {
    instructions.add(InsnNode(RETURN))
}
val InsnASM._return: U get() = `return`
val InsnASM.vreturn: U get() = `return`
val InsnASM.return_void: U get() = `return`

val InsnASM.lcmp: U get() {
    instructions.add(InsnNode(LCMP))
}
val InsnASM.fcmpl: U get() {
    instructions.add(InsnNode(FCMPL))
}
val InsnASM.fcmpg: U get() {
    instructions.add(InsnNode(FCMPG))
}
val InsnASM.dcmpl: U get() {
    instructions.add(InsnNode(DCMPL))
}
val InsnASM.dcmpg: U get() {
    instructions.add(InsnNode(DCMPG))
}
fun InsnASM.ifeq(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFEQ, label.labelNode))
}
fun InsnASM.ifne(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFNE, label.labelNode))
}
fun InsnASM.iflt(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFLT, label.labelNode))
}
fun InsnASM.ifge(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFGE, label.labelNode))
}
fun InsnASM.ifgt(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFGT, label.labelNode))
}
fun InsnASM.ifle(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFLE, label.labelNode))
}
fun InsnASM.if_icmpeq(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ICMPEQ, label.labelNode))
}
fun InsnASM.if_icmpne(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ICMPNE, label.labelNode))
}
fun InsnASM.if_icmplt(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ICMPLT, label.labelNode))
}
fun InsnASM.if_icmpge(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ICMPGE, label.labelNode))
}
fun InsnASM.if_icmpgt(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ICMPGT, label.labelNode))
}
fun InsnASM.if_icmple(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ICMPLE, label.labelNode))
}
fun InsnASM.if_acmpeq(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ACMPEQ, label.labelNode))
}
fun InsnASM.if_acmpne(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IF_ACMPNE, label.labelNode))
}
fun InsnASM.goto(label: LabelWrapper) {
    instructions.add(JumpInsnNode(GOTO, label.labelNode))
}
fun InsnASM.ifnull(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFNULL, label.labelNode))
}
fun InsnASM.ifnonnull(label: LabelWrapper) {
    instructions.add(JumpInsnNode(IFNONNULL, label.labelNode))
}
fun InsnASM.jsr(label: LabelWrapper) {
    instructions.add(JumpInsnNode(JSR, label.labelNode))
}
fun InsnASM.ret(slot: Int) {
    instructions.add(VarInsnNode(RET, slot))
}
val InsnASM.athrow: U get() {
    instructions.add(InsnNode(ATHROW))
}
