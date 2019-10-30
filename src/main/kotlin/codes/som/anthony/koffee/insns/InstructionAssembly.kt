package codes.som.anthony.koffee.insns

import org.objectweb.asm.tree.InsnList

interface InstructionAssembly {
    val instructions: InsnList
}
