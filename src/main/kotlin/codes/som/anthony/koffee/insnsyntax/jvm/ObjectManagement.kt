package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.TypeInsnNode

fun ASM.new(type: Type) {
    instructions.add(TypeInsnNode(NEW, type.internalName))
}
fun ASM.checkcast(type: Type) {
    instructions.add(TypeInsnNode(CHECKCAST, type.internalName))
}
fun ASM.instanceof(type: Type) {
    instructions.add(TypeInsnNode(INSTANCEOF, type.internalName))
}
