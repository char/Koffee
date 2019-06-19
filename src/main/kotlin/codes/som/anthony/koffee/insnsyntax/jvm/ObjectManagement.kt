package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.InsnASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.TypeInsnNode

fun InsnASM.new(type: Type) {
    instructions.add(TypeInsnNode(NEW, type.internalName))
}
fun InsnASM.checkcast(type: Type) {
    instructions.add(TypeInsnNode(CHECKCAST, type.internalName))
}
fun InsnASM.instanceof(type: Type) {
    instructions.add(TypeInsnNode(INSTANCEOF, type.internalName))
}
