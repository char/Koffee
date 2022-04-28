package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

public val InstructionAssembly.pop: U get() {
    instructions.add(InsnNode(POP))
}
public val InstructionAssembly.pop2: U get() {
    instructions.add(InsnNode(POP2))
}
public val InstructionAssembly.dup: U get() {
    instructions.add(InsnNode(DUP))
}
public val InstructionAssembly.dup_x1: U get() {
    instructions.add(InsnNode(DUP_X1))
}
public val InstructionAssembly.dup_x2: U get() {
    instructions.add(InsnNode(DUP_X2))
}
public val InstructionAssembly.dup2: U get() {
    instructions.add(InsnNode(DUP2))
}
public val InstructionAssembly.dup2_x1: U get() {
    instructions.add(InsnNode(DUP2_X1))
}
public val InstructionAssembly.dup2_x2: U get() {
    instructions.add(InsnNode(DUP2_X2))
}
public val InstructionAssembly.swap: U get() {
    instructions.add(InsnNode(SWAP))
}
