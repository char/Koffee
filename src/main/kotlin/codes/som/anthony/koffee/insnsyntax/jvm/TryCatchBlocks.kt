package codes.som.anthony.koffee.insnsyntax.jvm

import codes.som.anthony.koffee.ASM
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.LabelNode
import org.objectweb.asm.tree.TryCatchBlockNode

class GuardContext(private val asm: ASM,
        val startNode: LabelNode, val endNode: LabelNode, val exitNode: LabelNode) {
    internal class GuardHandlerAssemblyContext(instructions: InsnList, asm: ASM) : ASM(instructions, asm.tryCatchBlocks)

    fun handle(exceptionType: Type, fallthrough: Boolean = false, routine: ASM.() -> Unit) {
        val instructions = InsnList()

        val handlerNode = LabelNode()
        instructions.add(handlerNode)

        val embeddedASM = GuardHandlerAssemblyContext(instructions, asm)
        routine(embeddedASM)

        if (!fallthrough)
            instructions.add(JumpInsnNode(GOTO, exitNode))

        asm.instructions.insertBefore(exitNode, instructions)
        asm.tryCatchBlocks.add(TryCatchBlockNode(startNode, endNode, handlerNode, exceptionType.internalName))
    }
}

fun ASM.guard(routine: ASM.() -> Unit): GuardContext {
    val startNode = LabelNode()
    val endNode = LabelNode()
    val exitNode = LabelNode()

    instructions.add(startNode)
    routine()
    instructions.add(endNode)
    // Handlers go here
    instructions.add(exitNode)

    return GuardContext(this, startNode, endNode, exitNode)
}
