// Since this is a DSL, Kotlin naming conventions will be subverted
// since these 'object's will actually act more like constants.
@file:Suppress("ClassName", "ObjectPropertyName")

package codes.som.anthony.koffee.modifiers

import org.objectweb.asm.Opcodes.*

// Wrap access flags in 'Modifiers' objects
public open class Modifiers(public val access: Int) {
    // We want to use the '+' operator to combine modifiers,
    // but internally we should use the bitwise 'or'.
    public operator fun plus(modifiers: Modifiers): Modifiers {
        return Modifiers(this.access or modifiers.access)
    }

    public fun containsAll(modifiers: Modifiers): Boolean {
        return (this.access and modifiers.access) == modifiers.access
    }

    public fun containsAny(modifiers: Modifiers): Boolean {
        return (this.access and modifiers.access) != 0
    }

    public fun containsOther(modifiers: Modifiers): Boolean {
        return containsAny(Modifiers(modifiers.access.inv()))
    }
}

public object package_private : Modifiers(0)
public object public          : Modifiers(ACC_PUBLIC)
public object private         : Modifiers(ACC_PRIVATE)
public object protected       : Modifiers(ACC_PROTECTED)
public object static          : Modifiers(ACC_STATIC)
public object final           : Modifiers(ACC_FINAL)
public object `super`         : Modifiers(ACC_SUPER)
public val _super             : Modifiers get() = `super`
public object synchronized    : Modifiers(ACC_SYNCHRONIZED)
public object open            : Modifiers(ACC_OPEN)
public object transitive      : Modifiers(ACC_TRANSITIVE)
public object volatile        : Modifiers(ACC_VOLATILE)
public object bridge          : Modifiers(ACC_BRIDGE)
public object static_phase    : Modifiers(ACC_STATIC_PHASE)
public object varargs         : Modifiers(ACC_VARARGS)
public object transient       : Modifiers(ACC_TRANSIENT)
public object native          : Modifiers(ACC_NATIVE)
public object `interface`     : Modifiers(ACC_INTERFACE)
public val _interface         : Modifiers get() = `interface`
public object abstract        : Modifiers(ACC_ABSTRACT)
public object strict          : Modifiers(ACC_STRICT)
public object synthetic       : Modifiers(ACC_SYNTHETIC)
public object annotation      : Modifiers(ACC_ANNOTATION)
public object enum            : Modifiers(ACC_ENUM)
public object mandated        : Modifiers(ACC_MANDATED)
public object module          : Modifiers(ACC_MODULE)

// ASM-specific
public object deprecated      : Modifiers(ACC_DEPRECATED)
