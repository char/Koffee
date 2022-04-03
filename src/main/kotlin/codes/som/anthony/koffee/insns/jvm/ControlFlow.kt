package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.labels.LabelLike
import codes.som.anthony.koffee.labels.coerceLabel
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.VarInsnNode

public val InstructionAssembly.ireturn: U get() {
    instructions.add(InsnNode(IRETURN))
}
public val InstructionAssembly.lreturn: U get() {
    instructions.add(InsnNode(LRETURN))
}
public val InstructionAssembly.freturn: U get() {
    instructions.add(InsnNode(FRETURN))
}
public val InstructionAssembly.dreturn: U get() {
    instructions.add(InsnNode(DRETURN))
}
public val InstructionAssembly.areturn: U get() {
    instructions.add(InsnNode(ARETURN))
}
public val InstructionAssembly.`return`: U get() {
    instructions.add(InsnNode(RETURN))
}
public val InstructionAssembly._return: U get() = `return`

public val InstructionAssembly.lcmp: U get() {
    instructions.add(InsnNode(LCMP))
}
public val InstructionAssembly.fcmpl: U get() {
    instructions.add(InsnNode(FCMPL))
}
public val InstructionAssembly.fcmpg: U get() {
    instructions.add(InsnNode(FCMPG))
}
public val InstructionAssembly.dcmpl: U get() {
    instructions.add(InsnNode(DCMPL))
}
public val InstructionAssembly.dcmpg: U get() {
    instructions.add(InsnNode(DCMPG))
}
public fun InstructionAssembly.ifeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IFEQ, coerceLabel(label)))
}
public fun InstructionAssembly.ifne(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNE, coerceLabel(label)))
}
public fun InstructionAssembly.iflt(label: LabelLike) {
    instructions.add(JumpInsnNode(IFLT, coerceLabel(label)))
}
public fun InstructionAssembly.ifge(label: LabelLike) {
    instructions.add(JumpInsnNode(IFGE, coerceLabel(label)))
}
public fun InstructionAssembly.ifgt(label: LabelLike) {
    instructions.add(JumpInsnNode(IFGT, coerceLabel(label)))
}
public fun InstructionAssembly.ifle(label: LabelLike) {
    instructions.add(JumpInsnNode(IFLE, coerceLabel(label)))
}
public fun InstructionAssembly.if_icmpeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPEQ, coerceLabel(label)))
}
public fun InstructionAssembly.if_icmpne(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPNE, coerceLabel(label)))
}
public fun InstructionAssembly.if_icmplt(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPLT, coerceLabel(label)))
}
public fun InstructionAssembly.if_icmpge(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPGE, coerceLabel(label)))
}
public fun InstructionAssembly.if_icmpgt(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPGT, coerceLabel(label)))
}
public fun InstructionAssembly.if_icmple(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPLE, coerceLabel(label)))
}
public fun InstructionAssembly.if_acmpeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ACMPEQ, coerceLabel(label)))
}
public fun InstructionAssembly.if_acmpne(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ACMPNE, coerceLabel(label)))
}
public fun InstructionAssembly.goto(label: LabelLike) {
    instructions.add(JumpInsnNode(GOTO, coerceLabel(label)))
}
public fun InstructionAssembly.ifnull(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNULL, coerceLabel(label)))
}
public fun InstructionAssembly.ifnonnull(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNONNULL, coerceLabel(label)))
}
public fun InstructionAssembly.jsr(label: LabelLike) {
    instructions.add(JumpInsnNode(JSR, coerceLabel(label)))
}
public fun InstructionAssembly.ret(slot: Int) {
    instructions.add(VarInsnNode(RET, slot))
}
public val InstructionAssembly.athrow: U get() {
    instructions.add(InsnNode(ATHROW))
}
