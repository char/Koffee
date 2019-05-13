package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import codes.som.anthony.koffee.KoffeeLabel
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.VarInsnNode

val ASM.ireturn: U get() {
    instructions.add(InsnNode(IRETURN))
}
val ASM.lreturn: U get() {
    instructions.add(InsnNode(LRETURN))
}
val ASM.freturn: U get() {
    instructions.add(InsnNode(FRETURN))
}
val ASM.dreturn: U get() {
    instructions.add(InsnNode(DRETURN))
}
val ASM.areturn: U get() {
    instructions.add(InsnNode(ARETURN))
}
val ASM.`return`: U get() {
    instructions.add(InsnNode(RETURN))
}
val ASM._return: U get() = `return`
val ASM.vreturn: U get() = `return`
val ASM.return_void: U get() = `return`

val ASM.lcmp: U get() {
    instructions.add(InsnNode(LCMP))
}
val ASM.fcmpl: U get() {
    instructions.add(InsnNode(FCMPL))
}
val ASM.fcmpg: U get() {
    instructions.add(InsnNode(FCMPG))
}
val ASM.dcmpl: U get() {
    instructions.add(InsnNode(DCMPL))
}
val ASM.dcmpg: U get() {
    instructions.add(InsnNode(DCMPG))
}
fun ASM.ifeq(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFEQ, label.labelNode))
}
fun ASM.ifne(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFNE, label.labelNode))
}
fun ASM.iflt(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFLT, label.labelNode))
}
fun ASM.ifge(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFGE, label.labelNode))
}
fun ASM.ifgt(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFGT, label.labelNode))
}
fun ASM.ifle(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFLE, label.labelNode))
}
fun ASM.if_icmpeq(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ICMPEQ, label.labelNode))
}
fun ASM.if_icmpne(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ICMPNE, label.labelNode))
}
fun ASM.if_icmplt(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ICMPLT, label.labelNode))
}
fun ASM.if_icmpge(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ICMPGE, label.labelNode))
}
fun ASM.if_icmpgt(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ICMPGT, label.labelNode))
}
fun ASM.if_icmple(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ICMPLE, label.labelNode))
}
fun ASM.if_acmpeq(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ACMPEQ, label.labelNode))
}
fun ASM.if_acmpne(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IF_ACMPNE, label.labelNode))
}
fun ASM.goto(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(GOTO, label.labelNode))
}
fun ASM.ifnull(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFNULL, label.labelNode))
}
fun ASM.ifnonnull(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(IFNONNULL, label.labelNode))
}
fun ASM.jsr(label: KoffeeLabel) {
    instructions.add(JumpInsnNode(JSR, label.labelNode))
}
fun ASM.ret(slot: Int) {
    instructions.add(VarInsnNode(RET, slot))
}
val ASM.athrow: U get() {
    instructions.add(InsnNode(ATHROW))
}
