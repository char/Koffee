package codes.som.anthony.koffee.util

import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Type

@Suppress("NOTHING_TO_INLINE")
internal inline fun constructMethodDescriptor(returnType: TypeLike, vararg parameterTypes: TypeLike): String {
    return Type.getMethodDescriptor(coerceType(returnType),
            *parameterTypes.map(::coerceType).toTypedArray())
}
