package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.LdcInsnNode

val InstructionAssembly.aconst_null: U get() {
    instructions.add(InsnNode(ACONST_NULL))
}
val InstructionAssembly.iconst_m1: U get() {
    instructions.add(InsnNode(ICONST_M1))
}
val InstructionAssembly.iconst_0: U get() {
    instructions.add(InsnNode(ICONST_0))
}
val InstructionAssembly.iconst_1: U get() {
    instructions.add(InsnNode(ICONST_1))
}
val InstructionAssembly.iconst_2: U get() {
    instructions.add(InsnNode(ICONST_2))
}
val InstructionAssembly.iconst_3: U get() {
    instructions.add(InsnNode(ICONST_3))
}
val InstructionAssembly.iconst_4: U get() {
    instructions.add(InsnNode(ICONST_4))
}
val InstructionAssembly.iconst_5: U get() {
    instructions.add(InsnNode(ICONST_5))
}
val InstructionAssembly.lconst_0: U get() {
    instructions.add(InsnNode(LCONST_0))
}
val InstructionAssembly.lconst_1: U get() {
    instructions.add(InsnNode(LCONST_1))
}
val InstructionAssembly.fconst_0: U get() {
    instructions.add(InsnNode(FCONST_0))
}
val InstructionAssembly.fconst_1: U get() {
    instructions.add(InsnNode(FCONST_1))
}
val InstructionAssembly.fconst_2: U get() {
    instructions.add(InsnNode(FCONST_2))
}
val InstructionAssembly.dconst_0: U get() {
    instructions.add(InsnNode(DCONST_0))
}
val InstructionAssembly.dconst_1: U get() {
    instructions.add(InsnNode(DCONST_1))
}
fun InstructionAssembly.bipush(v: Int) {
    instructions.add(IntInsnNode(BIPUSH, v))
}
fun InstructionAssembly.sipush(v: Int) {
    instructions.add(IntInsnNode(SIPUSH, v))
}
fun InstructionAssembly.ldc(v: Any) {
    instructions.add(LdcInsnNode(v))
}
