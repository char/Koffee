package codes.som.koffee

import org.objectweb.asm.tree.TryCatchBlockNode

public interface TryCatchContainer {
    public val tryCatchBlocks: MutableList<TryCatchBlockNode>
}
