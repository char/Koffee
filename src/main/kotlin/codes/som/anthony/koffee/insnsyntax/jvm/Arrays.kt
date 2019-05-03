package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.MultiANewArrayInsnNode
import org.objectweb.asm.tree.TypeInsnNode

val ASM.iaload: U get() {
    node.instructions.add(InsnNode(IALOAD))
}
val ASM.laload: U get() {
    node.instructions.add(InsnNode(LALOAD))
}
val ASM.faload: U get() {
    node.instructions.add(InsnNode(FALOAD))
}
val ASM.daload: U get() {
    node.instructions.add(InsnNode(DALOAD))
}
val ASM.aaload: U get() {
    node.instructions.add(InsnNode(AALOAD))
}
val ASM.baload: U get() {
    node.instructions.add(InsnNode(BALOAD))
}
val ASM.caload: U get() {
    node.instructions.add(InsnNode(CALOAD))
}
val ASM.saload: U get() {
    node.instructions.add(InsnNode(SALOAD))
}
val ASM.iastore: U get() {
    node.instructions.add(InsnNode(IASTORE))
}
val ASM.lastore: U get() {
    node.instructions.add(InsnNode(LASTORE))
}
val ASM.fastore: U get() {
    node.instructions.add(InsnNode(FASTORE))
}
val ASM.dastore: U get() {
    node.instructions.add(InsnNode(DASTORE))
}
val ASM.aastore: U get() {
    node.instructions.add(InsnNode(AASTORE))
}
val ASM.bastore: U get() {
    node.instructions.add(InsnNode(BASTORE))
}
val ASM.castore: U get() {
    node.instructions.add(InsnNode(CASTORE))
}
val ASM.sastore: U get() {
    node.instructions.add(InsnNode(SASTORE))
}
val ASM.arraylength: U get() {
    node.instructions.add(InsnNode(ARRAYLENGTH))
}
fun ASM.anewarray(type: Type) {
    node.instructions.add(TypeInsnNode(ANEWARRAY, type.internalName))
}
fun ASM.multianewarray(type: Type, dimensions: Int) {
    node.instructions.add(MultiANewArrayInsnNode(type.descriptor, dimensions))
}
