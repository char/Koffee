package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.*

public val InstructionAssembly.iadd: U get() {
    instructions.add(InsnNode(IADD))
}
public val InstructionAssembly.ladd: U get() {
    instructions.add(InsnNode(LADD))
}
public val InstructionAssembly.fadd: U get() {
    instructions.add(InsnNode(FADD))
}
public val InstructionAssembly.dadd: U get() {
    instructions.add(InsnNode(DADD))
}
public val InstructionAssembly.isub: U get() {
    instructions.add(InsnNode(ISUB))
}
public val InstructionAssembly.lsub: U get() {
    instructions.add(InsnNode(LSUB))
}
public val InstructionAssembly.fsub: U get() {
    instructions.add(InsnNode(FSUB))
}
public val InstructionAssembly.dsub: U get() {
    instructions.add(InsnNode(DSUB))
}
public val InstructionAssembly.imul: U get() {
    instructions.add(InsnNode(IMUL))
}
public val InstructionAssembly.lmul: U get() {
    instructions.add(InsnNode(LMUL))
}
public val InstructionAssembly.fmul: U get() {
    instructions.add(InsnNode(FMUL))
}
public val InstructionAssembly.dmul: U get() {
    instructions.add(InsnNode(DMUL))
}
public val InstructionAssembly.idiv: U get() {
    instructions.add(InsnNode(IDIV))
}
public val InstructionAssembly.ldiv: U get() {
    instructions.add(InsnNode(LDIV))
}
public val InstructionAssembly.fdiv: U get() {
    instructions.add(InsnNode(FDIV))
}
public val InstructionAssembly.ddiv: U get() {
    instructions.add(InsnNode(DDIV))
}
public val InstructionAssembly.irem: U get() {
    instructions.add(InsnNode(IREM))
}
public val InstructionAssembly.lrem: U get() {
    instructions.add(InsnNode(LREM))
}
public val InstructionAssembly.frem: U get() {
    instructions.add(InsnNode(FREM))
}
public val InstructionAssembly.drem: U get() {
    instructions.add(InsnNode(DREM))
}
public val InstructionAssembly.ineg: U get() {
    instructions.add(InsnNode(INEG))
}
public val InstructionAssembly.lneg: U get() {
    instructions.add(InsnNode(LNEG))
}
public val InstructionAssembly.fneg: U get() {
    instructions.add(InsnNode(FNEG))
}
public val InstructionAssembly.dneg: U get() {
    instructions.add(InsnNode(DNEG))
}
public val InstructionAssembly.ishl: U get() {
    instructions.add(InsnNode(ISHL))
}
public val InstructionAssembly.lshl: U get() {
    instructions.add(InsnNode(LSHL))
}
public val InstructionAssembly.ishr: U get() {
    instructions.add(InsnNode(ISHR))
}
public val InstructionAssembly.lshr: U get() {
    instructions.add(InsnNode(LSHR))
}
public val InstructionAssembly.iushr: U get() {
    instructions.add(InsnNode(IUSHR))
}
public val InstructionAssembly.lushr: U get() {
    instructions.add(InsnNode(LUSHR))
}
public val InstructionAssembly.iand: U get() {
    instructions.add(InsnNode(IAND))
}
public val InstructionAssembly.land: U get() {
    instructions.add(InsnNode(LAND))
}
public val InstructionAssembly.ior: U get() {
    instructions.add(InsnNode(IOR))
}
public val InstructionAssembly.lor: U get() {
    instructions.add(InsnNode(LOR))
}
public val InstructionAssembly.ixor: U get() {
    instructions.add(InsnNode(IXOR))
}
public val InstructionAssembly.lxor: U get() {
    instructions.add(InsnNode(LXOR))
}
public fun InstructionAssembly.iinc(slot: Int) {
    instructions.add(IincInsnNode(slot, 1))
}
public fun InstructionAssembly.iinc(slot: Int, amount: Int) {
    instructions.add(IincInsnNode(slot, amount))
}
public val InstructionAssembly.i2l: U get() {
    instructions.add(InsnNode(I2L))
}
public val InstructionAssembly.i2f: U get() {
    instructions.add(InsnNode(I2F))
}
public val InstructionAssembly.i2d: U get() {
    instructions.add(InsnNode(I2D))
}
public val InstructionAssembly.l2i: U get() {
    instructions.add(InsnNode(L2I))
}
public val InstructionAssembly.l2f: U get() {
    instructions.add(InsnNode(L2F))
}
public val InstructionAssembly.l2d: U get() {
    instructions.add(InsnNode(L2D))
}
public val InstructionAssembly.f2i: U get() {
    instructions.add(InsnNode(F2I))
}
public val InstructionAssembly.f2l: U get() {
    instructions.add(InsnNode(F2L))
}
public val InstructionAssembly.f2d: U get() {
    instructions.add(InsnNode(F2D))
}
public val InstructionAssembly.d2i: U get() {
    instructions.add(InsnNode(D2I))
}
public val InstructionAssembly.d2l: U get() {
    instructions.add(InsnNode(D2L))
}
public val InstructionAssembly.d2f: U get() {
    instructions.add(InsnNode(D2F))
}
public val InstructionAssembly.i2b: U get() {
    instructions.add(InsnNode(I2B))
}
public val InstructionAssembly.i2c: U get() {
    instructions.add(InsnNode(I2C))
}
public val InstructionAssembly.i2s: U get() {
    instructions.add(InsnNode(I2S))
}
