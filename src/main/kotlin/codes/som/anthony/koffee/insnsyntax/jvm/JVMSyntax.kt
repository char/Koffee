package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.NOP
import org.objectweb.asm.tree.InsnNode

typealias U = Unit

val ASM.nop: U get() {
    instructions.add(InsnNode(NOP))
}
