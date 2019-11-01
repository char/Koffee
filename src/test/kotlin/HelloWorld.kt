import codes.som.anthony.koffee.assembleClass
import codes.som.anthony.koffee.insns.jvm._return
import codes.som.anthony.koffee.insns.jvm.getstatic
import codes.som.anthony.koffee.insns.jvm.invokevirtual
import codes.som.anthony.koffee.insns.jvm.ldc
import codes.som.anthony.koffee.modifiers.public
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.ClassWriter.COMPUTE_FRAMES
import java.io.PrintStream

class EphemeralClassLoader(val classBuffer: ByteArray) : ClassLoader() {
    override fun findClass(name: String): Class<*> {
        return defineClass(name, classBuffer, 0, classBuffer.size)
    }
}

fun main() {
    val helloWorld = assembleClass(public, "com/example/HelloWorld") {
        method(public + static, "main", void, Array<String>::class) {
            getstatic(System::class, "out", PrintStream::class)
            ldc("Hello, world!")
            invokevirtual(PrintStream::class, "println", void, String::class)
            _return
        }
    }

    val classBuffer = ClassWriter(COMPUTE_FRAMES).let {
        helloWorld.accept(it)
        it.toByteArray()
    }
    
    val helloWorldClass = EphemeralClassLoader(classBuffer).loadClass("com.example.HelloWorld")
    helloWorldClass.declaredMethods.first().invoke(null, emptyArray<String>())
}
