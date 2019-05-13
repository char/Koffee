package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.MethodInsnNode

fun ASM.invokevirtual(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type) {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    instructions.add(MethodInsnNode(INVOKEVIRTUAL, owner.internalName, name, descriptor))
}
fun ASM.invokespecial(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type) {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    instructions.add(MethodInsnNode(INVOKESPECIAL, owner.internalName, name, descriptor))
}
fun ASM.invokestatic(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type) {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    instructions.add(MethodInsnNode(INVOKESTATIC, owner.internalName, name, descriptor))
}
fun ASM.invokeinterface(owner: Type, name: String, returnType: Type, vararg parameterTypes: Type) {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)
    instructions.add(MethodInsnNode(INVOKEINTERFACE, owner.internalName, name, descriptor))
}
