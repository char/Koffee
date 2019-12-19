package codes.som.anthony.koffee

import codes.som.anthony.koffee.modifiers.Modifiers
import codes.som.anthony.koffee.sugar.ModifiersAccess
import codes.som.anthony.koffee.sugar.TypesAccess
import codes.som.anthony.koffee.types.TypeLike
import org.objectweb.asm.Opcodes.ASM7
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import codes.som.anthony.koffee.types.coerceType as coerceTypeStatic

class ClassAssembly internal constructor(val node: ClassNode): ModifiersAccess, TypesAccess {
    internal constructor(access: Modifiers, name: String, version: Int, superName: String, interfaces: List<TypeLike>) : this(ClassNode(ASM7).also {
        it.access = access.access
        it.name = name
        it.version = version
        it.superName = superName
        it.interfaces = interfaces.map { type -> coerceTypeStatic(type).internalName }
    })
    
    var access: Modifiers
        get() = Modifiers(node.access)
        set(value) { node.access = value.access }
    
    var name: String
        get() = node.name
        set(value) { node.name = value }
    
    var version: Int
        get() = node.version
        set(value) { node.version = value }
    
    var superClass: Type?
        get() = node.superName?.let(::coerceType)
        set(value) { node.superName = value?.internalName }

    var interfaces: List<Type>?
        get() = node.interfaces?.map(::coerceType)
        set(value) { node.interfaces = value?.map { it.internalName } }

    val self: Type
        get() = coerceType(node.name)

    fun field(access: Modifiers, name: String, type: TypeLike, signature: String? = null, value: Any? = null): FieldNode {
        val fieldNode = FieldNode(ASM7, access.access, name, coerceType(type).descriptor, signature, value)
        node.fields.add(fieldNode)
        return fieldNode
    }

    fun method(access: Modifiers, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike,
            signature: String? = null, exceptions: Array<Type>? = null,
            routine: MethodAssembly.() -> Unit): MethodNode {
        val descriptor = Type.getMethodDescriptor(coerceType(returnType), *parameterTypes.map(::coerceType).toTypedArray())

        val methodNode = MethodNode(ASM7, access.access, name, descriptor, signature, exceptions?.map { it.internalName }?.toTypedArray())
        val methodAssembly = MethodAssembly(methodNode)
        routine(methodAssembly)

        node.methods.add(methodNode)
        
        return methodNode
    }
}

fun assembleClass(access: Modifiers, name: String, version: Int = 49, superName: String = "java/lang/Object", interfaces: List<TypeLike> = listOf(), routine: ClassAssembly.() -> Unit): ClassNode {
    val assembly = ClassAssembly(access, name, version, superName, interfaces)
    routine(assembly)
    return assembly.node
}

fun ClassNode.koffee(routine: ClassAssembly.() -> Unit): ClassNode {
    val assembly = ClassAssembly(this)
    routine(assembly)
    return assembly.node
}
