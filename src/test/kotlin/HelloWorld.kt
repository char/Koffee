import codes.som.anthony.koffee.assemble
import codes.som.anthony.koffee.insnsyntax.jvm.*
import util.EphemeralClassLoader
import java.io.PrintStream

fun main() {
    val classBuffer = assemble {
        name = "HelloWorld"
        access = public

        method(public + static, void, "main", type(Array<String>::class)) {
            getstatic(type(System::class), "out", type(PrintStream::class))
            ldc("Hello, world!")
            invokevirtual(type(PrintStream::class), void, "println", type(String::class))

            return_void
        }
    }.let(::assemble)

    val helloWorldClass = EphemeralClassLoader(classBuffer).loadClass("HelloWorld")
    helloWorldClass.declaredMethods.first().invoke(null, emptyArray<String>())
}
