package codes.som.anthony.koffee.disassembler

import codes.som.anthony.koffee.disassembler.util.DisassemblyContext
import codes.som.anthony.koffee.disassembler.util.SourceCodeGenerator
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode

fun disassembleFields(node: ClassNode, codegen: SourceCodeGenerator, context: DisassemblyContext) {
    if (!node.fields.isNullOrEmpty()) {
        codegen.append("\n")
        for (field in node.fields) {
            codegen.appendLine(disassembleField(field, context))
        }
    }
}

fun disassembleField(field: FieldNode, context: DisassemblyContext) =
    "field(" + disassembleAccess(field.access) + ", " +
            disassembleType(Type.getType(field.desc), context) + ", " +
            disassembleValue(field.name, context) +
            if (field.signature != null || field.value != null) ", " +
                    disassembleValue(field.signature, context) + ", " +
                    disassembleValue(field.value, context) + ")"
            else ")"
