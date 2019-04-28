package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.TypeInsnNode

fun ASM.new(type: Type) {
    node.instructions.add(TypeInsnNode(NEW, type.internalName))
}
fun ASM.anewarray(type: Type) {
    node.instructions.add(TypeInsnNode(ANEWARRAY, type.internalName))
}
fun ASM.checkcast(type: Type) {
    node.instructions.add(TypeInsnNode(CHECKCAST, type.internalName))
}
