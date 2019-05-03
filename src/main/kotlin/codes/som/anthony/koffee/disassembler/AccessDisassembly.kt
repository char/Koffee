package codes.som.anthony.koffee.disassembler

import org.objectweb.asm.Opcodes.*

fun disassembleAccess(access: Int): String {
    val accesses = mapOf(
            "public" to ACC_PUBLIC, "private" to ACC_PRIVATE, "protected" to ACC_PROTECTED,
            "static" to ACC_STATIC, "final" to ACC_FINAL, "_super" to ACC_SUPER,
            "synchronized" to ACC_SYNCHRONIZED, "open" to ACC_OPEN, "transitive" to ACC_TRANSITIVE,
            "volatile" to ACC_VOLATILE, "bridge" to ACC_BRIDGE, "static_phase" to ACC_STATIC_PHASE,
            "varargs" to ACC_VARARGS, "transient" to ACC_TRANSIENT, "native" to ACC_NATIVE,
            "_interface" to ACC_INTERFACE, "abstract" to ACC_ABSTRACT, "strict" to ACC_STRICT,
            "synthetic" to ACC_SYNTHETIC, "annotation" to ACC_ANNOTATION, "enum" to ACC_ENUM,
            "mandated" to ACC_MANDATED, "module" to ACC_MODULE
    )

    return accesses.filter { (_, modifier) -> access and modifier != 0 }
            .map { (name, _) -> name }
            .joinToString(" + ")
}
