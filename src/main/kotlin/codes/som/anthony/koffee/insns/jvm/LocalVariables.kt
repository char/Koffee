package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.VarInsnNode

fun InstructionAssembly.iload(slot: Int) {
    instructions.add(VarInsnNode(ILOAD, slot))
}
fun InstructionAssembly.lload(slot: Int) {
    instructions.add(VarInsnNode(LLOAD, slot))
}
fun InstructionAssembly.fload(slot: Int) {
    instructions.add(VarInsnNode(FLOAD, slot))
}
fun InstructionAssembly.dload(slot: Int) {
    instructions.add(VarInsnNode(DLOAD, slot))
}
fun InstructionAssembly.aload(slot: Int) {
    instructions.add(VarInsnNode(ALOAD, slot))
}
fun InstructionAssembly.istore(slot: Int) {
    instructions.add(VarInsnNode(ISTORE, slot))
}
fun InstructionAssembly.lstore(slot: Int) {
    instructions.add(VarInsnNode(LSTORE, slot))
}
fun InstructionAssembly.fstore(slot: Int) {
    instructions.add(VarInsnNode(FSTORE, slot))
}
fun InstructionAssembly.dstore(slot: Int) {
    instructions.add(VarInsnNode(DSTORE, slot))
}
fun InstructionAssembly.astore(slot: Int) {
    instructions.add(VarInsnNode(ASTORE, slot))
}
val InstructionAssembly.iload_0: U get() {
    instructions.add(VarInsnNode(ILOAD, 0))
}
val InstructionAssembly.lload_0: U get() {
    instructions.add(VarInsnNode(LLOAD, 0))
}
val InstructionAssembly.fload_0: U get() {
    instructions.add(VarInsnNode(FLOAD, 0))
}
val InstructionAssembly.dload_0: U get() {
    instructions.add(VarInsnNode(DLOAD, 0))
}
val InstructionAssembly.aload_0: U get() {
    instructions.add(VarInsnNode(ALOAD, 0))
}
val InstructionAssembly.istore_0: U get() {
    instructions.add(VarInsnNode(ISTORE, 0))
}
val InstructionAssembly.lstore_0: U get() {
    instructions.add(VarInsnNode(LSTORE, 0))
}
val InstructionAssembly.fstore_0: U get() {
    instructions.add(VarInsnNode(FSTORE, 0))
}
val InstructionAssembly.dstore_0: U get() {
    instructions.add(VarInsnNode(DSTORE, 0))
}
val InstructionAssembly.astore_0: U get() {
    instructions.add(VarInsnNode(ASTORE, 0))
}
val InstructionAssembly.iload_1: U get() {
    instructions.add(VarInsnNode(ILOAD, 1))
}
val InstructionAssembly.lload_1: U get() {
    instructions.add(VarInsnNode(LLOAD, 1))
}
val InstructionAssembly.fload_1: U get() {
    instructions.add(VarInsnNode(FLOAD, 1))
}
val InstructionAssembly.dload_1: U get() {
    instructions.add(VarInsnNode(DLOAD, 1))
}
val InstructionAssembly.aload_1: U get() {
    instructions.add(VarInsnNode(ALOAD, 1))
}
val InstructionAssembly.istore_1: U get() {
    instructions.add(VarInsnNode(ISTORE, 1))
}
val InstructionAssembly.lstore_1: U get() {
    instructions.add(VarInsnNode(LSTORE, 1))
}
val InstructionAssembly.fstore_1: U get() {
    instructions.add(VarInsnNode(FSTORE, 1))
}
val InstructionAssembly.dstore_1: U get() {
    instructions.add(VarInsnNode(DSTORE, 1))
}
val InstructionAssembly.astore_1: U get() {
    instructions.add(VarInsnNode(ASTORE, 1))
}
val InstructionAssembly.iload_2: U get() {
    instructions.add(VarInsnNode(ILOAD, 2))
}
val InstructionAssembly.lload_2: U get() {
    instructions.add(VarInsnNode(LLOAD, 2))
}
val InstructionAssembly.fload_2: U get() {
    instructions.add(VarInsnNode(FLOAD, 2))
}
val InstructionAssembly.dload_2: U get() {
    instructions.add(VarInsnNode(DLOAD, 2))
}
val InstructionAssembly.aload_2: U get() {
    instructions.add(VarInsnNode(ALOAD, 2))
}
val InstructionAssembly.istore_2: U get() {
    instructions.add(VarInsnNode(ISTORE, 2))
}
val InstructionAssembly.lstore_2: U get() {
    instructions.add(VarInsnNode(LSTORE, 2))
}
val InstructionAssembly.fstore_2: U get() {
    instructions.add(VarInsnNode(FSTORE, 2))
}
val InstructionAssembly.dstore_2: U get() {
    instructions.add(VarInsnNode(DSTORE, 2))
}
val InstructionAssembly.astore_2: U get() {
    instructions.add(VarInsnNode(ASTORE, 2))
}
val InstructionAssembly.iload_3: U get() {
    instructions.add(VarInsnNode(ILOAD, 3))
}
val InstructionAssembly.lload_3: U get() {
    instructions.add(VarInsnNode(LLOAD, 3))
}
val InstructionAssembly.fload_3: U get() {
    instructions.add(VarInsnNode(FLOAD, 3))
}
val InstructionAssembly.dload_3: U get() {
    instructions.add(VarInsnNode(DLOAD, 3))
}
val InstructionAssembly.aload_3: U get() {
    instructions.add(VarInsnNode(ALOAD, 3))
}
val InstructionAssembly.istore_3: U get() {
    instructions.add(VarInsnNode(ISTORE, 3))
}
val InstructionAssembly.lstore_3: U get() {
    instructions.add(VarInsnNode(LSTORE, 3))
}
val InstructionAssembly.fstore_3: U get() {
    instructions.add(VarInsnNode(FSTORE, 3))
}
val InstructionAssembly.dstore_3: U get() {
    instructions.add(VarInsnNode(DSTORE, 3))
}
val InstructionAssembly.astore_3: U get() {
    instructions.add(VarInsnNode(ASTORE, 3))
}
