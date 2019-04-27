package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import codes.som.anthony.koffee.KoffeeLabel
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.JumpInsnNode

val ASM.ireturn: U get() {
    node.instructions.add(InsnNode(IRETURN))
}
val ASM.lreturn: U get() {
    node.instructions.add(InsnNode(LRETURN))
}
val ASM.freturn: U get() {
    node.instructions.add(InsnNode(FRETURN))
}
val ASM.dreturn: U get() {
    node.instructions.add(InsnNode(DRETURN))
}
val ASM.areturn: U get() {
    node.instructions.add(InsnNode(ARETURN))
}
val ASM.`return`: U get() {
    node.instructions.add(InsnNode(RETURN))
}
val ASM._return: U get() = `return`
val ASM.vreturn: U get() = `return`
val ASM.return_void: U get() = `return`

fun ASM.ifeq(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IFEQ, label.labelNode))
}
fun ASM.ifne(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IFNE, label.labelNode))
}
fun ASM.iflt(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IFLT, label.labelNode))
}
fun ASM.ifge(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IFGE, label.labelNode))
}
fun ASM.ifgt(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IFGT, label.labelNode))
}
fun ASM.ifle(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IFLE, label.labelNode))
}
fun ASM.if_icmpeq(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ICMPEQ, label.labelNode))
}
fun ASM.if_icmpne(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ICMPNE, label.labelNode))
}
fun ASM.if_icmplt(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ICMPLT, label.labelNode))
}
fun ASM.if_icmpge(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ICMPGE, label.labelNode))
}
fun ASM.if_icmpgt(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ICMPGT, label.labelNode))
}
fun ASM.if_icmple(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ICMPLE, label.labelNode))
}
fun ASM.if_acmpeq(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ACMPEQ, label.labelNode))
}
fun ASM.if_acmpne(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(IF_ACMPNE, label.labelNode))
}
fun ASM.goto(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(GOTO, label.labelNode))
}
fun ASM.jsr(label: KoffeeLabel) {
    node.instructions.add(JumpInsnNode(JSR, label.labelNode))
}
val ASM.ret: U get() {
    node.instructions.add(InsnNode(RET))
}
