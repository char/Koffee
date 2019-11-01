package codes.som.anthony.koffee.sugar

import codes.som.anthony.koffee.types.TypeLike

interface TypesAccess {
    val void get() = codes.som.anthony.koffee.types.void
    val char get() = codes.som.anthony.koffee.types.char
    val byte get() = codes.som.anthony.koffee.types.byte
    val short get() = codes.som.anthony.koffee.types.short
    val int get() = codes.som.anthony.koffee.types.int
    val float get() = codes.som.anthony.koffee.types.float
    val long get() = codes.som.anthony.koffee.types.long
    val double get() = codes.som.anthony.koffee.types.double
    val boolean get() = codes.som.anthony.koffee.types.boolean

    fun coerceType(value: TypeLike) = codes.som.anthony.koffee.types.coerceType(value)
}
