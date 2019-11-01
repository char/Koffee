@file:Suppress("HasPlatformType")

package codes.som.anthony.koffee.types

import org.objectweb.asm.Type
import kotlin.reflect.KClass

val void get() = Type.VOID_TYPE
val char get() = Type.CHAR_TYPE
val byte get() = Type.BYTE_TYPE
val short get() = Type.SHORT_TYPE
val int get() = Type.INT_TYPE
val float get() = Type.FLOAT_TYPE
val long get() = Type.LONG_TYPE
val double get() = Type.DOUBLE_TYPE
val boolean get() = Type.BOOLEAN_TYPE

/**
 * Currently, the TypeLike classes are: [Type], [KClass], [Class], and [String].
 *
 * However, since we can't declare union typedefs in Kotlin, we have to set the value to 'Any'.
 */
typealias TypeLike = Any

fun coerceType(value: TypeLike): Type {
    return when (value) {
        is Type -> value
        is KClass<*> -> Type.getType(value.java)
        is Class<*> -> Type.getType(value)
        is String -> Type.getObjectType(value)
        else -> error("Non type-like object passed to coerceType()")
    }
}
