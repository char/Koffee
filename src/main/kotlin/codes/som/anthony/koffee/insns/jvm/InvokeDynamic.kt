package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Handle
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InvokeDynamicInsnNode

fun InstructionAssembly.invokedynamic(name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, handle: Handle, args: Array<out Any>) {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())

    instructions.add(InvokeDynamicInsnNode(name, descriptor, handle, *args))
}
fun InstructionAssembly.h_invokestatic(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike): Handle {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())

    return Handle(H_INVOKESTATIC, coerceType(owner).internalName, name, descriptor, false)
}
fun InstructionAssembly.h_invokevirtual(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike): Handle {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())

    return Handle(H_INVOKEVIRTUAL, coerceType(owner).internalName, name, descriptor, false)
}
fun InstructionAssembly.h_invokespecial(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike): Handle {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())

    return Handle(H_INVOKESPECIAL, coerceType(owner).internalName, name, descriptor, false)
}
fun InstructionAssembly.h_invokeinterface(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike): Handle {
    val descriptor = Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())

    return Handle(H_INVOKEINTERFACE, coerceType(owner).internalName, name, descriptor, true)
}
