package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.FieldInsnNode

fun InsnASM.getstatic(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(GETSTATIC, owner.internalName, name, type.descriptor))
}
fun InsnASM.getfield(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(GETFIELD, owner.internalName, name, type.descriptor))
}
fun InsnASM.putstatic(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(PUTSTATIC, owner.internalName, name, type.descriptor))
}
fun InsnASM.putfield(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(PUTFIELD, owner.internalName, name, type.descriptor))
}
