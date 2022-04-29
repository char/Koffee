package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.VarInsnNode

/**
 * Load an integer from [slot] onto the stack.
 *
 * (no stack consumed) -> I
 */
public fun InstructionAssembly.iload(slot: Int) {
    instructions.add(VarInsnNode(ILOAD, slot))
}

/**
 * Load a long from [slot] onto the stack.
 *
 * (no stack consumed) -> J
 */
public fun InstructionAssembly.lload(slot: Int) {
    instructions.add(VarInsnNode(LLOAD, slot))
}

/**
 * Load a float from [slot] onto the stack.
 *
 * (no stack consumed) -> F
 */
public fun InstructionAssembly.fload(slot: Int) {
    instructions.add(VarInsnNode(FLOAD, slot))
}

/**
 * Load a double from [slot] onto the stack.
 *
 * (no stack consumed) -> D
 */
public fun InstructionAssembly.dload(slot: Int) {
    instructions.add(VarInsnNode(DLOAD, slot))
}

/**
 * Load an object from [slot] onto the stack.
 *
 * (no stack consumed) -> A
 */
public fun InstructionAssembly.aload(slot: Int) {
    instructions.add(VarInsnNode(ALOAD, slot))
}

/**
 * Store an integer from the stack into [slot].
 *
 * I -> (no stack produced)
 */
public fun InstructionAssembly.istore(slot: Int) {
    instructions.add(VarInsnNode(ISTORE, slot))
}

/**
 * Store a long from the stack into [slot].
 *
 * J -> (no stack produced)
 */
public fun InstructionAssembly.lstore(slot: Int) {
    instructions.add(VarInsnNode(LSTORE, slot))
}

/**
 * Store a float from the stack into [slot].
 *
 * F -> (no stack produced)
 */
public fun InstructionAssembly.fstore(slot: Int) {
    instructions.add(VarInsnNode(FSTORE, slot))
}

/**
 * Store a double from the stack into [slot].
 *
 * D -> (no stack produced)
 */
public fun InstructionAssembly.dstore(slot: Int) {
    instructions.add(VarInsnNode(DSTORE, slot))
}

/**
 * Store an object from the stack into [slot].
 *
 * A -> (no stack produced)
 */
public fun InstructionAssembly.astore(slot: Int) {
    instructions.add(VarInsnNode(ASTORE, slot))
}

/**
 * Load an integer from slot 0 onto the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iload_0: U get() {
    instructions.add(VarInsnNode(ILOAD, 0))
}

/**
 * Load a long from slot 0 onto the stack.
 *
 * (no stack consumed) -> J
 */
public val InstructionAssembly.lload_0: U get() {
    instructions.add(VarInsnNode(LLOAD, 0))
}

/**
 * Load a float from slot 0 onto the stack.
 *
 * (no stack consumed) -> F
 */
public val InstructionAssembly.fload_0: U get() {
    instructions.add(VarInsnNode(FLOAD, 0))
}

/**
 * Load a double from slot 0 onto the stack.
 *
 * (no stack consumed) -> D
 */
public val InstructionAssembly.dload_0: U get() {
    instructions.add(VarInsnNode(DLOAD, 0))
}

/**
 * Load an object from slot 0 onto the stack.
 *
 * (no stack consumed) -> A
 */
public val InstructionAssembly.aload_0: U get() {
    instructions.add(VarInsnNode(ALOAD, 0))
}

/**
 * Store an integer from the stack into slot 0.
 *
 * I -> (no stack produced)
 */
public val InstructionAssembly.istore_0: U get() {
    instructions.add(VarInsnNode(ISTORE, 0))
}

/**
 * Store a long from the stack into slot 0.
 *
 * J -> (no stack produced)
 */
public val InstructionAssembly.lstore_0: U get() {
    instructions.add(VarInsnNode(LSTORE, 0))
}

/**
 * Store a float from the stack into slot 0.
 *
 * F -> (no stack produced)
 */
public val InstructionAssembly.fstore_0: U get() {
    instructions.add(VarInsnNode(FSTORE, 0))
}

/**
 * Store a double from the stack into slot 0.
 *
 * D -> (no stack produced)
 */
public val InstructionAssembly.dstore_0: U get() {
    instructions.add(VarInsnNode(DSTORE, 0))
}

/**
 * Store an object from the stack into slot 0.
 *
 * A -> (no stack produced)
 */
public val InstructionAssembly.astore_0: U get() {
    instructions.add(VarInsnNode(ASTORE, 0))
}

/**
 * Load an integer from slot 1 onto the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iload_1: U get() {
    instructions.add(VarInsnNode(ILOAD, 1))
}

/**
 * Load a long from slot 1 onto the stack.
 *
 * (no stack consumed) -> J
 */
public val InstructionAssembly.lload_1: U get() {
    instructions.add(VarInsnNode(LLOAD, 1))
}

/**
 * Load a float from slot 1 onto the stack.
 *
 * (no stack consumed) -> F
 */
public val InstructionAssembly.fload_1: U get() {
    instructions.add(VarInsnNode(FLOAD, 1))
}

/**
 * Load a double from slot 1 onto the stack.
 *
 * (no stack consumed) -> D
 */
public val InstructionAssembly.dload_1: U get() {
    instructions.add(VarInsnNode(DLOAD, 1))
}

/**
 * Load an object from slot 1 onto the stack.
 *
 * (no stack consumed) -> A
 */
public val InstructionAssembly.aload_1: U get() {
    instructions.add(VarInsnNode(ALOAD, 1))
}

