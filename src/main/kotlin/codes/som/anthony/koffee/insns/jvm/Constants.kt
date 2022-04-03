@file:Suppress("unused") // Receivers used to avoid scope pollution

package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.ConstantDynamic
import org.objectweb.asm.Handle
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.LdcInsnNode

public val InstructionAssembly.aconst_null: U get() {
    instructions.add(InsnNode(ACONST_NULL))
}
public val InstructionAssembly.iconst_m1: U get() {
    instructions.add(InsnNode(ICONST_M1))
}
public val InstructionAssembly.iconst_0: U get() {
    instructions.add(InsnNode(ICONST_0))
}
public val InstructionAssembly.iconst_1: U get() {
    instructions.add(InsnNode(ICONST_1))
}
public val InstructionAssembly.iconst_2: U get() {
    instructions.add(InsnNode(ICONST_2))
}
public val InstructionAssembly.iconst_3: U get() {
    instructions.add(InsnNode(ICONST_3))
}
public val InstructionAssembly.iconst_4: U get() {
    instructions.add(InsnNode(ICONST_4))
}
public val InstructionAssembly.iconst_5: U get() {
    instructions.add(InsnNode(ICONST_5))
}
public val InstructionAssembly.lconst_0: U get() {
    instructions.add(InsnNode(LCONST_0))
}
public val InstructionAssembly.lconst_1: U get() {
    instructions.add(InsnNode(LCONST_1))
}
public val InstructionAssembly.fconst_0: U get() {
    instructions.add(InsnNode(FCONST_0))
}
public val InstructionAssembly.fconst_1: U get() {
    instructions.add(InsnNode(FCONST_1))
}
public val InstructionAssembly.fconst_2: U get() {
    instructions.add(InsnNode(FCONST_2))
}
public val InstructionAssembly.dconst_0: U get() {
    instructions.add(InsnNode(DCONST_0))
}
public val InstructionAssembly.dconst_1: U get() {
    instructions.add(InsnNode(DCONST_1))
}
public fun InstructionAssembly.bipush(v: Int) {
    instructions.add(IntInsnNode(BIPUSH, v))
}
public fun InstructionAssembly.sipush(v: Int) {
    instructions.add(IntInsnNode(SIPUSH, v))
}
public fun InstructionAssembly.ldc(v: Any) {
    instructions.add(LdcInsnNode(v))
}
public fun InstructionAssembly.constantDynamic(name: String, type: TypeLike, handle: Handle, vararg boostrapMethodArguments: Any): ConstantDynamic {
    return ConstantDynamic(name, coerceType(type).descriptor, handle, boostrapMethodArguments)
}
