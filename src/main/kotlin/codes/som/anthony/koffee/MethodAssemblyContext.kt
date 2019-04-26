package codes.som.anthony.koffee

import org.objectweb.asm.tree.MethodNode

abstract class ASM(internal val node: MethodNode)
class MethodAssemblyContext(node: MethodNode) : ASM(node)
