package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.Type.*
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.MultiANewArrayInsnNode
import org.objectweb.asm.tree.TypeInsnNode

val InsnASM.iaload: U get() {
    instructions.add(InsnNode(IALOAD))
}
val InsnASM.laload: U get() {
    instructions.add(InsnNode(LALOAD))
}
val InsnASM.faload: U get() {
    instructions.add(InsnNode(FALOAD))
}
val InsnASM.daload: U get() {
    instructions.add(InsnNode(DALOAD))
}
val InsnASM.aaload: U get() {
    instructions.add(InsnNode(AALOAD))
}
val InsnASM.baload: U get() {
    instructions.add(InsnNode(BALOAD))
}
val InsnASM.caload: U get() {
    instructions.add(InsnNode(CALOAD))
}
val InsnASM.saload: U get() {
    instructions.add(InsnNode(SALOAD))
}
val InsnASM.iastore: U get() {
    instructions.add(InsnNode(IASTORE))
}
val InsnASM.lastore: U get() {
    instructions.add(InsnNode(LASTORE))
}
val InsnASM.fastore: U get() {
    instructions.add(InsnNode(FASTORE))
}
val InsnASM.dastore: U get() {
    instructions.add(InsnNode(DASTORE))
}
val InsnASM.aastore: U get() {
    instructions.add(InsnNode(AASTORE))
}
val InsnASM.bastore: U get() {
    instructions.add(InsnNode(BASTORE))
}
val InsnASM.castore: U get() {
    instructions.add(InsnNode(CASTORE))
}
val InsnASM.sastore: U get() {
    instructions.add(InsnNode(SASTORE))
}
val InsnASM.arraylength: U get() {
    instructions.add(InsnNode(ARRAYLENGTH))
}
fun InsnASM.newarray(type: Type) {
    instructions.add(IntInsnNode(NEWARRAY, when (type.sort) {
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
fun InsnASM.anewarray(type: Type) {
    instructions.add(TypeInsnNode(ANEWARRAY, type.internalName))
}
fun InsnASM.multianewarray(type: Type, dimensions: Int) {
    instructions.add(MultiANewArrayInsnNode(type.descriptor, dimensions))
}
