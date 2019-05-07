package codes.som.anthony.koffee.disassembler

import codes.som.anthony.koffee.disassembler.util.DisassemblyContext
import codes.som.anthony.koffee.disassembler.util.SourceCodeGenerator
import org.objectweb.asm.tree.ClassNode

private fun classPrologue(codegen: SourceCodeGenerator) {
    with (codegen) {
        appendLine("import codes.som.anthony.koffee.assemble")
        appendLine("import codes.som.anthony.koffee.insnsyntax.jvm.*")
        append("\n")

        appendLine("assemble {")
        indent()
    }
}

private fun classEpilogue(codegen: SourceCodeGenerator) {
    with (codegen) {
        dedent()
        appendLine("}")
    }
}

fun disassemble(node: ClassNode): String {
    val codegen = SourceCodeGenerator()
    val context = DisassemblyContext(node.name)

    with (codegen) {
        classPrologue(codegen)
        appendLine("name = ${disassembleValue(node.name, context)}")
        appendLine("access = ${disassembleAccess(node.access)}")
        appendLine("version = ${disassembleValue(node.version, context)}")

        disassembleFields(node, codegen, context)
        disassembleMethods(node, codegen, context)

        classEpilogue(codegen)
    }

    return codegen.toString()
}
