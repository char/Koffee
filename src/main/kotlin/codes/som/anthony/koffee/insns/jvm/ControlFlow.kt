package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.labels.LabelLike
import codes.som.anthony.koffee.labels.coerceLabel
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.VarInsnNode

val InstructionAssembly.ireturn: U get() {
    instructions.add(InsnNode(IRETURN))
}
val InstructionAssembly.lreturn: U get() {
    instructions.add(InsnNode(LRETURN))
}
val InstructionAssembly.freturn: U get() {
    instructions.add(InsnNode(FRETURN))
}
val InstructionAssembly.dreturn: U get() {
    instructions.add(InsnNode(DRETURN))
}
val InstructionAssembly.areturn: U get() {
    instructions.add(InsnNode(ARETURN))
}
val InstructionAssembly.`return`: U get() {
    instructions.add(InsnNode(RETURN))
}
val InstructionAssembly._return: U get() = `return`
val InstructionAssembly.lcmp: U get() {
    instructions.add(InsnNode(LCMP))
}
val InstructionAssembly.fcmpl: U get() {
    instructions.add(InsnNode(FCMPL))
}
val InstructionAssembly.fcmpg: U get() {
    instructions.add(InsnNode(FCMPG))
}
val InstructionAssembly.dcmpl: U get() {
    instructions.add(InsnNode(DCMPL))
}
val InstructionAssembly.dcmpg: U get() {
    instructions.add(InsnNode(DCMPG))
}
fun InstructionAssembly.ifeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IFEQ, coerceLabel(label)))
}
fun InstructionAssembly.ifne(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNE, coerceLabel(label)))
}
fun InstructionAssembly.iflt(label: LabelLike) {
    instructions.add(JumpInsnNode(IFLT, coerceLabel(label)))
}
fun InstructionAssembly.ifge(label: LabelLike) {
    instructions.add(JumpInsnNode(IFGE, coerceLabel(label)))
}
fun InstructionAssembly.ifgt(label: LabelLike) {
    instructions.add(JumpInsnNode(IFGT, coerceLabel(label)))
}
fun InstructionAssembly.ifle(label: LabelLike) {
    instructions.add(JumpInsnNode(IFLE, coerceLabel(label)))
}
fun InstructionAssembly.if_icmpeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPEQ, coerceLabel(label)))
}
fun InstructionAssembly.if_icmpne(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPNE, coerceLabel(label)))
}
fun InstructionAssembly.if_icmplt(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPLT, coerceLabel(label)))
}
fun InstructionAssembly.if_icmpge(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPGE, coerceLabel(label)))
}
fun InstructionAssembly.if_icmpgt(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPGT, coerceLabel(label)))
}
fun InstructionAssembly.if_icmple(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPLE, coerceLabel(label)))
}
fun InstructionAssembly.if_acmpeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ACMPEQ, coerceLabel(label)))
}
fun InstructionAssembly.if_acmpne(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ACMPNE, coerceLabel(label)))
}
fun InstructionAssembly.goto(label: LabelLike) {
    instructions.add(JumpInsnNode(GOTO, coerceLabel(label)))
}
fun InstructionAssembly.ifnull(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNULL, coerceLabel(label)))
}
fun InstructionAssembly.ifnonnull(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNONNULL, coerceLabel(label)))
}
fun InstructionAssembly.jsr(label: LabelLike) {
    instructions.add(JumpInsnNode(JSR, coerceLabel(label)))
}
fun InstructionAssembly.ret(slot: Int) {
    instructions.add(VarInsnNode(RET, slot))
}
val InstructionAssembly.athrow: U get() {
    instructions.add(InsnNode(ATHROW))
}
