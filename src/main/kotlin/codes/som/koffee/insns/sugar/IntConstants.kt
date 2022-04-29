package codes.som.koffee.insns.sugar

import codes.som.koffee.insns.InstructionAssembly
import codes.som.koffee.insns.jvm.*

/**
 * Push an arbitrary integer constant onto the stack.
 * It will use the appropriate instruction depending on the value.
 */
public fun InstructionAssembly.push_int(i: Int) {
    when (i) {
        -1 -> iconst_m1
        0 -> iconst_0
        1 -> iconst_1
        2 -> iconst_2
        3 -> iconst_3
        4 -> iconst_4
        5 -> iconst_5

        in Byte.MIN_VALUE .. Byte.MAX_VALUE -> bipush(i)
        in Short.MIN_VALUE .. Short.MAX_VALUE -> sipush(i)

        else -> ldc(i)
    }
}
