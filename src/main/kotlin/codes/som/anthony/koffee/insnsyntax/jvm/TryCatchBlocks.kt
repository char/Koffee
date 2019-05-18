package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import codes.som.anthony.koffee.LabelRegistry
import org.objectweb.asm.Opcodes.F_SAME1
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*

class GuardContext(private val asm: ASM,
        val startNode: LabelNode, val endNode: LabelNode, val exitNode: LabelNode) {
    internal class GuardHandlerAssemblyContext(instructions: InsnList, asm: ASM) : ASM(instructions, asm.tryCatchBlocks) {
        override val L = asm.L
    }

    fun handle(exceptionType: Type, fallthrough: Boolean = false, routine: ASM.() -> Unit): GuardContext {
        val instructions = InsnList()
        val handlerNode = LabelNode()
        instructions.add(handlerNode)
        instructions.add(FrameNode(F_SAME1, 0, null, 1, arrayOf(exceptionType.internalName)))

        val embeddedASM = GuardHandlerAssemblyContext(instructions, asm)
        routine(embeddedASM)

        if (!fallthrough)
            instructions.add(JumpInsnNode(GOTO, exitNode))

        asm.instructions.insertBefore(exitNode, instructions)
        asm.tryCatchBlocks.add(TryCatchBlockNode(startNode, endNode, handlerNode, exceptionType.internalName))

        return this
    }
}

fun ASM.guard(routine: ASM.() -> Unit): GuardContext {
    val startNode = LabelNode()
    val endNode = LabelNode()
    val exitNode = LabelNode()

    instructions.add(startNode)
    routine()
    instructions.add(JumpInsnNode(GOTO, exitNode))
    instructions.add(endNode)
    // Handlers go here
    instructions.add(exitNode)

    return GuardContext(this, startNode, endNode, exitNode)
}
