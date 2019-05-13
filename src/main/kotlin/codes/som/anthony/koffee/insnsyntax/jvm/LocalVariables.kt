package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.VarInsnNode

fun ASM.iload(slot: Int) {
    instructions.add(VarInsnNode(ILOAD, slot))
}
fun ASM.lload(slot: Int) {
    instructions.add(VarInsnNode(LLOAD, slot))
}
fun ASM.fload(slot: Int) {
    instructions.add(VarInsnNode(FLOAD, slot))
}
fun ASM.dload(slot: Int) {
    instructions.add(VarInsnNode(DLOAD, slot))
}
fun ASM.aload(slot: Int) {
    instructions.add(VarInsnNode(ALOAD, slot))
}
fun ASM.istore(slot: Int) {
    instructions.add(VarInsnNode(ISTORE, slot))
}
fun ASM.lstore(slot: Int) {
    instructions.add(VarInsnNode(LSTORE, slot))
}
fun ASM.fstore(slot: Int) {
    instructions.add(VarInsnNode(FSTORE, slot))
}
fun ASM.dstore(slot: Int) {
    instructions.add(VarInsnNode(DSTORE, slot))
}
fun ASM.astore(slot: Int) {
    instructions.add(VarInsnNode(ASTORE, slot))
}
val ASM.iload_0: U get() {
    instructions.add(VarInsnNode(ILOAD, 0))
}
val ASM.lload_0: U get() {
    instructions.add(VarInsnNode(LLOAD, 0))
}
val ASM.fload_0: U get() {
    instructions.add(VarInsnNode(FLOAD, 0))
}
val ASM.dload_0: U get() {
    instructions.add(VarInsnNode(DLOAD, 0))
}
val ASM.aload_0: U get() {
    instructions.add(VarInsnNode(ALOAD, 0))
}
val ASM.istore_0: U get() {
    instructions.add(VarInsnNode(ISTORE, 0))
}
val ASM.lstore_0: U get() {
    instructions.add(VarInsnNode(LSTORE, 0))
}
val ASM.fstore_0: U get() {
    instructions.add(VarInsnNode(FSTORE, 0))
}
val ASM.dstore_0: U get() {
    instructions.add(VarInsnNode(DSTORE, 0))
}
val ASM.astore_0: U get() {
    instructions.add(VarInsnNode(ASTORE, 0))
}
val ASM.iload_1: U get() {
    instructions.add(VarInsnNode(ILOAD, 1))
}
val ASM.lload_1: U get() {
    instructions.add(VarInsnNode(LLOAD, 1))
}
val ASM.fload_1: U get() {
    instructions.add(VarInsnNode(FLOAD, 1))
}
val ASM.dload_1: U get() {
    instructions.add(VarInsnNode(DLOAD, 1))
}
val ASM.aload_1: U get() {
    instructions.add(VarInsnNode(ALOAD, 1))
}
val ASM.istore_1: U get() {
    instructions.add(VarInsnNode(ISTORE, 1))
}
val ASM.lstore_1: U get() {
    instructions.add(VarInsnNode(LSTORE, 1))
}
val ASM.fstore_1: U get() {
    instructions.add(VarInsnNode(FSTORE, 1))
}
val ASM.dstore_1: U get() {
    instructions.add(VarInsnNode(DSTORE, 1))
}
val ASM.astore_1: U get() {
    instructions.add(VarInsnNode(ASTORE, 1))
}
val ASM.iload_2: U get() {
    instructions.add(VarInsnNode(ILOAD, 2))
}
val ASM.lload_2: U get() {
    instructions.add(VarInsnNode(LLOAD, 2))
}
val ASM.fload_2: U get() {
    instructions.add(VarInsnNode(FLOAD, 2))
}
val ASM.dload_2: U get() {
    instructions.add(VarInsnNode(DLOAD, 2))
}
val ASM.aload_2: U get() {
    instructions.add(VarInsnNode(ALOAD, 2))
}
val ASM.istore_2: U get() {
    instructions.add(VarInsnNode(ISTORE, 2))
}
val ASM.lstore_2: U get() {
    instructions.add(VarInsnNode(LSTORE, 2))
}
val ASM.fstore_2: U get() {
    instructions.add(VarInsnNode(FSTORE, 2))
}
val ASM.dstore_2: U get() {
    instructions.add(VarInsnNode(DSTORE, 2))
}
val ASM.astore_2: U get() {
    instructions.add(VarInsnNode(ASTORE, 2))
}
val ASM.iload_3: U get() {
    instructions.add(VarInsnNode(ILOAD, 3))
}
val ASM.lload_3: U get() {
    instructions.add(VarInsnNode(LLOAD, 3))
}
val ASM.fload_3: U get() {
    instructions.add(VarInsnNode(FLOAD, 3))
}
val ASM.dload_3: U get() {
    instructions.add(VarInsnNode(DLOAD, 3))
}
val ASM.aload_3: U get() {
    instructions.add(VarInsnNode(ALOAD, 3))
}
val ASM.istore_3: U get() {
    instructions.add(VarInsnNode(ISTORE, 3))
}
val ASM.lstore_3: U get() {
    instructions.add(VarInsnNode(LSTORE, 3))
}
val ASM.fstore_3: U get() {
    instructions.add(VarInsnNode(FSTORE, 3))
}
val ASM.dstore_3: U get() {
    instructions.add(VarInsnNode(DSTORE, 3))
}
val ASM.astore_3: U get() {
    instructions.add(VarInsnNode(ASTORE, 3))
}
