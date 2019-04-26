package codes.som.anthony.koffee

import org.objectweb.asm.Opcodes.*

interface ModifiersAccess {
    val package_private get() = NoneModifier
    val public get() = PublicModifier
    val private get() = PrivateModifier
    val protected get() = ProtectedModifier
    val static get() = StaticModifier
    val final get() = FinalModifier
    val `super` get() = SuperModifier
    val _super get() = `super`
    val synchronized get() = SynchronizedModifier
    val open get() = OpenModifier
    val transitive get() = TransitiveModifier
    val volatile get() = VolatileModifier
    val bridge get() = BridgeModifier
    val varargs get() = VarargsModifier
    val transient get() = TransientModifier
    val native get() = NativeModifier
    val `interface` get() = InterfaceModifier
    val _interface get() = `interface`
    val abstract get() = AbstractModifier
    val strict get() = StrictModifier
    val synthetic get() = SyntheticModifier
    val annotation get() = AnnotationModifier
    val enum get() = EnumModifier
    val mandated get() = MandatedModifier
    val module get() = ModuleModifier
}

open class Modifiers(val access: Int) {
    constructor(vararg accesses: Int) : this(accesses.reduce(Int::or))

    override fun equals(other: Any?): Boolean {
        if (other is Modifiers) {
            return other.access == this.access
        }

        return super.equals(other)
    }

    operator fun plus(modifiers: Modifiers): Modifiers {
        return Modifiers(this.access or modifiers.access)
    }

    override fun hashCode(): Int {
        return access.hashCode()
    }
}

object NoneModifier : Modifiers(0)
object PublicModifier : Modifiers(ACC_PUBLIC)
object PrivateModifier : Modifiers(ACC_PRIVATE)
object ProtectedModifier : Modifiers(ACC_PROTECTED)
object StaticModifier : Modifiers(ACC_STATIC)
object FinalModifier : Modifiers(ACC_FINAL)
object SuperModifier : Modifiers(ACC_SUPER)
object SynchronizedModifier : Modifiers(ACC_SYNCHRONIZED)
object OpenModifier : Modifiers(ACC_OPEN)
object TransitiveModifier : Modifiers(ACC_TRANSITIVE)
object VolatileModifier : Modifiers(ACC_VOLATILE)
object BridgeModifier : Modifiers(ACC_BRIDGE)
object VarargsModifier : Modifiers(ACC_VARARGS)
object TransientModifier : Modifiers(ACC_TRANSIENT)
object NativeModifier : Modifiers(ACC_NATIVE)
object InterfaceModifier : Modifiers(ACC_INTERFACE)
object AbstractModifier : Modifiers(ACC_ABSTRACT)
object StrictModifier : Modifiers(ACC_STRICT)
object SyntheticModifier : Modifiers(ACC_SYNTHETIC)
object AnnotationModifier : Modifiers(ACC_ANNOTATION)
object EnumModifier : Modifiers(ACC_ENUM)
object MandatedModifier : Modifiers(ACC_MANDATED)
object ModuleModifier : Modifiers(ACC_MODULE)
