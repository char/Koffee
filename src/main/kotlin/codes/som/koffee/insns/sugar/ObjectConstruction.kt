package codes.som.koffee.insns.sugar

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.insns.jvm.dup
import codes.som.koffee.insns.jvm.invokespecial
import codes.som.koffee.insns.jvm.new
import codes.som.koffee.types.TypeLike
import codes.som.koffee.types.void

public fun <S : InstructionAssembly> S.construct(
    type: TypeLike,
    vararg constructorTypes: TypeLike,
    initializerName: String = "<init>",
    initializerBlock: S.() -> Unit = {}
) {
    val returnType = constructorTypes.getOrElse(0) { void }
    val parameterTypes = constructorTypes.drop(1).toTypedArray()

    new(type)
    dup
    initializerBlock(this)
    invokespecial(type, initializerName, returnType, *parameterTypes)
}
