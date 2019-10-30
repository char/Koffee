// Since this is a DSL, Kotlin naming conventions will be subverted
// since these 'object's will actually act more like constants.
@file:Suppress("ClassName", "ObjectPropertyName")

package codes.som.anthony.koffee.modifiers

import org.objectweb.asm.Opcodes.*

// Wrap access flags in 'Modifiers' objects
open class Modifiers(val access: Int) {
    // We want to use the '+' operator to combine modifiers,
    // but internally we should use the bitwise 'or'.
    operator fun plus(modifiers: Modifiers): Modifiers {
        return Modifiers(this.access or modifiers.access)
    }
}

object package_private : Modifiers(0)
object public : Modifiers(ACC_PUBLIC)
object private : Modifiers(ACC_PRIVATE)
object protected : Modifiers(ACC_PROTECTED)
object static : Modifiers(ACC_STATIC)
object final : Modifiers(ACC_FINAL)
object `super` : Modifiers(ACC_SUPER)
val _super get() = `super`
object synchronized : Modifiers(ACC_SYNCHRONIZED)
object open : Modifiers(ACC_OPEN)
object transitive : Modifiers(ACC_TRANSITIVE)
object volatile : Modifiers(ACC_VOLATILE)
object bridge : Modifiers(ACC_BRIDGE)
object static_phase : Modifiers(ACC_STATIC_PHASE)
object varargs : Modifiers(ACC_VARARGS)
object transient : Modifiers(ACC_TRANSIENT)
object native : Modifiers(ACC_NATIVE)
object `interface` : Modifiers(ACC_INTERFACE)
val _interface get() = `interface`
object abstract : Modifiers(ACC_ABSTRACT)
object strict : Modifiers(ACC_STRICT)
object synthetic : Modifiers(ACC_SYNTHETIC)
object annotation : Modifiers(ACC_ANNOTATION)
object enum : Modifiers(ACC_ENUM)
object mandated : Modifiers(ACC_MANDATED)
object module : Modifiers(ACC_MODULE)

// ASM-specific
object deprecated : Modifiers(ACC_DEPRECATED)
