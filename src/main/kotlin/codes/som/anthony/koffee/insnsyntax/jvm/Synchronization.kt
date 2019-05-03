package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

val ASM.monitorenter: U get() {
    node.instructions.add(InsnNode(MONITORENTER))
}
val ASM.monitorexit: U get() {
    node.instructions.add(InsnNode(MONITOREXIT))
}
