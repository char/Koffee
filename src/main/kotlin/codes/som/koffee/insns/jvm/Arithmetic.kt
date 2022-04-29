package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.*

/**
 * Add two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.iadd: U get() {
    instructions.add(InsnNode(IADD))
}

/**
 * Add two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.ladd: U get() {
    instructions.add(InsnNode(LADD))
}

/**
 * Add two floats.
 *
 * F F -> F
 */
public val InstructionAssembly.fadd: U get() {
    instructions.add(InsnNode(FADD))
}

/**
 * Add two doubles.
 *
 * D D -> D
 */
public val InstructionAssembly.dadd: U get() {
    instructions.add(InsnNode(DADD))
}

/**
 * Subtract two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.isub: U get() {
    instructions.add(InsnNode(ISUB))
}

/**
 * Subtract two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.lsub: U get() {
    instructions.add(InsnNode(LSUB))
}

/**
 * Subtract two floats.
 *
 * F F -> F
 */
public val InstructionAssembly.fsub: U get() {
    instructions.add(InsnNode(FSUB))
}

/**
 * Subtract two doubles.
 *
 * D D -> D
 */
public val InstructionAssembly.dsub: U get() {
    instructions.add(InsnNode(DSUB))
}

/**
 * Multiply two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.imul: U get() {
    instructions.add(InsnNode(IMUL))
}

/**
 * Multiply two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.lmul: U get() {
    instructions.add(InsnNode(LMUL))
}

/**
 * Multiply two floats.
 *
 * F F -> F
 */
public val InstructionAssembly.fmul: U get() {
    instructions.add(InsnNode(FMUL))
}

/**
 * Multiply two doubles.
 *
 * D D -> D
 */
public val InstructionAssembly.dmul: U get() {
    instructions.add(InsnNode(DMUL))
}

/**
 * Divide two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.idiv: U get() {
    instructions.add(InsnNode(IDIV))
}

/**
 * Divide two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.ldiv: U get() {
    instructions.add(InsnNode(LDIV))
}

/**
 * Divide two floats.
 *
 * F F -> F
 */
public val InstructionAssembly.fdiv: U get() {
    instructions.add(InsnNode(FDIV))
}

/**
 * Divide two doubles.
 *
 * D D -> D
 */
public val InstructionAssembly.ddiv: U get() {
    instructions.add(InsnNode(DDIV))
}

/**
 * Get the remainder from dividing two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.irem: U get() {
    instructions.add(InsnNode(IREM))
}

/**
 * Get the remainder from dividing two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.lrem: U get() {
    instructions.add(InsnNode(LREM))
}

/**
 * Get the remainder from dividing two floats.
 *
 * F F -> F
 */
public val InstructionAssembly.frem: U get() {
    instructions.add(InsnNode(FREM))
}

/**
 * Get the remainder from dividing two doubles.
 *
 * D D -> D
 */
public val InstructionAssembly.drem: U get() {
    instructions.add(InsnNode(DREM))
}

/**
 * Negate an integer.
 *
 * I -> I
 */
public val InstructionAssembly.ineg: U get() {
    instructions.add(InsnNode(INEG))
}

/**
 * Negate a long.
 *
 * J -> J
 */
public val InstructionAssembly.lneg: U get() {
    instructions.add(InsnNode(LNEG))
}

/**
 * Negate a float.
 *
 * F -> F
 */
public val InstructionAssembly.fneg: U get() {
    instructions.add(InsnNode(FNEG))
}

/**
 * Negate a double.
 *
 * D -> D
 */
public val InstructionAssembly.dneg: U get() {
    instructions.add(InsnNode(DNEG))
}

/**
 * Shift an integer left by a given amount.
 *
 * I I -> I
 */
public val InstructionAssembly.ishl: U get() {
    instructions.add(InsnNode(ISHL))
}

/**
 * Shift a long left by a given amount.
 *
 * J I -> J
 */
public val InstructionAssembly.lshl: U get() {
    instructions.add(InsnNode(LSHL))
}

/**
 * Shift an integer right by a given amount.
 *
 * I I -> I
 */
public val InstructionAssembly.ishr: U get() {
    instructions.add(InsnNode(ISHR))
}

/**
 * Shift a long right by a given amount.
 *
 * J I -> J
 */
public val InstructionAssembly.lshr: U get() {
    instructions.add(InsnNode(LSHR))
}

