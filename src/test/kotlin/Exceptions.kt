import codes.som.anthony.koffee.assemble
import codes.som.anthony.koffee.insnsyntax.jvm.*
import util.EphemeralClassLoader
import java.io.PrintStream

fun main() {
    val classBuffer = assemble {
        name = "Exceptions"
        access = public

        method(public + static, "main", void, type(Array<String>::class)) {
            guard {
                new(type(RuntimeException::class))
                dup
                invokespecial(type(RuntimeException::class), "<init>", void)
                athrow
            }.handle(type(RuntimeException::class)) {
                getstatic(type(System::class), "out", type(PrintStream::class))
                ldc("Caught an exception!")
                invokevirtual(type(PrintStream::class), "println", void, type(String::class))

                invokevirtual(type(Exception::class), "printStackTrace", void)
            }

            return_void
        }
    }.let(::assemble)

    val exceptionTestClass = EphemeralClassLoader(classBuffer).loadClass("Exceptions")
    exceptionTestClass.declaredMethods.first().invoke(null, emptyArray<String>())
}
