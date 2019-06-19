package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

val InsnASM.pop: U get() {
    instructions.add(InsnNode(POP))
}
val InsnASM.pop2: U get() {
    instructions.add(InsnNode(POP2))
}
val InsnASM.dup: U get() {
    instructions.add(InsnNode(DUP))
}
val InsnASM.dup_x1: U get() {
    instructions.add(InsnNode(DUP_X1))
}
val InsnASM.dup_x2: U get() {
    instructions.add(InsnNode(DUP_X2))
}
val InsnASM.dup2: U get() {
    instructions.add(InsnNode(DUP2))
}
val InsnASM.dup2_x1: U get() {
    instructions.add(InsnNode(DUP2_X1))
}
val InsnASM.dup2_x2: U get() {
    instructions.add(InsnNode(DUP2_X2))
}
val InsnASM.swap: U get() {
    instructions.add(InsnNode(SWAP))
}
