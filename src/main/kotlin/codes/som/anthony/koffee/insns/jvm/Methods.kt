package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.MethodInsnNode

fun InstructionAssembly.invokevirtual(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())
    instructions.add(MethodInsnNode(INVOKEVIRTUAL, coerceType(owner).internalName, name, descriptor))
}
fun InstructionAssembly.invokespecial(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())
    instructions.add(MethodInsnNode(INVOKESPECIAL, coerceType(owner).internalName, name, descriptor))
}
fun InstructionAssembly.invokestatic(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())
    instructions.add(MethodInsnNode(INVOKESTATIC, coerceType(owner).internalName, name, descriptor))
}
fun InstructionAssembly.invokeinterface(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())
    instructions.add(MethodInsnNode(INVOKEINTERFACE, coerceType(owner).internalName, name, descriptor))
}
