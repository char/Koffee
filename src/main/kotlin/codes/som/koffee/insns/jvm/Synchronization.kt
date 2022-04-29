package codes.som.koffee.insns.jvm

import codes.som.koffee.insns.InstructionAssembly
import org.objectweb.asm.Opcodes.MONITORENTER
import org.objectweb.asm.Opcodes.MONITOREXIT
import org.objectweb.asm.tree.InsnNode

/**
 * Enter a monitor. This halts other threads trying to use the same monitored object
 * until the monitor is released.
 *
 * A -> (no stack produced)
 *
 * @see monitorexit
 */
public val InstructionAssembly.monitorenter: U get() {
    instructions.add(InsnNode(MONITORENTER))
}

/**
 * Exit a monitor. This releases the monitor for other threads to use.
 *
 * A -> (no stack produced)
 *
 * @see monitorenter
 */
public val InstructionAssembly.monitorexit: U get() {
    instructions.add(InsnNode(MONITOREXIT))
}
