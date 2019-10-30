package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

val InstructionAssembly.pop: U get() {
    instructions.add(InsnNode(POP))
}
val InstructionAssembly.pop2: U get() {
    instructions.add(InsnNode(POP2))
}
val InstructionAssembly.dup: U get() {
    instructions.add(InsnNode(DUP))
}
val InstructionAssembly.dup_x1: U get() {
    instructions.add(InsnNode(DUP_X1))
}
val InstructionAssembly.dup_x2: U get() {
    instructions.add(InsnNode(DUP_X2))
}
val InstructionAssembly.dup2: U get() {
    instructions.add(InsnNode(DUP2))
}
val InstructionAssembly.dup2_x1: U get() {
    instructions.add(InsnNode(DUP2_X1))
}
val InstructionAssembly.dup2_x2: U get() {
    instructions.add(InsnNode(DUP2_X2))
}
val InstructionAssembly.swap: U get() {
    instructions.add(InsnNode(SWAP))
}
