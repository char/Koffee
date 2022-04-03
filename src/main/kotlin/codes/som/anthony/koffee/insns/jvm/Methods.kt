package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import codes.som.anthony.koffee.util.constructMethodDescriptor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode

public fun InstructionAssembly.invokevirtual(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKEVIRTUAL, coerceType(owner).internalName, name, descriptor))
}
public fun InstructionAssembly.invokespecial(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKESPECIAL, coerceType(owner).internalName, name, descriptor))
}
public fun InstructionAssembly.invokeinterface(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKEINTERFACE, coerceType(owner).internalName, name, descriptor))
}
public fun InstructionAssembly.invokestatic(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKESTATIC, coerceType(owner).internalName, name, descriptor))
}

public fun InstructionAssembly.invokevirtual(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokevirtual(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}
public fun InstructionAssembly.invokespecial(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokespecial(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}
public fun InstructionAssembly.invokeinterface(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokeinterface(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}
public fun InstructionAssembly.invokestatic(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokestatic(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}

public fun InstructionAssembly.invokevirtual(owner: TypeLike, method: MethodNode) {
    invokevirtual(owner, method.name, method.desc)
}
public fun InstructionAssembly.invokespecial(owner: TypeLike, method: MethodNode) {
    invokespecial(owner, method.name, method.desc)
}
public fun InstructionAssembly.invokeinterface(owner: TypeLike, method: MethodNode) {
    invokeinterface(owner, method.name, method.desc)
}
public fun InstructionAssembly.invokestatic(owner: TypeLike, method: MethodNode) {
    invokestatic(owner, method.name, method.desc)
}
