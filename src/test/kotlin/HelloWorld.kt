import codes.som.anthony.koffee.assemble
import codes.som.anthony.koffee.insnsyntax.jvm.*
import java.io.PrintStream

fun main() {
    val classBuffer = assemble {
        name = "HelloWorld"
        access = public

        method(public + static, void, "main", type(Array<String>::class)) {
            getstatic(type(System::class), "out", type(PrintStream::class))
            ldc("Hello, world!")
            invokevirtual(type(PrintStream::class), void, "println", type(String::class))
            _return
        }
    }

    class EphemeralClassLoader : ClassLoader() {
        override fun findClass(name: String): Class<*> {
            return defineClass(name, classBuffer, 0, classBuffer.size)
        }
    }

    val helloWorldClass = EphemeralClassLoader().loadClass("HelloWorld")
    helloWorldClass.declaredMethods.first().invoke(null, emptyArray<String>())
}
