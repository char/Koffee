package codes.som.anthony.koffee

import org.objectweb.asm.Type
import kotlin.reflect.KClass

interface TypesAccess {
    val void get() = Type.VOID_TYPE
    val char get() = Type.CHAR_TYPE
    val byte get() = Type.BYTE_TYPE
    val short get() = Type.SHORT_TYPE
    val int get() = Type.INT_TYPE
    val float get() = Type.FLOAT_TYPE
    val long get() = Type.LONG_TYPE
    val double get() = Type.DOUBLE_TYPE
    val boolean get() = Type.BOOLEAN_TYPE

    fun type(kType: KClass<*>): Type {
        return Type.getType(kType.java)
    }

    fun type(descriptor: String): Type {
        return Type.getObjectType(descriptor)
    }
}
