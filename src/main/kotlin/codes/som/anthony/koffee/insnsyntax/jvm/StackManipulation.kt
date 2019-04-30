package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

val ASM.pop: U get() {
    node.instructions.add(InsnNode(POP))
}
val ASM.pop2: U get() {
    node.instructions.add(InsnNode(POP2))
}
val ASM.dup: U get() {
    node.instructions.add(InsnNode(DUP))
}
val ASM.dup_x1: U get() {
    node.instructions.add(InsnNode(DUP_X1))
}
val ASM.dup_x2: U get() {
    node.instructions.add(InsnNode(DUP_X2))
}
val ASM.dup2: U get() {
    node.instructions.add(InsnNode(DUP2))
}
val ASM.dup2_x1: U get() {
    node.instructions.add(InsnNode(DUP2_X1))
}
val ASM.dup2_x2: U get() {
    node.instructions.add(InsnNode(DUP2_X2))
}
val ASM.swap: U get() {
    node.instructions.add(InsnNode(SWAP))
}
