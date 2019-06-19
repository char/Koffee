package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.NOP
import org.objectweb.asm.tree.InsnNode

internal typealias U = Unit

val InsnASM.nop: U get() {
    instructions.add(InsnNode(NOP))
}
