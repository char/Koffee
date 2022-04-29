package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.NOP
import org.objectweb.asm.tree.InsnNode

internal typealias U = Unit

/**
 * Do nothing.
 *
 * (no stack consumed) -> (no stack produced)
 */
public val InstructionAssembly.nop: U get() {
    instructions.add(InsnNode(NOP))
}
