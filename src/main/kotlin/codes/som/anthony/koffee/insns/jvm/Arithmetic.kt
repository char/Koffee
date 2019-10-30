package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.*

val InstructionAssembly.iadd: U get() {
    instructions.add(InsnNode(IADD))
}
val InstructionAssembly.ladd: U get() {
    instructions.add(InsnNode(LADD))
}
val InstructionAssembly.fadd: U get() {
    instructions.add(InsnNode(FADD))
}
val InstructionAssembly.dadd: U get() {
    instructions.add(InsnNode(DADD))
}
val InstructionAssembly.isub: U get() {
    instructions.add(InsnNode(ISUB))
}
val InstructionAssembly.lsub: U get() {
    instructions.add(InsnNode(LSUB))
}
val InstructionAssembly.fsub: U get() {
    instructions.add(InsnNode(FSUB))
}
val InstructionAssembly.dsub: U get() {
    instructions.add(InsnNode(DSUB))
}
val InstructionAssembly.imul: U get() {
    instructions.add(InsnNode(IMUL))
}
val InstructionAssembly.lmul: U get() {
    instructions.add(InsnNode(LMUL))
}
val InstructionAssembly.fmul: U get() {
    instructions.add(InsnNode(FMUL))
}
val InstructionAssembly.dmul: U get() {
    instructions.add(InsnNode(DMUL))
}
val InstructionAssembly.idiv: U get() {
    instructions.add(InsnNode(IDIV))
}
val InstructionAssembly.ldiv: U get() {
    instructions.add(InsnNode(LDIV))
}
val InstructionAssembly.fdiv: U get() {
    instructions.add(InsnNode(FDIV))
}
val InstructionAssembly.ddiv: U get() {
    instructions.add(InsnNode(DDIV))
}
val InstructionAssembly.irem: U get() {
    instructions.add(InsnNode(IREM))
}
val InstructionAssembly.lrem: U get() {
    instructions.add(InsnNode(LREM))
}
val InstructionAssembly.frem: U get() {
    instructions.add(InsnNode(FREM))
}
val InstructionAssembly.drem: U get() {
    instructions.add(InsnNode(DREM))
}
val InstructionAssembly.ineg: U get() {
    instructions.add(InsnNode(INEG))
}
val InstructionAssembly.lneg: U get() {
    instructions.add(InsnNode(LNEG))
}
val InstructionAssembly.fneg: U get() {
    instructions.add(InsnNode(FNEG))
}
val InstructionAssembly.dneg: U get() {
    instructions.add(InsnNode(DNEG))
}
val InstructionAssembly.ishl: U get() {
    instructions.add(InsnNode(ISHL))
}
val InstructionAssembly.lshl: U get() {
    instructions.add(InsnNode(LSHL))
}
val InstructionAssembly.ishr: U get() {
    instructions.add(InsnNode(ISHR))
}
val InstructionAssembly.lshr: U get() {
    instructions.add(InsnNode(LSHR))
}
val InstructionAssembly.iushr: U get() {
    instructions.add(InsnNode(IUSHR))
}
val InstructionAssembly.lushr: U get() {
    instructions.add(InsnNode(LUSHR))
}
val InstructionAssembly.iand: U get() {
    instructions.add(InsnNode(IAND))
}
val InstructionAssembly.land: U get() {
    instructions.add(InsnNode(LAND))
}
val InstructionAssembly.ior: U get() {
    instructions.add(InsnNode(IOR))
}
val InstructionAssembly.lor: U get() {
    instructions.add(InsnNode(LOR))
}
val InstructionAssembly.ixor: U get() {
    instructions.add(InsnNode(IXOR))
}
val InstructionAssembly.lxor: U get() {
    instructions.add(InsnNode(LXOR))
}
fun InstructionAssembly.iinc(slot: Int) {
    instructions.add(IincInsnNode(slot, 1))
}
fun InstructionAssembly.iinc(slot: Int, amount: Int) {
    instructions.add(IincInsnNode(slot, amount))
}
val InstructionAssembly.i2l: U get() {
    instructions.add(InsnNode(I2L))
}
val InstructionAssembly.i2f: U get() {
    instructions.add(InsnNode(I2F))
}
val InstructionAssembly.i2d: U get() {
    instructions.add(InsnNode(I2D))
}
val InstructionAssembly.l2i: U get() {
    instructions.add(InsnNode(L2I))
}
val InstructionAssembly.l2f: U get() {
    instructions.add(InsnNode(L2F))
}
val InstructionAssembly.l2d: U get() {
    instructions.add(InsnNode(L2D))
}
val InstructionAssembly.f2i: U get() {
    instructions.add(InsnNode(F2I))
}
val InstructionAssembly.f2l: U get() {
    instructions.add(InsnNode(F2L))
}
val InstructionAssembly.f2d: U get() {
    instructions.add(InsnNode(F2D))
}
val InstructionAssembly.d2i: U get() {
    instructions.add(InsnNode(D2I))
}
val InstructionAssembly.d2l: U get() {
    instructions.add(InsnNode(D2L))
}
val InstructionAssembly.d2f: U get() {
    instructions.add(InsnNode(D2F))
}
val InstructionAssembly.i2b: U get() {
    instructions.add(InsnNode(I2B))
}
val InstructionAssembly.i2c: U get() {
    instructions.add(InsnNode(I2C))
}
val InstructionAssembly.i2s: U get() {
    instructions.add(InsnNode(I2S))
}
