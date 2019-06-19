package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

val InsnASM.monitorenter: U get() {
    instructions.add(InsnNode(MONITORENTER))
}
val InsnASM.monitorexit: U get() {
    instructions.add(InsnNode(MONITOREXIT))
}
