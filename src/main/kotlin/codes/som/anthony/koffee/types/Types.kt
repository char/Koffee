@file:Suppress("HasPlatformType")

package codes.som.anthony.koffee.types

import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import kotlin.reflect.KClass

public val void:    Type get() = Type.VOID_TYPE
public val char:    Type get() = Type.CHAR_TYPE
public val byte:    Type get() = Type.BYTE_TYPE
public val short:   Type get() = Type.SHORT_TYPE
public val int:     Type get() = Type.INT_TYPE
public val float:   Type get() = Type.FLOAT_TYPE
public val long:    Type get() = Type.LONG_TYPE
public val double:  Type get() = Type.DOUBLE_TYPE
public val boolean: Type get() = Type.BOOLEAN_TYPE

/**
 * Currently, the TypeLike classes are: [Type], [KClass], [Class], [String] and [ClassNode].
 *
 * However, since we can't declare union typedefs in Kotlin, we have to set the value to 'Any'.
 */
public typealias TypeLike = Any

public fun coerceType(value: TypeLike): Type {
    return when (value) {
        is Type -> value
        is KClass<*> -> Type.getType(value.java)
        is Class<*> -> Type.getType(value)
        is String -> Type.getObjectType(value)
        is ClassNode -> Type.getObjectType(value.name)
        else -> error("Non type-like object ${value::class.java.name} passed to coerceType(), please see javadoc for TypeLike")
    }
}
