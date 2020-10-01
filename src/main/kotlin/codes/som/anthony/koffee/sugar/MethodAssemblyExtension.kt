package codes.som.anthony.koffee.sugar

import codes.som.anthony.koffee.MethodAssembly
import codes.som.anthony.koffee.insns.jvm.aload_0
import codes.som.anthony.koffee.insns.jvm.invokespecial
import codes.som.anthony.koffee.types.TypeLike

object MethodAssemblyExtension {
    fun MethodAssembly.call_super(superClass: TypeLike = Object::class, name: String = "<init>") {
        aload_0 // load this
        invokespecial(superClass, name, void)
    }
}