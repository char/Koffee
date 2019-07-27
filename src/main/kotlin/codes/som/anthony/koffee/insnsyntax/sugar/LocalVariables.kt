package codes.som.anthony.koffee.insnsyntax.sugar

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.VarInsnNode

fun InsnASM.load(slot: Int, type: Type) {
    instructions.add(VarInsnNode(type.getOpcode(ILOAD), slot))
}

fun InsnASM.store(slot: Int, type: Type) {
    instructions.add(VarInsnNode(type.getOpcode(ISTORE), slot))
}

fun InsnASM.aload(type: Type) {
    instructions.add(InsnNode(type.getOpcode(IALOAD)))
}

fun InsnASM.astore(type: Type) {
    instructions.add(InsnNode(type.getOpcode(IASTORE)))
}
