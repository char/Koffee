package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.VarInsnNode

fun InsnASM.iload(slot: Int) {
    instructions.add(VarInsnNode(ILOAD, slot))
}
fun InsnASM.lload(slot: Int) {
    instructions.add(VarInsnNode(LLOAD, slot))
}
fun InsnASM.fload(slot: Int) {
    instructions.add(VarInsnNode(FLOAD, slot))
}
fun InsnASM.dload(slot: Int) {
    instructions.add(VarInsnNode(DLOAD, slot))
}
fun InsnASM.aload(slot: Int) {
    instructions.add(VarInsnNode(ALOAD, slot))
}
fun InsnASM.istore(slot: Int) {
    instructions.add(VarInsnNode(ISTORE, slot))
}
fun InsnASM.lstore(slot: Int) {
    instructions.add(VarInsnNode(LSTORE, slot))
}
fun InsnASM.fstore(slot: Int) {
    instructions.add(VarInsnNode(FSTORE, slot))
}
fun InsnASM.dstore(slot: Int) {
    instructions.add(VarInsnNode(DSTORE, slot))
}
fun InsnASM.astore(slot: Int) {
    instructions.add(VarInsnNode(ASTORE, slot))
}
val InsnASM.iload_0: U get() {
    instructions.add(VarInsnNode(ILOAD, 0))
}
val InsnASM.lload_0: U get() {
    instructions.add(VarInsnNode(LLOAD, 0))
}
val InsnASM.fload_0: U get() {
    instructions.add(VarInsnNode(FLOAD, 0))
}
val InsnASM.dload_0: U get() {
    instructions.add(VarInsnNode(DLOAD, 0))
}
val InsnASM.aload_0: U get() {
    instructions.add(VarInsnNode(ALOAD, 0))
}
val InsnASM.istore_0: U get() {
    instructions.add(VarInsnNode(ISTORE, 0))
}
val InsnASM.lstore_0: U get() {
    instructions.add(VarInsnNode(LSTORE, 0))
}
val InsnASM.fstore_0: U get() {
    instructions.add(VarInsnNode(FSTORE, 0))
}
val InsnASM.dstore_0: U get() {
    instructions.add(VarInsnNode(DSTORE, 0))
}
val InsnASM.astore_0: U get() {
    instructions.add(VarInsnNode(ASTORE, 0))
}
val InsnASM.iload_1: U get() {
    instructions.add(VarInsnNode(ILOAD, 1))
}
val InsnASM.lload_1: U get() {
    instructions.add(VarInsnNode(LLOAD, 1))
}
val InsnASM.fload_1: U get() {
    instructions.add(VarInsnNode(FLOAD, 1))
}
val InsnASM.dload_1: U get() {
    instructions.add(VarInsnNode(DLOAD, 1))
}
val InsnASM.aload_1: U get() {
    instructions.add(VarInsnNode(ALOAD, 1))
}
val InsnASM.istore_1: U get() {
    instructions.add(VarInsnNode(ISTORE, 1))
}
val InsnASM.lstore_1: U get() {
    instructions.add(VarInsnNode(LSTORE, 1))
}
val InsnASM.fstore_1: U get() {
    instructions.add(VarInsnNode(FSTORE, 1))
}
val InsnASM.dstore_1: U get() {
    instructions.add(VarInsnNode(DSTORE, 1))
}
val InsnASM.astore_1: U get() {
    instructions.add(VarInsnNode(ASTORE, 1))
}
val InsnASM.iload_2: U get() {
    instructions.add(VarInsnNode(ILOAD, 2))
}
val InsnASM.lload_2: U get() {
    instructions.add(VarInsnNode(LLOAD, 2))
}
val InsnASM.fload_2: U get() {
    instructions.add(VarInsnNode(FLOAD, 2))
}
val InsnASM.dload_2: U get() {
    instructions.add(VarInsnNode(DLOAD, 2))
}
val InsnASM.aload_2: U get() {
    instructions.add(VarInsnNode(ALOAD, 2))
}
val InsnASM.istore_2: U get() {
    instructions.add(VarInsnNode(ISTORE, 2))
}
val InsnASM.lstore_2: U get() {
    instructions.add(VarInsnNode(LSTORE, 2))
}
val InsnASM.fstore_2: U get() {
    instructions.add(VarInsnNode(FSTORE, 2))
}
val InsnASM.dstore_2: U get() {
    instructions.add(VarInsnNode(DSTORE, 2))
}
val InsnASM.astore_2: U get() {
    instructions.add(VarInsnNode(ASTORE, 2))
}
val InsnASM.iload_3: U get() {
    instructions.add(VarInsnNode(ILOAD, 3))
}
val InsnASM.lload_3: U get() {
    instructions.add(VarInsnNode(LLOAD, 3))
}
val InsnASM.fload_3: U get() {
    instructions.add(VarInsnNode(FLOAD, 3))
}
val InsnASM.dload_3: U get() {
    instructions.add(VarInsnNode(DLOAD, 3))
}
val InsnASM.aload_3: U get() {
    instructions.add(VarInsnNode(ALOAD, 3))
}
val InsnASM.istore_3: U get() {
    instructions.add(VarInsnNode(ISTORE, 3))
}
val InsnASM.lstore_3: U get() {
    instructions.add(VarInsnNode(LSTORE, 3))
}
val InsnASM.fstore_3: U get() {
    instructions.add(VarInsnNode(FSTORE, 3))
}
val InsnASM.dstore_3: U get() {
    instructions.add(VarInsnNode(DSTORE, 3))
}
val InsnASM.astore_3: U get() {
    instructions.add(VarInsnNode(ASTORE, 3))
}
