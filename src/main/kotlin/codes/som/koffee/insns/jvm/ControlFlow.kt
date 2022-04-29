package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.labels.LabelLike
import codes.som.koffee.labels.coerceLabel
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.VarInsnNode

/**
 * Return an integer value from a method.
 *
 * I -> (no stack produced)
 */
public val InstructionAssembly.ireturn: U get() {
    instructions.add(InsnNode(IRETURN))
}

/**
 * Return a long value from a method.
 *
 * J -> (no stack produced)
 */
public val InstructionAssembly.lreturn: U get() {
    instructions.add(InsnNode(LRETURN))
}

/**
 * Return a float value from a method.
 *
 * F -> (no stack produced)
 */
public val InstructionAssembly.freturn: U get() {
    instructions.add(InsnNode(FRETURN))
}

/**
 * Return a double value from a method.
 *
 * D -> (no stack produced)
 */
public val InstructionAssembly.dreturn: U get() {
    instructions.add(InsnNode(DRETURN))
}

/**
 * Return an object from a method.
 *
 * A -> (no stack produced)
 */
public val InstructionAssembly.areturn: U get() {
    instructions.add(InsnNode(ARETURN))
}

/**
 * Return from a method.
 *
 * (no stack consumed) -> (no stack produced)
 */
public val InstructionAssembly.`return`: U get() {
    instructions.add(InsnNode(RETURN))
}

/**
 * Return from a method.
 *
 * (no stack consumed) -> (no stack produced)
 */
public val InstructionAssembly._return: U get() = `return`

/**
 * Compare two longs.
 *
 * J J -> I
 */
public val InstructionAssembly.lcmp: U get() {
    instructions.add(InsnNode(LCMP))
}

/**
 * Check if one float is less than another.
 *
 * F F -> I
 */
public val InstructionAssembly.fcmpl: U get() {
    instructions.add(InsnNode(FCMPL))
}

/**
 * Check if one float is greater than another.
 *
 * F F -> I
 */
public val InstructionAssembly.fcmpg: U get() {
    instructions.add(InsnNode(FCMPG))
}

/**
 * Check if one double is less than another.
 *
 * D D -> I
 */
public val InstructionAssembly.dcmpl: U get() {
    instructions.add(InsnNode(DCMPL))
}

/**
 * Check if one double is greater than another.
 *
 * D D -> I
 */
public val InstructionAssembly.dcmpg: U get() {
    instructions.add(InsnNode(DCMPG))
}

/**
 * Check if an integer equals zero.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.ifeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IFEQ, coerceLabel(label)))
}

/**
 * Check if an integer is greater than zero.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.ifne(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNE, coerceLabel(label)))
}

/**
 * Check if an integer is less than zero.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.iflt(label: LabelLike) {
    instructions.add(JumpInsnNode(IFLT, coerceLabel(label)))
}

/**
 * Check if an integer is greater than or equal to zero.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.ifge(label: LabelLike) {
    instructions.add(JumpInsnNode(IFGE, coerceLabel(label)))
}

/**
 * Check if an integer is less than or equal to zero.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.ifgt(label: LabelLike) {
    instructions.add(JumpInsnNode(IFGT, coerceLabel(label)))
}

/**
 * Check if an integer is less than or equal to zero.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.ifle(label: LabelLike) {
    instructions.add(JumpInsnNode(IFLE, coerceLabel(label)))
}

/**
 * Check if two integers are equal.
 * Takes a [label] to jump to if the condition is true.
 *
 * I I -> (no stack produced)
 */
public fun InstructionAssembly.if_icmpeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPEQ, coerceLabel(label)))
}

/**
 * Check if two integers are not equal.
 * Takes a [label] to jump to if the condition is true.
 *
 * I I -> (no stack produced)
 */
public fun InstructionAssembly.if_icmpne(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPNE, coerceLabel(label)))
}

/**
 * Check if one integer is less than another.
 * Takes a [label] to jump to if the condition is true.
 *
 * I I -> (no stack produced)
 */
public fun InstructionAssembly.if_icmplt(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPLT, coerceLabel(label)))
}

/**
 * Check if one integer is greater than or equal to another.
 * Takes a [label] to jump to if the condition is true.
 *
 * I I -> (no stack produced)
 */
public fun InstructionAssembly.if_icmpge(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPGE, coerceLabel(label)))
}

/**
 * Check if one integer is greater than another.
 * Takes a [label] to jump to if the condition is true.
 *
 * I I -> (no stack produced)
 */
public fun InstructionAssembly.if_icmpgt(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPGT, coerceLabel(label)))
}

/**
 * Check if one integer is less than or equal to another.
 * Takes a [label] to jump to if the condition is true.
 *
 * I I -> (no stack produced)
 */
public fun InstructionAssembly.if_icmple(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ICMPLE, coerceLabel(label)))
}

/**
 * Check if two objects are the same reference.
 * Takes a [label] to jump to if the condition is true.
 *
 * A A -> (no stack produced)
 */
public fun InstructionAssembly.if_acmpeq(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ACMPEQ, coerceLabel(label)))
}

/**
 * Check if two objects are not the same reference.
 * Takes a [label] to jump to if the condition is true.
 *
 * A A -> (no stack produced)
 */
public fun InstructionAssembly.if_acmpne(label: LabelLike) {
    instructions.add(JumpInsnNode(IF_ACMPNE, coerceLabel(label)))
}

/**
 * Go to [label].
 *
 * (no stack consumed) -> (no stack produced)
 */
public fun InstructionAssembly.goto(label: LabelLike) {
    instructions.add(JumpInsnNode(GOTO, coerceLabel(label)))
}

/**
 * Check if an object is null.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.ifnull(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNULL, coerceLabel(label)))
}

/**
 * Check if an object is not null.
 * Takes a [label] to jump to if the condition is true.
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.ifnonnull(label: LabelLike) {
    instructions.add(JumpInsnNode(IFNONNULL, coerceLabel(label)))
}

/**
 * Jump to a subroutine at [label].
 * This will push the address onto the stack. The [ret]
 * instruction instead takes an address from a local variable slot.
 *
 * (no stack consumed) -> I
 */
public fun InstructionAssembly.jsr(label: LabelLike) {
    instructions.add(JumpInsnNode(JSR, coerceLabel(label)))
}

/**
 * Return from a subroutine.
 * Takes a [slot] to retrieve the address from.
 * The [jsr] instruction instead pushes the address onto the stack.
 *
 * (no stack consumed) -> (no stack produced)
 */
public fun InstructionAssembly.ret(slot: Int) {
    instructions.add(VarInsnNode(RET, slot))
}

/**
 * Throw an exception.
 *
 * A -> (no stack produced)
 */
public val InstructionAssembly.athrow: U get() {
    instructions.add(InsnNode(ATHROW))
}
