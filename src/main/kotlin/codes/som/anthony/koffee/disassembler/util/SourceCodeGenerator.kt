package codes.som.anthony.koffee.disassembler.util

import java.lang.StringBuilder

class SourceCodeGenerator {
    private var currentIndentation: Int = 0
    private val builder = StringBuilder()

    fun indent() {
        currentIndentation += 1
    }

    fun dedent() {
        currentIndentation -= 1
    }

    fun append(data: String) {
        builder.append(data)
    }

    fun appendIndentation() {
        builder.append("    ".repeat(currentIndentation))
    }

    fun appendLine(line: String) {
        appendIndentation()
        builder.append(line)
        builder.append("\n")
    }

    override fun toString(): String {
        return builder.toString()
    }
}
