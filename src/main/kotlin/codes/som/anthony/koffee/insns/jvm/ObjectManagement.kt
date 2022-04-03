package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.TypeInsnNode

public fun InstructionAssembly.new(type: TypeLike) {
    instructions.add(TypeInsnNode(NEW, coerceType(type).internalName))
}
public fun InstructionAssembly.checkcast(type: TypeLike) {
    instructions.add(TypeInsnNode(CHECKCAST, coerceType(type).internalName))
}
public fun InstructionAssembly.instanceof(type: TypeLike) {
    instructions.add(TypeInsnNode(INSTANCEOF, coerceType(type).internalName))
}
