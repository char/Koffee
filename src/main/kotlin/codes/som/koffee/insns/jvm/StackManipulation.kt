package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

/**
 * Remove the top item from the stack.
 * It must not be a double or long.
 *
 * {T} -> (no stack produced)
 */
public val InstructionAssembly.pop: U get() {
    instructions.add(InsnNode(POP))
}

/**
 * Remove the top 1-2 items from the stack.
 *
 * - {T-T} -> (no stack produced) if T is a double or long
 * - {T} {T2} -> (no stack produced) else
 */
public val InstructionAssembly.pop2: U get() {
    instructions.add(InsnNode(POP2))
}

/**
 * Duplicate the top item on the stack.
 * It must not be a double or long.
 *
 * {T} -> {T} {T}
 */
public val InstructionAssembly.dup: U get() {
    instructions.add(InsnNode(DUP))
}

/**
 * Duplicate the top item on the stack and insert below the second item.
 * Neither item can be a double or long.
 *
 * {T} {T2} -> {T2} {T} {T2}
 */
public val InstructionAssembly.dup_x1: U get() {
    instructions.add(InsnNode(DUP_X1))
}

/**
 * Duplicate the top item on the stack and insert two or three items below it.
 * The top item must not be a double or long.
 *
 * - {T-T} {T2} -> {T2} {T-T} {T2} if T is a double or long
 * - {T} {T2} {T3} -> {T3} {T} {T2} {T3} else
 */
public val InstructionAssembly.dup_x2: U get() {
    instructions.add(InsnNode(DUP_X2))
}

/**
 * Duplicate the top 1-2 items on the stack.
 *
 * - {T-T} -> {T-T} {T-T} if T is a double or long
 * - {T} {T2} -> {T} {T2} {T} {T2} else
 */
public val InstructionAssembly.dup2: U get() {
    instructions.add(InsnNode(DUP2))
}

/**
 * Duplicate the top 1-2 items on the stack and insert below the second/third item.
 * The second/third item must not be a double or long.
 *
 * - {T} {T2-T2} -> {T2-T2} {T} {T2-T2} if T2 is a double or long
 * - {T} {T2} {T3} -> {T2} {T3} {T} {T2} {T3} else
 */
public val InstructionAssembly.dup2_x1: U get() {
    instructions.add(InsnNode(DUP2_X1))
}

/**
 * Duplicate the top 1-2 items on the stack and insert below the third/fourth item.
 *
 * - {T-T} {T2-T2} -> {T2-T2} {T-T} {T2-T2} if T is a double or long and T2 is a double or long
 * - {T} {T2} {T3-T3} -> {T3-T3} {T} {T2} {T3-T3} if neither T nor T2 is a double or long, but T3 is
 * - {T-T} {T2} {T3} -> {T2} {T3} {T-T} {T2} {T3} if T is a double or long, but neither T2 nor T3 are
 * - {T} {T2} {T3} {T4} -> {T3} {T4} {T} {T2} {T3} {T4} if none of the values are double or long
 */
public val InstructionAssembly.dup2_x2: U get() {
    instructions.add(InsnNode(DUP2_X2))
}

/**
 * Swap the top two items on the stack.
 * Neither item can be a double or long.
 *
 * {T} {T2} -> {T2} {T}
 */
public val InstructionAssembly.swap: U get() {
    instructions.add(InsnNode(SWAP))
}
