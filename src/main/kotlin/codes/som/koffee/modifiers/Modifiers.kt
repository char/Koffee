// Since this is a DSL, Kotlin naming conventions will be subverted
// since these 'object's will actually act more like constants.
@file:Suppress("ClassName", "ObjectPropertyName")

package codes.som.koffee.modifiers

import org.objectweb.asm.Opcodes.*

/**
 * The modifiers applied to a class, method, field, or module.
 * @property access The raw integer value of the modifiers. This is what ASM and the JVM use.
 */
public open class Modifiers(public val access: Int) {
    /**
     * Combine these modifiers with another.
     *
     * This uses a bitwise OR to combine the two modifiers instead of addition in order to avoid overflow.
     */
    public operator fun plus(modifiers: Modifiers): Modifiers {
        return Modifiers(this.access or modifiers.access)
    }

    /**
     * Check if all access flags set in the passed [modifiers] are also set in this.
     */
    public fun containsAll(modifiers: Modifiers): Boolean {
        return (this.access and modifiers.access) == modifiers.access
    }

    /**
     * Check if any access flags set in the passed [modifiers] are also set in this.
     */
    public fun containsAny(modifiers: Modifiers): Boolean {
        return (this.access and modifiers.access) != 0
    }

    /**
     * Check if any access flags NOT set in the passed [modifiers] are set in this.
     */
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
