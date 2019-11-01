package codes.som.anthony.koffee.sugar

@Suppress("PropertyName")
interface ModifiersAccess {
    val package_private get() = codes.som.anthony.koffee.modifiers.package_private
    val public get() = codes.som.anthony.koffee.modifiers.public
    val private get() = codes.som.anthony.koffee.modifiers.private
    val protected get() = codes.som.anthony.koffee.modifiers.protected
    val static get() = codes.som.anthony.koffee.modifiers.static
    val final get() = codes.som.anthony.koffee.modifiers.final
    val `super` get() = codes.som.anthony.koffee.modifiers.`super`
    val _super get() = codes.som.anthony.koffee.modifiers._super
    val synchronized get() = codes.som.anthony.koffee.modifiers.synchronized
    val open get() = codes.som.anthony.koffee.modifiers.open
    val transitive get() = codes.som.anthony.koffee.modifiers.transitive
    val volatile get() = codes.som.anthony.koffee.modifiers.volatile
    val bridge get() = codes.som.anthony.koffee.modifiers.bridge
    val static_phase get() = codes.som.anthony.koffee.modifiers.static_phase
    val varargs get() = codes.som.anthony.koffee.modifiers.varargs
    val transient get() = codes.som.anthony.koffee.modifiers.transient
    val native get() = codes.som.anthony.koffee.modifiers.native
    val `interface` get() = codes.som.anthony.koffee.modifiers.`interface`
    val _interface get() = codes.som.anthony.koffee.modifiers._interface
    val abstract get() = codes.som.anthony.koffee.modifiers.abstract
    val strict get() = codes.som.anthony.koffee.modifiers.strict
    val synthetic get() = codes.som.anthony.koffee.modifiers.synthetic
    val annotation get() = codes.som.anthony.koffee.modifiers.annotation
    val enum get() = codes.som.anthony.koffee.modifiers.enum
    val mandated get() = codes.som.anthony.koffee.modifiers.mandated
    val module get() = codes.som.anthony.koffee.modifiers.module

    val deprecated get() = codes.som.anthony.koffee.modifiers.deprecated
}
