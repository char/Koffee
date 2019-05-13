package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.FieldInsnNode

fun ASM.getstatic(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(GETSTATIC, owner.internalName, name, type.descriptor))
}
fun ASM.getfield(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(GETFIELD, owner.internalName, name, type.descriptor))
}
fun ASM.putstatic(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(PUTSTATIC, owner.internalName, name, type.descriptor))
}
fun ASM.putfield(owner: Type, name: String, type: Type) {
    instructions.add(FieldInsnNode(PUTFIELD, owner.internalName, name, type.descriptor))
}
