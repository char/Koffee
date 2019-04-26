package codes.som.anthony.koffee

import org.objectweb.asm.Opcodes.ASM7
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import kotlin.properties.Delegates

class ClassAssemblyContext : TypesAccess, ModifiersAccess {
    internal val node: ClassNode = ClassNode(ASM7).also {
        it.version = 49
        it.superName = "java/lang/Object"
    }

    var access: Modifiers
        get() = Modifiers(node.access)
        set(value) { node.access = value.access }

    var name: String
        get() = node.name
        set(value) { node.name = value }

    var version: Int
        get() = node.version
        set(value) { node.version = value }

    fun field(access: Modifiers, type: Type, name: String, signature: String? = null, value: Any? = null) {
        node.fields.add(FieldNode(ASM7, access.access, name, type.descriptor, signature, value))
    }

    fun method(access: Modifiers,
               returnType: Type, name: String, vararg parameterTypes: Type,
               signature: String? = null, exceptions: Array<Type>? = null,
               routine: MethodAssemblyContext.() -> Unit) {
        val descriptor = Type.getMethodDescriptor(returnType, *parameterTypes)

        val methodNode = MethodNode(ASM7, access.access, name, descriptor, signature, exceptions?.map { it.internalName }?.toTypedArray())
        val methodAssemblyContext = MethodAssemblyContext(methodNode)
        routine(methodAssemblyContext)

        node.methods.add(methodNode)
    }
}
