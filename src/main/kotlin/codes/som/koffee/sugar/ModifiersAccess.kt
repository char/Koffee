package codes.som.koffee.sugar

import codes.som.koffee.modifiers.Modifiers

@Suppress("PropertyName")
public interface ModifiersAccess {
    public val package_private: Modifiers get() = codes.som.koffee.modifiers.package_private
    public val public:          Modifiers get() = codes.som.koffee.modifiers.public
    public val private:         Modifiers get() = codes.som.koffee.modifiers.private
    public val protected:       Modifiers get() = codes.som.koffee.modifiers.protected
    public val static:          Modifiers get() = codes.som.koffee.modifiers.static
    public val final:           Modifiers get() = codes.som.koffee.modifiers.final
    public val `super`:         Modifiers get() = codes.som.koffee.modifiers.`super`
    public val _super:          Modifiers get() = codes.som.koffee.modifiers._super
    public val synchronized:    Modifiers get() = codes.som.koffee.modifiers.synchronized
    public val open:            Modifiers get() = codes.som.koffee.modifiers.open
    public val transitive:      Modifiers get() = codes.som.koffee.modifiers.transitive
    public val volatile:        Modifiers get() = codes.som.koffee.modifiers.volatile
    public val bridge:          Modifiers get() = codes.som.koffee.modifiers.bridge
    public val static_phase:    Modifiers get() = codes.som.koffee.modifiers.static_phase
    public val varargs:         Modifiers get() = codes.som.koffee.modifiers.varargs
    public val transient:       Modifiers get() = codes.som.koffee.modifiers.transient
    public val native:          Modifiers get() = codes.som.koffee.modifiers.native
    public val `interface`:     Modifiers get() = codes.som.koffee.modifiers.`interface`
    public val _interface:      Modifiers get() = codes.som.koffee.modifiers._interface
    public val abstract:        Modifiers get() = codes.som.koffee.modifiers.abstract
    public val strict:          Modifiers get() = codes.som.koffee.modifiers.strict
    public val synthetic:       Modifiers get() = codes.som.koffee.modifiers.synthetic
    public val annotation:      Modifiers get() = codes.som.koffee.modifiers.annotation
    public val enum:            Modifiers get() = codes.som.koffee.modifiers.enum
    public val mandated:        Modifiers get() = codes.som.koffee.modifiers.mandated
    public val module:          Modifiers get() = codes.som.koffee.modifiers.module

    // ASM-specific
    public val deprecated:      Modifiers get() = codes.som.koffee.modifiers.deprecated
}
