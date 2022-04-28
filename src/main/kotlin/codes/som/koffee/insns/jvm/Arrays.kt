package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.types.TypeLike
import codes.som.koffee.types.coerceType
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.MultiANewArrayInsnNode
import org.objectweb.asm.tree.TypeInsnNode
import org.objectweb.asm.Type.*

public val InstructionAssembly.iaload: U get() {
    instructions.add(InsnNode(IALOAD))
}
public val InstructionAssembly.laload: U get() {
    instructions.add(InsnNode(LALOAD))
}
public val InstructionAssembly.faload: U get() {
    instructions.add(InsnNode(FALOAD))
}
public val InstructionAssembly.daload: U get() {
    instructions.add(InsnNode(DALOAD))
}
public val InstructionAssembly.aaload: U get() {
    instructions.add(InsnNode(AALOAD))
}
public val InstructionAssembly.baload: U get() {
    instructions.add(InsnNode(BALOAD))
}
public val InstructionAssembly.caload: U get() {
    instructions.add(InsnNode(CALOAD))
}
public val InstructionAssembly.saload: U get() {
    instructions.add(InsnNode(SALOAD))
}
public val InstructionAssembly.iastore: U get() {
    instructions.add(InsnNode(IASTORE))
}
public val InstructionAssembly.lastore: U get() {
    instructions.add(InsnNode(LASTORE))
}
public val InstructionAssembly.fastore: U get() {
    instructions.add(InsnNode(FASTORE))
}
public val InstructionAssembly.dastore: U get() {
    instructions.add(InsnNode(DASTORE))
}
public val InstructionAssembly.aastore: U get() {
    instructions.add(InsnNode(AASTORE))
}
public val InstructionAssembly.bastore: U get() {
    instructions.add(InsnNode(BASTORE))
}
public val InstructionAssembly.castore: U get() {
    instructions.add(InsnNode(CASTORE))
}
public val InstructionAssembly.sastore: U get() {
    instructions.add(InsnNode(SASTORE))
}
public val InstructionAssembly.arraylength: U get() {
    instructions.add(InsnNode(ARRAYLENGTH))
}
public fun InstructionAssembly.newarray(type: TypeLike) {
    @Suppress("RemoveRedundantQualifierName") // Bug in resolver, actually ambiguous if not specified TODO: remove later?
    instructions.add(IntInsnNode(NEWARRAY, when (coerceType(type).sort) {
        BOOLEAN -> T_BOOLEAN
        CHAR -> T_CHAR
        BYTE -> T_BYTE
        SHORT -> T_SHORT
        INT -> T_INT

        Type.FLOAT -> T_FLOAT
        Type.LONG -> T_LONG
        Type.DOUBLE -> T_DOUBLE

        else -> error("Invalid type for primitive array creation")
    }))
}
public fun InstructionAssembly.anewarray(type: TypeLike) {
    instructions.add(TypeInsnNode(ANEWARRAY, coerceType(type).internalName))
}
public fun InstructionAssembly.multianewarray(type: TypeLike, dimensions: Int) {
    instructions.add(MultiANewArrayInsnNode(coerceType(type).descriptor, dimensions))
}
