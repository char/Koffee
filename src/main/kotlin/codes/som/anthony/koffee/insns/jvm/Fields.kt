package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.FieldInsnNode

fun InstructionAssembly.getstatic(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(GETSTATIC, coerceType(owner).internalName, name, coerceType(type).descriptor))
}
fun InstructionAssembly.getfield(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(GETFIELD, coerceType(owner).internalName, name, coerceType(type).descriptor))
}
fun InstructionAssembly.putstatic(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(PUTSTATIC, coerceType(owner).internalName, name, coerceType(type).descriptor))
}
fun InstructionAssembly.putfield(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(PUTFIELD, coerceType(owner).internalName, name, coerceType(type).descriptor))
}
