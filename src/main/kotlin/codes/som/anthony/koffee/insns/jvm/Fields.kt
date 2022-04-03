package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.FieldNode

public fun InstructionAssembly.getstatic(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(GETSTATIC, coerceType(owner).internalName, name, coerceType(type).descriptor))
}
public fun InstructionAssembly.getfield(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(GETFIELD, coerceType(owner).internalName, name, coerceType(type).descriptor))
}
public fun InstructionAssembly.putstatic(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(PUTSTATIC, coerceType(owner).internalName, name, coerceType(type).descriptor))
}
public fun InstructionAssembly.putfield(owner: TypeLike, name: String, type: TypeLike) {
    instructions.add(FieldInsnNode(PUTFIELD, coerceType(owner).internalName, name, coerceType(type).descriptor))
}

public fun InstructionAssembly.getstatic(owner: TypeLike, field: FieldNode) {
    getstatic(owner, field.name, Type.getType(field.desc))
}
public fun InstructionAssembly.getfield(owner: TypeLike, field: FieldNode) {
    getfield(owner, field.name, Type.getType(field.desc))
}
public fun InstructionAssembly.putstatic(owner: TypeLike, field: FieldNode) {
    putstatic(owner, field.name, Type.getType(field.desc))
}
public fun InstructionAssembly.putfield(owner: TypeLike, field: FieldNode) {
    putfield(owner, field.name, Type.getType(field.desc))
}
