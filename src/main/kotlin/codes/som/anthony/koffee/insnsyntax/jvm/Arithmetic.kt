package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.IincInsnNode
import org.objectweb.asm.tree.InsnNode

val InsnASM.iadd: U get() {
    instructions.add(InsnNode(IADD))
}
val InsnASM.ladd: U get() {
    instructions.add(InsnNode(LADD))
}
val InsnASM.fadd: U get() {
    instructions.add(InsnNode(FADD))
}
val InsnASM.dadd: U get() {
    instructions.add(InsnNode(DADD))
}
val InsnASM.isub: U get() {
    instructions.add(InsnNode(ISUB))
}
val InsnASM.lsub: U get() {
    instructions.add(InsnNode(LSUB))
}
val InsnASM.fsub: U get() {
    instructions.add(InsnNode(FSUB))
}
val InsnASM.dsub: U get() {
    instructions.add(InsnNode(DSUB))
}
val InsnASM.imul: U get() {
    instructions.add(InsnNode(IMUL))
}
val InsnASM.lmul: U get() {
    instructions.add(InsnNode(LMUL))
}
val InsnASM.fmul: U get() {
    instructions.add(InsnNode(FMUL))
}
val InsnASM.dmul: U get() {
    instructions.add(InsnNode(DMUL))
}
val InsnASM.idiv: U get() {
    instructions.add(InsnNode(IDIV))
}
val InsnASM.ldiv: U get() {
    instructions.add(InsnNode(LDIV))
}
val InsnASM.fdiv: U get() {
    instructions.add(InsnNode(FDIV))
}
val InsnASM.ddiv: U get() {
    instructions.add(InsnNode(DDIV))
}
val InsnASM.irem: U get() {
    instructions.add(InsnNode(IREM))
}
val InsnASM.lrem: U get() {
    instructions.add(InsnNode(LREM))
}
val InsnASM.frem: U get() {
    instructions.add(InsnNode(FREM))
}
val InsnASM.drem: U get() {
    instructions.add(InsnNode(DREM))
}
val InsnASM.ineg: U get() {
    instructions.add(InsnNode(INEG))
}
val InsnASM.lneg: U get() {
    instructions.add(InsnNode(LNEG))
}
val InsnASM.fneg: U get() {
    instructions.add(InsnNode(FNEG))
}
val InsnASM.dneg: U get() {
    instructions.add(InsnNode(DNEG))
}
val InsnASM.ishl: U get() {
    instructions.add(InsnNode(ISHL))
}
val InsnASM.lshl: U get() {
    instructions.add(InsnNode(LSHL))
}
val InsnASM.ishr: U get() {
    instructions.add(InsnNode(ISHR))
}
val InsnASM.lshr: U get() {
    instructions.add(InsnNode(LSHR))
}
val InsnASM.iushr: U get() {
    instructions.add(InsnNode(IUSHR))
}
val InsnASM.lushr: U get() {
    instructions.add(InsnNode(LUSHR))
}
val InsnASM.iand: U get() {
    instructions.add(InsnNode(IAND))
}
val InsnASM.land: U get() {
    instructions.add(InsnNode(LAND))
}
val InsnASM.ior: U get() {
    instructions.add(InsnNode(IOR))
}
val InsnASM.lor: U get() {
    instructions.add(InsnNode(LOR))
}
val InsnASM.ixor: U get() {
    instructions.add(InsnNode(IXOR))
}
val InsnASM.lxor: U get() {
    instructions.add(InsnNode(LXOR))
}
fun InsnASM.iinc(slot: Int) {
    instructions.add(IincInsnNode(slot, 1))
}
fun InsnASM.iinc(slot: Int, amount: Int) {
    instructions.add(IincInsnNode(slot, amount))
}
val InsnASM.i2l: U get() {
    instructions.add(InsnNode(I2L))
}
val InsnASM.i2f: U get() {
    instructions.add(InsnNode(I2F))
}
val InsnASM.i2d: U get() {
    instructions.add(InsnNode(I2D))
}
val InsnASM.l2i: U get() {
    instructions.add(InsnNode(L2I))
}
val InsnASM.l2f: U get() {
    instructions.add(InsnNode(L2F))
}
val InsnASM.l2d: U get() {
    instructions.add(InsnNode(L2D))
}
val InsnASM.f2i: U get() {
    instructions.add(InsnNode(F2I))
}
val InsnASM.f2l: U get() {
    instructions.add(InsnNode(F2L))
}
val InsnASM.f2d: U get() {
    instructions.add(InsnNode(F2D))
}
val InsnASM.d2i: U get() {
    instructions.add(InsnNode(D2I))
}
val InsnASM.d2l: U get() {
    instructions.add(InsnNode(D2L))
}
val InsnASM.d2f: U get() {
    instructions.add(InsnNode(D2F))
}
val InsnASM.i2b: U get() {
    instructions.add(InsnNode(I2B))
}
val InsnASM.i2c: U get() {
    instructions.add(InsnNode(I2C))
}
val InsnASM.i2s: U get() {
    instructions.add(InsnNode(I2S))
}
