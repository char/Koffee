@file:Suppress("unused") // Receivers used to avoid scope pollution

package codes.som.koffee.insns.jvm

import codes.som.koffee.ClassAssembly
import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.types.TypeLike
import org.objectweb.asm.ConstantDynamic
import org.objectweb.asm.Handle
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.LdcInsnNode

/**
 * Add null to the stack.
 *
 * (no stack consumed) -> A
 */
public val InstructionAssembly.aconst_null: U get() {
    instructions.add(InsnNode(ACONST_NULL))
}

/**
 * Add -1 to the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iconst_m1: U get() {
    instructions.add(InsnNode(ICONST_M1))
}

/**
 * Add 0 to the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iconst_0: U get() {
    instructions.add(InsnNode(ICONST_0))
}

/**
 * Add 1 to the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iconst_1: U get() {
    instructions.add(InsnNode(ICONST_1))
}

/**
 * Add 2 to the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iconst_2: U get() {
    instructions.add(InsnNode(ICONST_2))
}

/**
 * Add 3 to the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iconst_3: U get() {
    instructions.add(InsnNode(ICONST_3))
}

/**
 * Add 4 to the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iconst_4: U get() {
    instructions.add(InsnNode(ICONST_4))
}

/**
 * Add 5 to the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iconst_5: U get() {
    instructions.add(InsnNode(ICONST_5))
}

/**
 * Add 0L to the stack.
 *
 * (no stack consumed) -> J
 */
public val InstructionAssembly.lconst_0: U get() {
    instructions.add(InsnNode(LCONST_0))
}

/**
 * Add 1L to the stack.
 *
 * (no stack consumed) -> J
 */
public val InstructionAssembly.lconst_1: U get() {
    instructions.add(InsnNode(LCONST_1))
}

/**
 * Add 0.0f to the stack.
 *
 * (no stack consumed) -> F
 */
public val InstructionAssembly.fconst_0: U get() {
    instructions.add(InsnNode(FCONST_0))
}

/**
 * Add 1.0f to the stack.
 *
 * (no stack consumed) -> F
 */
public val InstructionAssembly.fconst_1: U get() {
    instructions.add(InsnNode(FCONST_1))
}

/**
 * Add 2.0f to the stack.
 *
 * (no stack consumed) -> F
 */
public val InstructionAssembly.fconst_2: U get() {
    instructions.add(InsnNode(FCONST_2))
}

/**
 * Add 0.0 to the stack.
 *
 * (no stack consumed) -> D
 */
public val InstructionAssembly.dconst_0: U get() {
    instructions.add(InsnNode(DCONST_0))
}

/**
 * Add 1.0 to the stack.
 *
 * (no stack consumed) -> D
 */
public val InstructionAssembly.dconst_1: U get() {
    instructions.add(InsnNode(DCONST_1))
}

/**
 * Push the byte value [v] onto the stack.
 *
 * (no stack consumed) -> I (bytes use ints internally)
 */
public fun InstructionAssembly.bipush(v: Int) {
    instructions.add(IntInsnNode(BIPUSH, v))
}

/**
 * Push the short value [v] onto the stack.
 *
 * (no stack consumed) -> I (shorts use ints internally)
 */
public fun InstructionAssembly.sipush(v: Int) {
    instructions.add(IntInsnNode(SIPUSH, v))
}

/**
 * Load the value [v] onto the stack.
 *
 * One of these two operations will be done to the stack:
 * - (no stack consumed) -> I
 * - (no stack consumed) -> A
 */
public fun InstructionAssembly.ldc(v: Any) {
    instructions.add(LdcInsnNode(v))
}
public fun ClassAssembly.constantDynamic(name: String, type: TypeLike, handle: Handle, vararg boostrapMethodArguments: Any): ConstantDynamic {
    return if (boostrapMethodArguments.isEmpty()) {
        ConstantDynamic(name, coerceType(type).descriptor, handle)
    } else {
        ConstantDynamic(name, coerceType(type).descriptor, handle, *boostrapMethodArguments)
    }
}
