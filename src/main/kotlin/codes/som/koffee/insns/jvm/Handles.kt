@file:Suppress("unused") // Receivers used to avoid scope pollution

package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.types.TypeLike
import codes.som.koffee.types.coerceType
import codes.som.koffee.util.constructMethodDescriptor
import org.objectweb.asm.Handle
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode

public fun InstructionAssembly.h_invokevirtual(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_INVOKEVIRTUAL, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_invokespecial(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_INVOKESPECIAL, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_invokeinterface(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_INVOKEINTERFACE, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_invokestatic(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_INVOKESTATIC, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_putfield(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_PUTFIELD, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_getfield(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_GETFIELD, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_putstatic(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_PUTSTATIC, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_getstatic(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_GETSTATIC, coerceType(owner).internalName, name, descriptor, isInterface)
}
public fun InstructionAssembly.h_newinvokespecial(owner: TypeLike, name: String, descriptor: String, isInterface: Boolean = false): Handle {
    return Handle(Opcodes.H_NEWINVOKESPECIAL, coerceType(owner).internalName, name, descriptor, isInterface)
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
public fun InstructionAssembly.h_putfield(owner: TypeLike, name: String, type: TypeLike, isInterface: Boolean = false): Handle {
    return h_putfield(owner, name, coerceType(type).descriptor, isInterface)
}
public fun InstructionAssembly.h_getfield(owner: TypeLike, name: String, type: TypeLike, isInterface: Boolean = false): Handle {
    return h_getfield(owner, name, coerceType(type).descriptor, isInterface)
}
public fun InstructionAssembly.h_putstatic(owner: TypeLike, name: String, type: TypeLike, isInterface: Boolean = false): Handle {
    return h_putstatic(owner, name, coerceType(type).descriptor, isInterface)
}
public fun InstructionAssembly.h_getstatic(owner: TypeLike, name: String, type: TypeLike, isInterface: Boolean = false): Handle {
    return h_getstatic(owner, name, coerceType(type).descriptor, isInterface)
}
public fun InstructionAssembly.h_newinvokespecial(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, isInterface: Boolean = false): Handle {
    return h_newinvokespecial(owner, name, constructMethodDescriptor(returnType, *parameterTypes), isInterface)
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
public fun InstructionAssembly.h_putfield(owner: TypeLike, field: FieldNode, isInterface: Boolean = false): Handle {
    return h_putfield(owner, field.name, field.desc, isInterface)
}
public fun InstructionAssembly.h_getfield(owner: TypeLike, field: FieldNode, isInterface: Boolean = false): Handle {
    return h_getfield(owner, field.name, field.desc, isInterface)
}
public fun InstructionAssembly.h_putstatic(owner: TypeLike, field: FieldNode, isInterface: Boolean = false): Handle {
    return h_putstatic(owner, field.name, field.desc, isInterface)
}
public fun InstructionAssembly.h_getstatic(owner: TypeLike, field: FieldNode, isInterface: Boolean = false): Handle {
    return h_getstatic(owner, field.name, field.desc, isInterface)
}
public fun InstructionAssembly.h_newinvokespecial(owner: TypeLike, method: MethodNode, isInterface: Boolean = false): Handle {
    return h_newinvokespecial(owner, method.name, method.desc, isInterface)
}
