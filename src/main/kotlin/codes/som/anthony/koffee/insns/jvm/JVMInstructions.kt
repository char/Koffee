package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.NOP
import org.objectweb.asm.tree.InsnNode

internal typealias U = Unit

val InstructionAssembly.nop: U get() {
    instructions.add(InsnNode(NOP))
}
