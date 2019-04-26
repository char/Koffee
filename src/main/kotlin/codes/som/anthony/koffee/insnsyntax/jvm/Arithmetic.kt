package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.IincInsnNode
import org.objectweb.asm.tree.InsnNode

val ASM.iadd: U get() {
    node.instructions.add(InsnNode(IADD))
}
val ASM.ladd: U get() {
    node.instructions.add(InsnNode(LADD))
}
val ASM.fadd: U get() {
    node.instructions.add(InsnNode(FADD))
}
val ASM.dadd: U get() {
    node.instructions.add(InsnNode(DADD))
}
val ASM.isub: U get() {
    node.instructions.add(InsnNode(ISUB))
}
val ASM.lsub: U get() {
    node.instructions.add(InsnNode(LSUB))
}
val ASM.fsub: U get() {
    node.instructions.add(InsnNode(FSUB))
}
val ASM.dsub: U get() {
    node.instructions.add(InsnNode(DSUB))
}
val ASM.imul: U get() {
    node.instructions.add(InsnNode(IMUL))
}
val ASM.lmul: U get() {
    node.instructions.add(InsnNode(LMUL))
}
val ASM.fmul: U get() {
    node.instructions.add(InsnNode(FMUL))
}
val ASM.dmul: U get() {
    node.instructions.add(InsnNode(DMUL))
}
val ASM.idiv: U get() {
    node.instructions.add(InsnNode(IDIV))
}
val ASM.ldiv: U get() {
    node.instructions.add(InsnNode(LDIV))
}
val ASM.fdiv: U get() {
    node.instructions.add(InsnNode(FDIV))
}
val ASM.ddiv: U get() {
    node.instructions.add(InsnNode(DDIV))
}
val ASM.irem: U get() {
    node.instructions.add(InsnNode(IREM))
}
val ASM.lrem: U get() {
    node.instructions.add(InsnNode(LREM))
}
val ASM.frem: U get() {
    node.instructions.add(InsnNode(FREM))
}
val ASM.drem: U get() {
    node.instructions.add(InsnNode(DREM))
}
val ASM.ineg: U get() {
    node.instructions.add(InsnNode(INEG))
}
val ASM.lneg: U get() {
    node.instructions.add(InsnNode(LNEG))
}
val ASM.fneg: U get() {
    node.instructions.add(InsnNode(FNEG))
}
val ASM.dneg: U get() {
    node.instructions.add(InsnNode(DNEG))
}
val ASM.ishl: U get() {
    node.instructions.add(InsnNode(ISHL))
}
val ASM.lshl: U get() {
    node.instructions.add(InsnNode(LSHL))
}
val ASM.ishr: U get() {
    node.instructions.add(InsnNode(ISHR))
}
val ASM.lshr: U get() {
    node.instructions.add(InsnNode(LSHR))
}
val ASM.iushr: U get() {
    node.instructions.add(InsnNode(IUSHR))
}
val ASM.lushr: U get() {
    node.instructions.add(InsnNode(LUSHR))
}
val ASM.iand: U get() {
    node.instructions.add(InsnNode(IAND))
}
val ASM.land: U get() {
    node.instructions.add(InsnNode(LAND))
}
val ASM.ior: U get() {
    node.instructions.add(InsnNode(IOR))
}
val ASM.lor: U get() {
    node.instructions.add(InsnNode(LOR))
}
val ASM.ixor: U get() {
    node.instructions.add(InsnNode(IXOR))
}
val ASM.lxor: U get() {
    node.instructions.add(InsnNode(LXOR))
}
val ASM.iinc: U get() {
    node.instructions.add(IincInsnNode(IINC, 1))
}
fun ASM.iinc(amount: Int) {
    node.instructions.add(IincInsnNode(IINC, amount))
}
val ASM.i2l: U get() {
    node.instructions.add(InsnNode(I2L))
}
val ASM.i2f: U get() {
    node.instructions.add(InsnNode(I2F))
}
val ASM.i2d: U get() {
    node.instructions.add(InsnNode(I2D))
}
val ASM.l2i: U get() {
    node.instructions.add(InsnNode(L2I))
}
val ASM.l2f: U get() {
    node.instructions.add(InsnNode(L2F))
}
val ASM.l2d: U get() {
    node.instructions.add(InsnNode(L2D))
}
val ASM.f2i: U get() {
    node.instructions.add(InsnNode(F2I))
}
val ASM.f2l: U get() {
    node.instructions.add(InsnNode(F2L))
}
val ASM.f2d: U get() {
    node.instructions.add(InsnNode(F2D))
}
val ASM.d2i: U get() {
    node.instructions.add(InsnNode(D2I))
}
val ASM.d2l: U get() {
    node.instructions.add(InsnNode(D2L))
}
val ASM.d2f: U get() {
    node.instructions.add(InsnNode(D2F))
}
val ASM.i2b: U get() {
    node.instructions.add(InsnNode(I2B))
}
val ASM.i2c: U get() {
    node.instructions.add(InsnNode(I2C))
}
val ASM.i2s: U get() {
    node.instructions.add(InsnNode(I2S))
}
val ASM.lcmp: U get() {
    node.instructions.add(InsnNode(LCMP))
}
val ASM.fcmpl: U get() {
    node.instructions.add(InsnNode(FCMPL))
}
val ASM.fcmpg: U get() {
    node.instructions.add(InsnNode(FCMPG))
}
val ASM.dcmpl: U get() {
    node.instructions.add(InsnNode(DCMPL))
}
val ASM.dcmpg: U get() {
    node.instructions.add(InsnNode(DCMPG))
}
