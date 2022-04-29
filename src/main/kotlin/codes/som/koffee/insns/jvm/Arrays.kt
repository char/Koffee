package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.types.TypeLike
import codes.som.koffee.types.coerceType
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.MultiANewArrayInsnNode
import org.objectweb.asm.tree.TypeInsnNode
import org.objectweb.asm.Type.*

/**
 * Get an integer from an array.
 *
 * A I -> I
 */
public val InstructionAssembly.iaload: U get() {
    instructions.add(InsnNode(IALOAD))
}

/**
 * Get a long from an array.
 *
 * A I -> J
 */
public val InstructionAssembly.laload: U get() {
    instructions.add(InsnNode(LALOAD))
}

/**
 * Get a float from an array.
 *
 * A I -> F
 */
public val InstructionAssembly.faload: U get() {
    instructions.add(InsnNode(FALOAD))
}

/**
 * Get a double from an array.
 *
 * A I -> D
 */
public val InstructionAssembly.daload: U get() {
    instructions.add(InsnNode(DALOAD))
}

/**
 * Get an object from an array.
 *
 * A I -> A
 */
public val InstructionAssembly.aaload: U get() {
    instructions.add(InsnNode(AALOAD))
}

/**
 * Get a byte from an array.
 *
 * A I -> I (bytes use ints internally)
 */
public val InstructionAssembly.baload: U get() {
    instructions.add(InsnNode(BALOAD))
}

/**
 * Get a char from an array.
 *
 * A I -> I (chars use ints internally)
 */
public val InstructionAssembly.caload: U get() {
    instructions.add(InsnNode(CALOAD))
}

/**
 * Get a short from an array.
 *
 * A I -> I (shorts use ints internally)
 */
public val InstructionAssembly.saload: U get() {
    instructions.add(InsnNode(SALOAD))
}

/**
 * Store an integer into an array.
 *
 * A I I -> (no stack produced)
 */
public val InstructionAssembly.iastore: U get() {
    instructions.add(InsnNode(IASTORE))
}

/**
 * Store a long into an array.
 *
 * A I J -> (no stack produced)
 */
public val InstructionAssembly.lastore: U get() {
    instructions.add(InsnNode(LASTORE))
}

/**
 * Store a float into an array.
 *
 * A I F -> (no stack produced)
 */
public val InstructionAssembly.fastore: U get() {
    instructions.add(InsnNode(FASTORE))
}

/**
 * Store a double into an array.
 *
 * A I D -> (no stack produced)
 */
public val InstructionAssembly.dastore: U get() {
    instructions.add(InsnNode(DASTORE))
}

/**
 * Store an object into an array.
 *
 * A I A -> (no stack produced)
 */
public val InstructionAssembly.aastore: U get() {
    instructions.add(InsnNode(AASTORE))
}

/**
 * Store a byte into an array.
 *
 * A I I -> (no stack produced)
 */
public val InstructionAssembly.bastore: U get() {
    instructions.add(InsnNode(BASTORE))
}

/**
 * Store a char into an array.
 *
 * A I I -> (no stack produced)
 */
public val InstructionAssembly.castore: U get() {
    instructions.add(InsnNode(CASTORE))
}

/**
 * Store a short into an array.
 *
 * A I I -> (no stack produced)
 */
public val InstructionAssembly.sastore: U get() {
    instructions.add(InsnNode(SASTORE))
}

/**
 * Get the length of an array.
 *
 * A -> I
 */
public val InstructionAssembly.arraylength: U get() {
    instructions.add(InsnNode(ARRAYLENGTH))
}

/**
 * Create a new primitive array.
 * Takes the type of the array as a direct argument.
 *
 * I -> A
 */
public fun InstructionAssembly.newarray(type: TypeLike) {
    @Suppress("RemoveRedundantQualifierName") // Bug in resolver, actually ambiguous if not specified TODO: remove later?
    instructions.add(IntInsnNode(NEWARRAY, when (coerceType(type).sort) {
        BOOLEAN -> T_BOOLEAN
        CHAR -> T_CHAR
        BYTE -> T_BYTE
        SHORT -> T_SHORT
        INT -> T_INT

        Type.FLOAT -> T_FLOAT
        Type.LONG -> T_LONG
        Type.DOUBLE -> T_DOUBLE

        else -> error("Invalid type for primitive array creation")
    }))
}

/**
 * Create a new object array.
 * Takes the type of the array as a direct argument.
 *
 * I -> A
 */
public fun InstructionAssembly.anewarray(type: TypeLike) {
    instructions.add(TypeInsnNode(ANEWARRAY, coerceType(type).internalName))
}

/**
 * Create a new multi-dimensional array.
 * Takes the type of the array and the number of dimensions as direct arguments.
 *
 * I -> A
 */
public fun InstructionAssembly.multianewarray(type: TypeLike, dimensions: Int) {
    instructions.add(MultiANewArrayInsnNode(coerceType(type).descriptor, dimensions))
}
