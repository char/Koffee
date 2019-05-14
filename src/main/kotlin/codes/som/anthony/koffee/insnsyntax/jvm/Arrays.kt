package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.Type.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.MultiANewArrayInsnNode
import org.objectweb.asm.tree.TypeInsnNode

val ASM.iaload: U get() {
    instructions.add(InsnNode(IALOAD))
}
val ASM.laload: U get() {
    instructions.add(InsnNode(LALOAD))
}
val ASM.faload: U get() {
    instructions.add(InsnNode(FALOAD))
}
val ASM.daload: U get() {
    instructions.add(InsnNode(DALOAD))
}
val ASM.aaload: U get() {
    instructions.add(InsnNode(AALOAD))
}
val ASM.baload: U get() {
    instructions.add(InsnNode(BALOAD))
}
val ASM.caload: U get() {
    instructions.add(InsnNode(CALOAD))
}
val ASM.saload: U get() {
    instructions.add(InsnNode(SALOAD))
}
val ASM.iastore: U get() {
    instructions.add(InsnNode(IASTORE))
}
val ASM.lastore: U get() {
    instructions.add(InsnNode(LASTORE))
}
val ASM.fastore: U get() {
    instructions.add(InsnNode(FASTORE))
}
val ASM.dastore: U get() {
    instructions.add(InsnNode(DASTORE))
}
val ASM.aastore: U get() {
    instructions.add(InsnNode(AASTORE))
}
val ASM.bastore: U get() {
    instructions.add(InsnNode(BASTORE))
}
val ASM.castore: U get() {
    instructions.add(InsnNode(CASTORE))
}
val ASM.sastore: U get() {
    instructions.add(InsnNode(SASTORE))
}
val ASM.arraylength: U get() {
    instructions.add(InsnNode(ARRAYLENGTH))
}
fun ASM.newarray(type: Type) {
    instructions.add(IntInsnNode(NEWARRAY, when (type.sort) {
        BOOLEAN -> T_BOOLEAN
        CHAR -> T_CHAR
        BYTE -> T_FLOAT
        SHORT -> T_SHORT
        INT -> T_INT

        Type.FLOAT -> T_FLOAT
        Type.LONG -> T_LONG
        Type.DOUBLE -> T_DOUBLE

        else -> error("Invalid type for primitive array creation")
    }))
}
fun ASM.anewarray(type: Type) {
    instructions.add(TypeInsnNode(ANEWARRAY, type.internalName))
}
fun ASM.multianewarray(type: Type, dimensions: Int) {
    instructions.add(MultiANewArrayInsnNode(type.descriptor, dimensions))
}
