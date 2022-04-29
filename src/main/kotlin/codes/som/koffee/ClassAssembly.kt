package codes.som.koffee

import codes.som.koffee.modifiers.Modifiers
import codes.som.koffee.sugar.ModifiersAccess
import codes.som.koffee.sugar.TypesAccess
import codes.som.koffee.types.TypeLike
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import codes.som.koffee.types.coerceType as coerceTypeStatic

/**
 * A higher-level representation of a class than ASM's [ClassNode].
 * It supports easy creation of new [method]s and [field]s.
 */
public class ClassAssembly internal constructor(public val node: ClassNode): ModifiersAccess, TypesAccess {
    internal constructor(access: Modifiers, name: String, version: Int, superName: String, interfaces: List<TypeLike>) : this(ClassNode(ASM9).also {
        it.access = access.access
        it.name = name
        it.version = version
        it.superName = superName
        it.interfaces = interfaces.map { type -> coerceTypeStatic(type).internalName }
    })

    /**
     * The access flags (i.e. [public], [abstract], [enum], etc.) of this class.
     */
    public var access: Modifiers
        get() = Modifiers(node.access)
        set(value) { node.access = value.access }

    /**
     * The slash-separated fully qualified name of this class.
     *
     * Example: The default Java `Object` class is `java/lang/Object`.
     */
    public var name: String
        get() = node.name
        set(value) { node.name = value }

    /**
     * The class version number. A chart can be found in the
     * [JVM specification](https://docs.oracle.com/javase/specs/jvms/se18/html/jvms-4.html#jvms-4.1).
     */
    public var version: Int
        get() = node.version
        set(value) { node.version = value }

    /**
     * The superclass of this class, as an ASM [Type].
     * It should only be `null` for Java's `Object` class.
     */
    public var superClass: Type?
        get() = node.superName?.let(::coerceType)
        set(value) { node.superName = value?.internalName }

    /**
     * The interfaces implemented by this class, as ASM [Type]s.
     */
    public var interfaces: List<Type>
        get() = node.interfaces.map(::coerceType)
        set(value) { node.interfaces = value.map { it.internalName } }

    /**
     * This class as an ASM [Type].
     */
    public val self: Type
        get() = coerceType(node.name)

    /**
     * Create a new field with the given information.
     *
     * If it is a static final field using a constant value, [value] can be used
     * instead of initialization during `<clinit>`.
     */
    public fun field(access: Modifiers, name: String, type: TypeLike, signature: String? = null, value: Any? = null): FieldNode {
        val fieldNode = FieldNode(ASM9, access.access, name, coerceType(type).descriptor, signature, value)
        node.fields.add(fieldNode)
        return fieldNode
    }

    /**
     * Create a new method with the given information.
     *
     * Although exceptions can be specified to be thrown using [exceptions], the JVM
     * does no exception checking at runtime. Therefore, any undeclared exceptions get
     * thrown without the caller requiring handling.
     */
    public fun method(access: Modifiers, name: String, returnType: TypeLike, vararg parameterTypes: TypeLike,
                      signature: String? = null, exceptions: Array<TypeLike>? = null,
                      routine: MethodAssembly.() -> Unit): MethodNode {
        val descriptor = Type.getMethodDescriptor(coerceType(returnType), *parameterTypes.map(::coerceType).toTypedArray())

        val methodNode = MethodNode(ASM9, access.access, name, descriptor, signature, exceptions?.map { coerceType(it).internalName }?.toTypedArray())
        val methodAssembly = MethodAssembly(methodNode)
        routine(methodAssembly)

        node.methods.add(methodNode)
        
        return methodNode
    }
}

/**
 * Assemble a class with the given information and creation block, and return the resulting [ClassNode].
 */
public fun assembleClass(access: Modifiers, name: String, version: Int = V1_8, superName: String = "java/lang/Object", interfaces: List<TypeLike> = listOf(), routine: ClassAssembly.() -> Unit): ClassNode {
    val assembly = ClassAssembly(access, name, version, superName, interfaces)
    routine(assembly)
    return assembly.node
}

/**
 * Get a [ClassAssembly] out of this ClassNode, and return the modified node.
 */
public fun ClassNode.koffee(routine: ClassAssembly.() -> Unit): ClassNode {
    val assembly = ClassAssembly(this)
    routine(assembly)
    return assembly.node
}
