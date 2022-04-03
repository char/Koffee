@file:Suppress("unused") // Receivers used to avoid scope pollution

package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import codes.som.anthony.koffee.util.constructMethodDescriptor
import org.objectweb.asm.Handle
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InvokeDynamicInsnNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode

public fun InstructionAssembly.invokedynamic(name: String, descriptor: String, handle: Handle, args: Array<out Any>) {
    instructions.add(InvokeDynamicInsnNode(name, descriptor, handle, *args))
}
public fun InstructionAssembly.invokedynamic(name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, handle: Handle, args: Array<out Any>) {
    invokedynamic(name, constructMethodDescriptor(returnType, *parameterTypes), handle, args)
}
public fun InstructionAssembly.invokedynamic(method: MethodInsnNode, handle: Handle, args: Array<out Any>) {
    invokedynamic(method.name, method.desc, handle, args)
}

public fun InstructionAssembly.h_invokevirtual(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(H_INVOKEVIRTUAL, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_invokespecial(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(H_INVOKESPECIAL, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_invokeinterface(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(H_INVOKEINTERFACE, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_invokestatic(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(H_INVOKESTATIC, coerceType(owner).internalName, name, descriptor, isInterface)
}

public fun InstructionAssembly.h_invokevirtual(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, isInterface: Boolean = false): Handle {
    return h_invokevirtual(owner, name, constructMethodDescriptor(returnType, *parameterTypes), isInterface)
}
public fun InstructionAssembly.h_invokespecial(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, isInterface: Boolean = false): Handle {
    return h_invokespecial(owner, name, constructMethodDescriptor(returnType, *parameterTypes), isInterface)
}
public fun InstructionAssembly.h_invokeinterface(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, isInterface: Boolean = false): Handle {
    return h_invokeinterface(owner, name, constructMethodDescriptor(returnType, *parameterTypes), isInterface)
}
public fun InstructionAssembly.h_invokestatic(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, isInterface: Boolean = false): Handle {
    return h_invokestatic(owner, name, constructMethodDescriptor(returnType, *parameterTypes), isInterface)
}

public fun InstructionAssembly.h_invokevirtual(owner: TypeLike, method: MethodNode, isInterface: Boolean = false): Handle {
    return h_invokevirtual(owner, method.name, method.desc, isInterface)
}
public fun InstructionAssembly.h_invokespecial(owner: TypeLike, method: MethodNode, isInterface: Boolean = false): Handle {
    return h_invokespecial(owner, method.name, method.desc, isInterface)
}
public fun InstructionAssembly.h_invokeinterface(owner: TypeLike, method: MethodNode, isInterface: Boolean = false): Handle {
    return h_invokeinterface(owner, method.name, method.desc, isInterface)
}
public fun InstructionAssembly.h_invokestatic(owner: TypeLike, method: MethodNode, isInterface: Boolean = false): Handle {
    return h_invokestatic(owner, method.name, method.desc, isInterface)
}
