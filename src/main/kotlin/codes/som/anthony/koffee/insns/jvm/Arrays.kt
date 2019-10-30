package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.MultiANewArrayInsnNode
import org.objectweb.asm.tree.TypeInsnNode
import org.objectweb.asm.Type.*

val InstructionAssembly.iaload: U get() {
    instructions.add(InsnNode(IALOAD))
}
val InstructionAssembly.laload: U get() {
    instructions.add(InsnNode(LALOAD))
}
val InstructionAssembly.faload: U get() {
    instructions.add(InsnNode(FALOAD))
}
val InstructionAssembly.daload: U get() {
    instructions.add(InsnNode(DALOAD))
}
val InstructionAssembly.aaload: U get() {
    instructions.add(InsnNode(AALOAD))
}
val InstructionAssembly.baload: U get() {
    instructions.add(InsnNode(BALOAD))
}
val InstructionAssembly.caload: U get() {
    instructions.add(InsnNode(CALOAD))
}
val InstructionAssembly.saload: U get() {
    instructions.add(InsnNode(SALOAD))
}
val InstructionAssembly.iastore: U get() {
    instructions.add(InsnNode(IASTORE))
}
val InstructionAssembly.lastore: U get() {
    instructions.add(InsnNode(LASTORE))
}
val InstructionAssembly.fastore: U get() {
    instructions.add(InsnNode(FASTORE))
}
val InstructionAssembly.dastore: U get() {
    instructions.add(InsnNode(DASTORE))
}
val InstructionAssembly.aastore: U get() {
    instructions.add(InsnNode(AASTORE))
}
val InstructionAssembly.bastore: U get() {
    instructions.add(InsnNode(BASTORE))
}
val InstructionAssembly.castore: U get() {
    instructions.add(InsnNode(CASTORE))
}
val InstructionAssembly.sastore: U get() {
    instructions.add(InsnNode(SASTORE))
}
val InstructionAssembly.arraylength: U get() {
    instructions.add(InsnNode(ARRAYLENGTH))
}
fun InstructionAssembly.newarray(type: TypeLike) {
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
fun InstructionAssembly.anewarray(type: TypeLike) {
    instructions.add(TypeInsnNode(ANEWARRAY, coerceType(type).internalName))
}
fun InstructionAssembly.multianewarray(type: TypeLike, dimensions: Int) {
    instructions.add(MultiANewArrayInsnNode(coerceType(type).descriptor, dimensions))
}
