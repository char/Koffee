package codes.som.koffee

import codes.som.koffee.modifiers.Modifiers
import codes.som.koffee.sugar.ModifiersAccess
import codes.som.koffee.sugar.TypesAccess
import codes.som.koffee.types.TypeLike
import org.objectweb.asm.Opcodes.ASM7
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import codes.som.koffee.types.coerceType as coerceTypeStatic

public class ClassAssembly internal constructor(public val node: ClassNode): ModifiersAccess, TypesAccess {
    internal constructor(access: Modifiers, name: String, version: Int, superName: String, interfaces: List<TypeLike>) : this(ClassNode(ASM7).also {
        it.access = access.access
        it.name = name
        it.version = version
        it.superName = superName
        it.interfaces = interfaces.map { type -> coerceTypeStatic(type).internalName }
    })
    
    public var access: Modifiers
        get() = Modifiers(node.access)
        set(value) { node.access = value.access }
    
    public var name: String
        get() = node.name
        set(value) { node.name = value }
    
    public var version: Int
        get() = node.version
        set(value) { node.version = value }
    
    public var superClass: Type?
        get() = node.superName?.let(::coerceType)
        set(value) { node.superName = value?.internalName }

    public var interfaces: List<Type>?
        get() = node.interfaces?.map(::coerceType)
        set(value) { node.interfaces = value?.map { it.internalName } }

    public val self: Type
        get() = coerceType(node.name)

    public fun field(access: Modifiers, name: String, type: TypeLike, signature: String? = null, value: Any? = null): FieldNode {
        val fieldNode = FieldNode(ASM7, access.access, name, coerceType(type).descriptor, signature, value)
        node.fields.add(fieldNode)
        return fieldNode
    }

    public fun method(access: Modifiers, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike,
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

public fun assembleClass(access: Modifiers, name: String, version: Int = 49, superName: String = "java/lang/Object", interfaces: List<TypeLike> = listOf(), routine: ClassAssembly.() -> Unit): ClassNode {
    val assembly = ClassAssembly(access, name, version, superName, interfaces)
    routine(assembly)
    return assembly.node
}

public fun ClassNode.koffee(routine: ClassAssembly.() -> Unit): ClassNode {
    val assembly = ClassAssembly(this)
    routine(assembly)
    return assembly.node
}