/**
 * Store an integer from the stack into slot 1.
 *
 * I -> (no stack produced)
 */
public val InstructionAssembly.istore_1: U get() {
    instructions.add(VarInsnNode(ISTORE, 1))
}

/**
 * Store a long from the stack into slot 1.
 *
 * J -> (no stack produced)
 */
public val InstructionAssembly.lstore_1: U get() {
    instructions.add(VarInsnNode(LSTORE, 1))
}

/**
 * Store a float from the stack into slot 1.
 *
 * F -> (no stack produced)
 */
public val InstructionAssembly.fstore_1: U get() {
    instructions.add(VarInsnNode(FSTORE, 1))
}

/**
 * Store a double from the stack into slot 1.
 *
 * D -> (no stack produced)
 */
public val InstructionAssembly.dstore_1: U get() {
    instructions.add(VarInsnNode(DSTORE, 1))
}

/**
 * Store an object from the stack into slot 1.
 *
 * A -> (no stack produced)
 */
public val InstructionAssembly.astore_1: U get() {
    instructions.add(VarInsnNode(ASTORE, 1))
}

/**
 * Load an integer from slot 2 onto the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iload_2: U get() {
    instructions.add(VarInsnNode(ILOAD, 2))
}

/**
 * Load a long from slot 2 onto the stack.
 *
 * (no stack consumed) -> J
 */
public val InstructionAssembly.lload_2: U get() {
    instructions.add(VarInsnNode(LLOAD, 2))
}

/**
 * Load a float from slot 2 onto the stack.
 *
 * (no stack consumed) -> F
 */
public val InstructionAssembly.fload_2: U get() {
    instructions.add(VarInsnNode(FLOAD, 2))
}

/**
 * Load a double from slot 2 onto the stack.
 *
 * (no stack consumed) -> D
 */
public val InstructionAssembly.dload_2: U get() {
    instructions.add(VarInsnNode(DLOAD, 2))
}

/**
 * Load an object from slot 2 onto the stack.
 *
 * (no stack consumed) -> A
 */
public val InstructionAssembly.aload_2: U get() {
    instructions.add(VarInsnNode(ALOAD, 2))
}

/**
 * Store an integer from the stack into slot 2.
 *
 * I -> (no stack produced)
 */
public val InstructionAssembly.istore_2: U get() {
    instructions.add(VarInsnNode(ISTORE, 2))
}

/**
 * Store a long from the stack into slot 2.
 *
 * J -> (no stack produced)
 */
public val InstructionAssembly.lstore_2: U get() {
    instructions.add(VarInsnNode(LSTORE, 2))
}

/**
 * Store a float from the stack into slot 2.
 *
 * F -> (no stack produced)
 */
public val InstructionAssembly.fstore_2: U get() {
    instructions.add(VarInsnNode(FSTORE, 2))
}

/**
 * Store a double from the stack into slot 2.
 *
 * D -> (no stack produced)
 */
public val InstructionAssembly.dstore_2: U get() {
    instructions.add(VarInsnNode(DSTORE, 2))
}

/**
 * Store an object from the stack into slot 2.
 *
 * A -> (no stack produced)
 */
public val InstructionAssembly.astore_2: U get() {
    instructions.add(VarInsnNode(ASTORE, 2))
}

/**
 * Load an integer from slot 3 onto the stack.
 *
 * (no stack consumed) -> I
 */
public val InstructionAssembly.iload_3: U get() {
    instructions.add(VarInsnNode(ILOAD, 3))
}

/**
 * Load a long from slot 3 onto the stack.
 *
 * (no stack consumed) -> J
 */
public val InstructionAssembly.lload_3: U get() {
    instructions.add(VarInsnNode(LLOAD, 3))
}

/**
 * Load a float from slot 3 onto the stack.
 *
 * (no stack consumed) -> F
 */
public val InstructionAssembly.fload_3: U get() {
    instructions.add(VarInsnNode(FLOAD, 3))
}

/**
 * Load a double from slot 3 onto the stack.
 *
 * (no stack consumed) -> D
 */
public val InstructionAssembly.dload_3: U get() {
    instructions.add(VarInsnNode(DLOAD, 3))
}

/**
 * Load an object from slot 3 onto the stack.
 *
 * (no stack consumed) -> A
 */
public val InstructionAssembly.aload_3: U get() {
    instructions.add(VarInsnNode(ALOAD, 3))
}

/**
 * Store an integer from the stack into slot 3.
 *
 * I -> (no stack produced)
 */
public val InstructionAssembly.istore_3: U get() {
    instructions.add(VarInsnNode(ISTORE, 3))
}

/**
 * Store a long from the stack into slot 3.
 *
 * J -> (no stack produced)
 */
public val InstructionAssembly.lstore_3: U get() {
    instructions.add(VarInsnNode(LSTORE, 3))
}

/**
 * Store a float from the stack into slot 3.
 *
 * F -> (no stack produced)
 */
public val InstructionAssembly.fstore_3: U get() {
    instructions.add(VarInsnNode(FSTORE, 3))
}

/**
 * Store a double from the stack into slot 3.
 *
 * D -> (no stack produced)
 */
public val InstructionAssembly.dstore_3: U get() {
    instructions.add(VarInsnNode(DSTORE, 3))
}

/**
 * Store an object from the stack into slot 3.
 *
 * A -> (no stack produced)
 */
public val InstructionAssembly.astore_3: U get() {
    instructions.add(VarInsnNode(ASTORE, 3))
}
