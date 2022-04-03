package codes.som.anthony.koffee.insns.jvm

import codes.som.anthony.koffee.TryCatchContainer
import codes.som.anthony.koffee.insns.InstructionAssembly
import codes.som.anthony.koffee.labels.LabelRegistry
import codes.som.anthony.koffee.labels.LabelScope
import codes.som.anthony.koffee.types.TypeLike
import codes.som.anthony.koffee.types.coerceType
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.LabelNode
import org.objectweb.asm.tree.TryCatchBlockNode

public class GuardAssembly<T>(private val assembly: T,
                              public val startNode: LabelNode, public val endNode: LabelNode, public val exitNode: LabelNode)
        where T : InstructionAssembly, T : TryCatchContainer, T : LabelScope {
    public class GuardHandlerAssemblyContext<T>(override val instructions: InsnList, private val assembly: T):
            InstructionAssembly, TryCatchContainer, LabelScope
            where T : InstructionAssembly, T : TryCatchContainer, T : LabelScope {
        override val tryCatchBlocks: MutableList<TryCatchBlockNode> = assembly.tryCatchBlocks
        override val L: LabelRegistry = assembly.L.copy(assembly)
    }

    public fun handle(exceptionType: TypeLike, fallthrough: Boolean = false, routine: GuardHandlerAssemblyContext<T>.() -> Unit): GuardAssembly<T> {
        val instructions = InsnList()
        val handlerNode = LabelNode()
        instructions.add(handlerNode)

        val embeddedASM = GuardHandlerAssemblyContext(instructions, assembly)
        routine(embeddedASM)

        if (!fallthrough)
            instructions.add(JumpInsnNode(GOTO, exitNode))

        assembly.instructions.insertBefore(exitNode, instructions)
        assembly.tryCatchBlocks.add(TryCatchBlockNode(startNode, endNode, handlerNode, coerceType(exceptionType).internalName))

        return this
    }
}

public fun <T> T.guard(routine: T.() -> Unit): GuardAssembly<T> where T : InstructionAssembly, T : TryCatchContainer, T : LabelScope {
    val startNode = LabelNode()
    val endNode = LabelNode()
    val exitNode = LabelNode()

    instructions.add(startNode)
    routine()
    instructions.add(JumpInsnNode(GOTO, exitNode))
    instructions.add(endNode)
    instructions.add(exitNode)

    return GuardAssembly(this, startNode, endNode, exitNode)
}
