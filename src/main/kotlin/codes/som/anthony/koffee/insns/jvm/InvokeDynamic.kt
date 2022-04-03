package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.util.constructMethodDescriptor
import org.objectweb.asm.Handle
import org.objectweb.asm.tree.InvokeDynamicInsnNode
import org.objectweb.asm.tree.MethodInsnNode

public fun InstructionAssembly.invokedynamic(name: String, descriptor: String, handle: Handle, args: Array<out Any>) {
    instructions.add(InvokeDynamicInsnNode(name, descriptor, handle, *args))
}
public fun InstructionAssembly.invokedynamic(name: String, returnType: TypeLike, vararg parameterTypes: TypeLike, handle: Handle, args: Array<out Any>) {
    invokedynamic(name, constructMethodDescriptor(returnType, *parameterTypes), handle, args)
}
public fun InstructionAssembly.invokedynamic(method: MethodInsnNode, handle: Handle, args: Array<out Any>) {
    invokedynamic(method.name, method.desc, handle, args)
}
