package codes.som.anthony.koffee

import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import org.objectweb.asm.tree.MethodNode

fun assembleMethod(access: Modifiers, name: String,
        returnType: Type, vararg parameterTypes: Type,
        signature: String? = null, exceptions: Array<Type>? = null,
        routine: MethodAssemblyContext.() -> Unit): MethodNode {
    val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)

    val methodNode = MethodNode(Opcodes.ASM7, access.access, name, descriptor, signature, exceptions?.map { it.internalName }?.toTypedArray())
    val methodAssemblyContext = MethodAssemblyContext(methodNode)
    routine(methodAssemblyContext)

    return methodNode
}
