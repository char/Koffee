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
                pop

                getstatic(type(System::class), "out", type(PrintStream::class))
                ldc("Caught an expected RuntimeException")
                invokevirtual(type(PrintStream::class), "println", void, type(String::class))
            }

            guard {
                getstatic(type(System::class), "out", type(PrintStream::class))
                aconst_null
                invokevirtual(type(Object::class), "toString", type(String::class))
                invokevirtual(type(PrintStream::class), "println", void, type(String::class))
            }.handle(type(NullPointerException::class)) {
                invokevirtual(type(Throwable::class), "printStackTrace", void)
            }.handle(type(Exception::class)) {
                getstatic(type(System::class), "err", type(PrintStream::class))
                ldc("Caught an unexpected Exception")
                invokevirtual(type(PrintStream::class), "println", void, type(String::class))

                invokevirtual(type(Throwable::class), "printStackTrace", void)
            }

            return_void
        }
    }.let(::assemble)

    val exceptionTestClass = EphemeralClassLoader(classBuffer).loadClass("Exceptions")
    exceptionTestClass.declaredMethods.first().invoke(null, emptyArray<String>())
}
