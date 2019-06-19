package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.LdcInsnNode

val InsnASM.aconst_null: U get() {
    instructions.add(InsnNode(ACONST_NULL))
}
val InsnASM.iconst_m1: U get() {
    instructions.add(InsnNode(ICONST_M1))
}
val InsnASM.iconst_0: U get() {
    instructions.add(InsnNode(ICONST_0))
}
val InsnASM.iconst_1: U get() {
    instructions.add(InsnNode(ICONST_1))
}
val InsnASM.iconst_2: U get() {
    instructions.add(InsnNode(ICONST_2))
}
val InsnASM.iconst_3: U get() {
    instructions.add(InsnNode(ICONST_3))
}
val InsnASM.iconst_4: U get() {
    instructions.add(InsnNode(ICONST_4))
}
val InsnASM.iconst_5: U get() {
    instructions.add(InsnNode(ICONST_5))
}
val InsnASM.lconst_0: U get() {
    instructions.add(InsnNode(LCONST_0))
}
val InsnASM.lconst_1: U get() {
    instructions.add(InsnNode(LCONST_1))
}
val InsnASM.fconst_0: U get() {
    instructions.add(InsnNode(FCONST_0))
}
val InsnASM.fconst_1: U get() {
    instructions.add(InsnNode(FCONST_1))
}
val InsnASM.fconst_2: U get() {
    instructions.add(InsnNode(FCONST_2))
}
val InsnASM.dconst_0: U get() {
    instructions.add(InsnNode(DCONST_0))
}
val InsnASM.dconst_1: U get() {
    instructions.add(InsnNode(DCONST_1))
}
fun InsnASM.bipush(v: Int) {
    instructions.add(IntInsnNode(BIPUSH, v))
}
fun InsnASM.sipush(v: Int) {
    instructions.add(IntInsnNode(SIPUSH, v))
}
fun InsnASM.ldc(v: Any) {
    instructions.add(LdcInsnNode(v))
}
