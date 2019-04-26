package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.InsnNode

val ASM.ireturn: U get() {
    node.instructions.add(InsnNode(IRETURN))
}
val ASM.lreturn: U get() {
    node.instructions.add(InsnNode(LRETURN))
}
val ASM.freturn: U get() {
    node.instructions.add(InsnNode(FRETURN))
}
val ASM.dreturn: U get() {
    node.instructions.add(InsnNode(DRETURN))
}
val ASM.areturn: U get() {
    node.instructions.add(InsnNode(ARETURN))
}

val ASM.`return`: U get() {
    node.instructions.add(InsnNode(RETURN))
}
val ASM._return: U get() = `return`
val ASM.vreturn: U get() = `return`
val ASM.return_void: U get() = `return`
