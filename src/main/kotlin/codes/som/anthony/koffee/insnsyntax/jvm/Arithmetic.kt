package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.IincInsnNode
import org.objectweb.asm.tree.InsnNode

val ASM.iadd: U get() {
    instructions.add(InsnNode(IADD))
}
val ASM.ladd: U get() {
    instructions.add(InsnNode(LADD))
}
val ASM.fadd: U get() {
    instructions.add(InsnNode(FADD))
}
val ASM.dadd: U get() {
    instructions.add(InsnNode(DADD))
}
val ASM.isub: U get() {
    instructions.add(InsnNode(ISUB))
}
val ASM.lsub: U get() {
    instructions.add(InsnNode(LSUB))
}
val ASM.fsub: U get() {
    instructions.add(InsnNode(FSUB))
}
val ASM.dsub: U get() {
    instructions.add(InsnNode(DSUB))
}
val ASM.imul: U get() {
    instructions.add(InsnNode(IMUL))
}
val ASM.lmul: U get() {
    instructions.add(InsnNode(LMUL))
}
val ASM.fmul: U get() {
    instructions.add(InsnNode(FMUL))
}
val ASM.dmul: U get() {
    instructions.add(InsnNode(DMUL))
}
val ASM.idiv: U get() {
    instructions.add(InsnNode(IDIV))
}
val ASM.ldiv: U get() {
    instructions.add(InsnNode(LDIV))
}
val ASM.fdiv: U get() {
    instructions.add(InsnNode(FDIV))
}
val ASM.ddiv: U get() {
    instructions.add(InsnNode(DDIV))
}
val ASM.irem: U get() {
    instructions.add(InsnNode(IREM))
}
val ASM.lrem: U get() {
    instructions.add(InsnNode(LREM))
}
val ASM.frem: U get() {
    instructions.add(InsnNode(FREM))
}
val ASM.drem: U get() {
    instructions.add(InsnNode(DREM))
}
val ASM.ineg: U get() {
    instructions.add(InsnNode(INEG))
}
val ASM.lneg: U get() {
    instructions.add(InsnNode(LNEG))
}
val ASM.fneg: U get() {
    instructions.add(InsnNode(FNEG))
}
val ASM.dneg: U get() {
    instructions.add(InsnNode(DNEG))
}
val ASM.ishl: U get() {
    instructions.add(InsnNode(ISHL))
}
val ASM.lshl: U get() {
    instructions.add(InsnNode(LSHL))
}
val ASM.ishr: U get() {
    instructions.add(InsnNode(ISHR))
}
val ASM.lshr: U get() {
    instructions.add(InsnNode(LSHR))
}
val ASM.iushr: U get() {
    instructions.add(InsnNode(IUSHR))
}
val ASM.lushr: U get() {
    instructions.add(InsnNode(LUSHR))
}
val ASM.iand: U get() {
    instructions.add(InsnNode(IAND))
}
val ASM.land: U get() {
    instructions.add(InsnNode(LAND))
}
val ASM.ior: U get() {
    instructions.add(InsnNode(IOR))
}
val ASM.lor: U get() {
    instructions.add(InsnNode(LOR))
}
val ASM.ixor: U get() {
    instructions.add(InsnNode(IXOR))
}
val ASM.lxor: U get() {
    instructions.add(InsnNode(LXOR))
}
fun ASM.iinc(slot: Int) {
    instructions.add(IincInsnNode(slot, 1))
}
fun ASM.iinc(slot: Int, amount: Int) {
    instructions.add(IincInsnNode(slot, amount))
}
val ASM.i2l: U get() {
    instructions.add(InsnNode(I2L))
}
val ASM.i2f: U get() {
    instructions.add(InsnNode(I2F))
}
val ASM.i2d: U get() {
    instructions.add(InsnNode(I2D))
}
val ASM.l2i: U get() {
    instructions.add(InsnNode(L2I))
}
val ASM.l2f: U get() {
    instructions.add(InsnNode(L2F))
}
val ASM.l2d: U get() {
    instructions.add(InsnNode(L2D))
}
val ASM.f2i: U get() {
    instructions.add(InsnNode(F2I))
}
val ASM.f2l: U get() {
    instructions.add(InsnNode(F2L))
}
val ASM.f2d: U get() {
    instructions.add(InsnNode(F2D))
}
val ASM.d2i: U get() {
    instructions.add(InsnNode(D2I))
}
val ASM.d2l: U get() {
    instructions.add(InsnNode(D2L))
}
val ASM.d2f: U get() {
    instructions.add(InsnNode(D2F))
}
val ASM.i2b: U get() {
    instructions.add(InsnNode(I2B))
}
val ASM.i2c: U get() {
    instructions.add(InsnNode(I2C))
}
val ASM.i2s: U get() {
    instructions.add(InsnNode(I2S))
}
