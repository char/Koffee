package codes.som.koffee.insns.sugar

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.insns.jvm.dup
import codes.som.koffee.insns.jvm.invokespecial
import codes.som.koffee.insns.jvm.new
import codes.som.koffee.types.TypeLike
import codes.som.koffee.types.void

/**
 * Construct an object of the given [type].
 * Pass the return type and parameter types with [constructorTypes].
 * Add elements to the stack as necessary by adding instructions with [initializerBlock].
 */
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
