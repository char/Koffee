package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.LdcInsnNode

val ASM.aconst_null: U get() {
    instructions.add(InsnNode(ACONST_NULL))
}
val ASM.iconst_m1: U get() {
    instructions.add(InsnNode(ICONST_M1))
}
val ASM.iconst_0: U get() {
    instructions.add(InsnNode(ICONST_0))
}
val ASM.iconst_1: U get() {
    instructions.add(InsnNode(ICONST_1))
}
val ASM.iconst_2: U get() {
    instructions.add(InsnNode(ICONST_2))
}
val ASM.iconst_3: U get() {
    instructions.add(InsnNode(ICONST_3))
}
val ASM.iconst_4: U get() {
    instructions.add(InsnNode(ICONST_4))
}
val ASM.iconst_5: U get() {
    instructions.add(InsnNode(ICONST_5))
}
val ASM.lconst_0: U get() {
    instructions.add(InsnNode(LCONST_0))
}
val ASM.lconst_1: U get() {
    instructions.add(InsnNode(LCONST_1))
}
val ASM.fconst_0: U get() {
    instructions.add(InsnNode(FCONST_0))
}
val ASM.fconst_1: U get() {
    instructions.add(InsnNode(FCONST_1))
}
val ASM.fconst_2: U get() {
    instructions.add(InsnNode(FCONST_2))
}
val ASM.dconst_0: U get() {
    instructions.add(InsnNode(DCONST_0))
}
val ASM.dconst_1: U get() {
    instructions.add(InsnNode(DCONST_1))
}
fun ASM.bipush(v: Int) {
    instructions.add(IntInsnNode(BIPUSH, v))
}
fun ASM.sipush(v: Int) {
    instructions.add(IntInsnNode(SIPUSH, v))
}
fun ASM.ldc(v: Any) {
    instructions.add(LdcInsnNode(v))
}
