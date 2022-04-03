package codes.som.anthony.koffee.sugar

import codes.som.anthony.koffee.modifiers.Modifiers

@Suppress("PropertyName")
public interface ModifiersAccess {
    public val package_private: Modifiers get() = codes.som.anthony.koffee.modifiers.package_private
    public val public:          Modifiers get() = codes.som.anthony.koffee.modifiers.public
    public val private:         Modifiers get() = codes.som.anthony.koffee.modifiers.private
    public val protected:       Modifiers get() = codes.som.anthony.koffee.modifiers.protected
    public val static:          Modifiers get() = codes.som.anthony.koffee.modifiers.static
    public val final:           Modifiers get() = codes.som.anthony.koffee.modifiers.final
    public val `super`:         Modifiers get() = codes.som.anthony.koffee.modifiers.`super`
    public val _super:          Modifiers get() = codes.som.anthony.koffee.modifiers._super
    public val synchronized:    Modifiers get() = codes.som.anthony.koffee.modifiers.synchronized
    public val open:            Modifiers get() = codes.som.anthony.koffee.modifiers.open
    public val transitive:      Modifiers get() = codes.som.anthony.koffee.modifiers.transitive
    public val volatile:        Modifiers get() = codes.som.anthony.koffee.modifiers.volatile
    public val bridge:          Modifiers get() = codes.som.anthony.koffee.modifiers.bridge
    public val static_phase:    Modifiers get() = codes.som.anthony.koffee.modifiers.static_phase
    public val varargs:         Modifiers get() = codes.som.anthony.koffee.modifiers.varargs
    public val transient:       Modifiers get() = codes.som.anthony.koffee.modifiers.transient
    public val native:          Modifiers get() = codes.som.anthony.koffee.modifiers.native
    public val `interface`:     Modifiers get() = codes.som.anthony.koffee.modifiers.`interface`
    public val _interface:      Modifiers get() = codes.som.anthony.koffee.modifiers._interface
    public val abstract:        Modifiers get() = codes.som.anthony.koffee.modifiers.abstract
    public val strict:          Modifiers get() = codes.som.anthony.koffee.modifiers.strict
    public val synthetic:       Modifiers get() = codes.som.anthony.koffee.modifiers.synthetic
    public val annotation:      Modifiers get() = codes.som.anthony.koffee.modifiers.annotation
    public val enum:            Modifiers get() = codes.som.anthony.koffee.modifiers.enum
    public val mandated:        Modifiers get() = codes.som.anthony.koffee.modifiers.mandated
    public val module:          Modifiers get() = codes.som.anthony.koffee.modifiers.module

    // ASM-specific
    public val deprecated:      Modifiers get() = codes.som.anthony.koffee.modifiers.deprecated
}
