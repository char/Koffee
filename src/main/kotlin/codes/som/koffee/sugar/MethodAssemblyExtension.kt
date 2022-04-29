package codes.som.koffee.sugar

import codes.som.koffee.MethodAssembly
import codes.som.koffee.insns.jvm.aload_0
import codes.som.koffee.insns.jvm.invokespecial
import codes.som.koffee.types.TypeLike

public object MethodAssemblyExtension {
    /**
     * Invokes the [superClass]'s method with the given [name] and [returnType].
     */
    public fun MethodAssembly.call_super(superClass: TypeLike = Object::class, name: String = "<init>", returnType: TypeLike = void) {
        aload_0 // load this
        invokespecial(superClass, name, returnType)
    }
}
