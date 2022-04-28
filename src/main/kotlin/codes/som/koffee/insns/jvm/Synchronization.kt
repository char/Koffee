package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.MONITORENTER
import org.objectweb.asm.Opcodes.MONITOREXIT
import org.objectweb.asm.tree.InsnNode

public val InstructionAssembly.monitorenter: U get() {
    instructions.add(InsnNode(MONITORENTER))
}
public val InstructionAssembly.monitorexit: U get() {
    instructions.add(InsnNode(MONITOREXIT))
}