/**
 * Shift an integer right by a given amount, considering the integer to be unsigned.
 *
 * I I -> I
 */
public val InstructionAssembly.iushr: U get() {
    instructions.add(InsnNode(IUSHR))
}

/**
 * Shift a long right by a given amount, considering the long to be unsigned.
 *
 * J I -> J
 */
public val InstructionAssembly.lushr: U get() {
    instructions.add(InsnNode(LUSHR))
}

/**
 * Bitwise AND two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.iand: U get() {
    instructions.add(InsnNode(IAND))
}

/**
 * Bitwise AND two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.land: U get() {
    instructions.add(InsnNode(LAND))
}

/**
 * Bitwise OR two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.ior: U get() {
    instructions.add(InsnNode(IOR))
}

/**
 * Bitwise OR two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.lor: U get() {
    instructions.add(InsnNode(LOR))
}

/**
 * Bitwise XOR two integers.
 *
 * I I -> I
 */
public val InstructionAssembly.ixor: U get() {
    instructions.add(InsnNode(IXOR))
}

/**
 * Bitwise XOR two longs.
 *
 * J J -> J
 */
public val InstructionAssembly.lxor: U get() {
    instructions.add(InsnNode(LXOR))
}

/**
 * Increment the integer in slot [slot] by one.
 *
 * (no stack consumed) -> (no stack produced)
 */
public fun InstructionAssembly.iinc(slot: Int) {
    instructions.add(IincInsnNode(slot, 1))
}

/**
 * Increment the integer in slot [slot] by [amount].
 *
 * (no stack consumed) -> (no stack produced)
 */
public fun InstructionAssembly.iinc(slot: Int, amount: Int) {
    instructions.add(IincInsnNode(slot, amount))
}

/**
 * Convert an integer to a long.
 *
 * I -> J
 */
public val InstructionAssembly.i2l: U get() {
    instructions.add(InsnNode(I2L))
}

/**
 * Convert an integer to a float.
 *
 * I -> F
 */
public val InstructionAssembly.i2f: U get() {
    instructions.add(InsnNode(I2F))
}

/**
 * Convert an integer to a double.
 *
 * I -> D
 */
public val InstructionAssembly.i2d: U get() {
    instructions.add(InsnNode(I2D))
}

/**
 * Convert a long to an integer.
 *
 * J -> I
 */
public val InstructionAssembly.l2i: U get() {
    instructions.add(InsnNode(L2I))
}

/**
 * Convert a long to a float.
 *
 * J -> F
 */
public val InstructionAssembly.l2f: U get() {
    instructions.add(InsnNode(L2F))
}

/**
 * Convert a long to a double.
 *
 * J -> D
 */
public val InstructionAssembly.l2d: U get() {
    instructions.add(InsnNode(L2D))
}

/**
 * Convert a float to an integer.
 *
 * F -> I
 */
public val InstructionAssembly.f2i: U get() {
    instructions.add(InsnNode(F2I))
}

/**
 * Convert a float to a long.
 *
 * F -> J
 */
public val InstructionAssembly.f2l: U get() {
    instructions.add(InsnNode(F2L))
}

/**
 * Convert a float to a double.
 *
 * F -> D
 */
public val InstructionAssembly.f2d: U get() {
    instructions.add(InsnNode(F2D))
}

/**
 * Convert a double to an integer.
 *
 * D -> I
 */
public val InstructionAssembly.d2i: U get() {
    instructions.add(InsnNode(D2I))
}

/**
 * Convert a double to a long.
 *
 * D -> J
 */
public val InstructionAssembly.d2l: U get() {
    instructions.add(InsnNode(D2L))
}

/**
 * Convert a double to a float.
 *
 * D -> F
 */
public val InstructionAssembly.d2f: U get() {
    instructions.add(InsnNode(D2F))
}

/**
 * Convert an integer to a byte.
 *
 * I -> I (bytes use ints internally)
 */
public val InstructionAssembly.i2b: U get() {
    instructions.add(InsnNode(I2B))
}

/**
 * Convert an integer to a char.
 *
 * I -> I (chars use ints internally)
 */
public val InstructionAssembly.i2c: U get() {
    instructions.add(InsnNode(I2C))
}

/**
 * Convert an integer to a short.
 *
 * I -> I (shorts use ints internally)
 */
public val InstructionAssembly.i2s: U get() {
    instructions.add(InsnNode(I2S))
}
