package codes.som.koffee.sugar

import codes.som.koffee.types.TypeLike
import org.objectweb.asm.Type

public interface TypesAccess {
    public val void:    Type get() = codes.som.koffee.types.void
    public val char:    Type get() = codes.som.koffee.types.char
    public val byte:    Type get() = codes.som.koffee.types.byte
    public val short:   Type get() = codes.som.koffee.types.short
    public val int:     Type get() = codes.som.koffee.types.int
    public val float:   Type get() = codes.som.koffee.types.float
    public val long:    Type get() = codes.som.koffee.types.long
    public val double:  Type get() = codes.som.koffee.types.double
    public val boolean: Type get() = codes.som.koffee.types.boolean

    public fun coerceType(value: TypeLike): Type = codes.som.koffee.types.coerceType(value)
}
