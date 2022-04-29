package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.types.TypeLike
import codes.som.koffee.types.coerceType
import codes.som.koffee.util.constructMethodDescriptor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode

/**
 * Invokes an instance method on an object.
 *
 * The stack is manipulated in one of the following ways based on the [descriptor]:
 * - A *PARAMS&#42;* -> *RETURN_TYPE*
 * - A *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokevirtual(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKEVIRTUAL, coerceType(owner).internalName, name, descriptor))
}

/**
 * Used to invoke a constructor, super method, or private method.
 *
 * The stack is manipulated in one of the following ways based on the [descriptor]:
 * - A *PARAMS&#42;* -> *RETURN_TYPE*
 * - A *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokespecial(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKESPECIAL, coerceType(owner).internalName, name, descriptor))
}

/**
 * Used to invoke an interface method.
 *
 * The stack is manipulated in one of the following ways based on the [descriptor]:
 * - A *PARAMS&#42;* -> *RETURN_TYPE*
 * - A *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokeinterface(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKEINTERFACE, coerceType(owner).internalName, name, descriptor))
}

/**
 * Used to invoke a static method.
 *
 * The stack is manipulated in one of the following ways based on the [descriptor]:
 * - *PARAMS&#42;* -> *RETURN_TYPE*
 * - *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokestatic(owner: TypeLike, name: String, descriptor: String) {
    instructions.add(MethodInsnNode(INVOKESTATIC, coerceType(owner).internalName, name, descriptor))
}

/**
 * Used to invoke an instance method on an object.
 *
 * The stack is manipulated in one of the following ways based on the [returnType] and [parameterTypes]:
 * - A *PARAMS&#42;* -> [returnType]
 * - A *PARAMS&#42;* -> (no stack produced) (if [returnType] is `void`)
 */
public fun InstructionAssembly.invokevirtual(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokevirtual(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}

/**
 * Used to invoke a constructor, super method, or private method.
 *
 * The stack is manipulated in one of the following ways based on the [returnType] and [parameterTypes]:
 * - A *PARAMS&#42;* -> [returnType]
 * - A *PARAMS&#42;* -> (no stack produced) (if [returnType] is `void`)
 */
public fun InstructionAssembly.invokespecial(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokespecial(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}

/**
 * Used to invoke an interface method.
 *
 * The stack is manipulated in one of the following ways based on the [returnType] and [parameterTypes]:
 * - A *PARAMS&#42;* -> [returnType]
 * - A *PARAMS&#42;* -> (no stack produced) (if [returnType] is `void`)
 */
public fun InstructionAssembly.invokeinterface(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokeinterface(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}

/**
 * Used to invoke a static method.
 *
 * The stack is manipulated in one of the following ways based on the [returnType] and [parameterTypes]:
 * - *PARAMS&#42;* -> [returnType]
 * - *PARAMS&#42;* -> (no stack produced) (if [returnType] is `void`)
 */
public fun InstructionAssembly.invokestatic(owner: TypeLike, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike) {
    invokestatic(owner, name, constructMethodDescriptor(returnType, *parameterTypes))
}

/**
 * Used to invoke an instance [method] on an object.
 *
 * The stack is manipulated in one of the following ways based on the method's descriptor:
 * - A *PARAMS&#42;* -> *RETURN_TYPE*
 * - A *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokevirtual(owner: TypeLike, method: MethodNode) {
    invokevirtual(owner, method.name, method.desc)
}

/**
 * Used to invoke a constructor, super method, or private method.
 *
 * The stack is manipulated in one of the following ways based on the method's descriptor:
 * - A *PARAMS&#42;* -> *RETURN_TYPE*
 * - A *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokespecial(owner: TypeLike, method: MethodNode) {
    invokespecial(owner, method.name, method.desc)
}

/**
 * Used to invoke an interface method.
 *
 * The stack is manipulated in one of the following ways based on the method's descriptor:
 * - A *PARAMS&#42;* -> *RETURN_TYPE*
 * - A *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokeinterface(owner: TypeLike, method: MethodNode) {
    invokeinterface(owner, method.name, method.desc)
}

/**
 * Used to invoke a static method.
 *
 * The stack is manipulated in one of the following ways based on the method's descriptor:
 * - *PARAMS&#42;* -> *RETURN_TYPE*
 * - *PARAMS&#42;* -> (no stack produced)
 */
public fun InstructionAssembly.invokestatic(owner: TypeLike, method: MethodNode) {
    invokestatic(owner, method.name, method.desc)
}
