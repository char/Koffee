package codes.som.anthony.koffee.insns.sugar

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.insns.jvm.dup
import codes.som.anthony.koffee.insns.jvm.invokespecial
import codes.som.anthony.koffee.insns.jvm.new
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.void

fun <S : InstructionAssembly> S.construct(type: TypeLike, vararg constructorTypes: TypeLike, initializerName: String = "<init>", initializerBlock: S.() -> Unit = {}) {
    val returnType = constructorTypes.getOrElse(0, { void })
    val parameterTypes = constructorTypes.drop(1).toTypedArray()

    new(type)
    dup
    initializerBlock(this)
    invokespecial(type, initializerName, returnType, *parameterTypes)
}
