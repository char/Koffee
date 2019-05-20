package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Handle
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InvokeDynamicInsnNode

fun ASM.invokedynamic(name: String, returnType: Type, vararg parameterTypes: Type, handle: Handle, args: Array<out Any>) {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    instructions.add(InvokeDynamicInsnNode(name, descriptor, handle, *args))
}
fun ASM.h_invokestatic(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type): Handle {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    return Handle(H_INVOKESTATIC, owner.internalName, name, descriptor, false)
}
fun ASM.h_invokevirtual(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type): Handle {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    return Handle(H_INVOKEVIRTUAL, owner.internalName, name, descriptor, false)
}
fun ASM.h_invokespecial(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type): Handle {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    return Handle(H_INVOKESPECIAL, owner.internalName, name, descriptor, false)
}
fun ASM.h_invokeinterface(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type): Handle {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    return Handle(H_INVOKEINTERFACE, owner.internalName, name, descriptor, true)
}
