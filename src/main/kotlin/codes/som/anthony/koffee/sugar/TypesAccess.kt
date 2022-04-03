package codes.som.anthony.koffee.sugar

import codes.som.anthony.koffee.types.TypeLike
import org.objectweb.asm.Type

public interface TypesAccess {
    public val void:    Type get() = codes.som.anthony.koffee.types.void
    public val char:    Type get() = codes.som.anthony.koffee.types.char
    public val byte:    Type get() = codes.som.anthony.koffee.types.byte
    public val short:   Type get() = codes.som.anthony.koffee.types.short
    public val int:     Type get() = codes.som.anthony.koffee.types.int
    public val float:   Type get() = codes.som.anthony.koffee.types.float
    public val long:    Type get() = codes.som.anthony.koffee.types.long
    public val double:  Type get() = codes.som.anthony.koffee.types.double
    public val boolean: Type get() = codes.som.anthony.koffee.types.boolean

    public fun coerceType(value: TypeLike): Type = codes.som.anthony.koffee.types.coerceType(value)
}
