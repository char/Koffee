import codes.som.koffee.assembleClass
import codes.som.koffee.insns.jvm.*
import codes.som.koffee.modifiers.public
import codes.som.koffee.sugar.ClassAssemblyExtension.clinit
import codes.som.koffee.sugar.ClassAssemblyExtension.init
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.ClassWriter.COMPUTE_FRAMES
import java.io.PrintStream

fun main() {
    val helloWorld = assembleClass(public, "com/example/HelloWorld") {
        clinit {
            getstatic(System::class, "out", PrintStream::class)
            ldc("<clinit>")
            invokevirtual(PrintStream::class, "println", void, String::class)
            _return
        }

        init(public, String::class) {
            getstatic(System::class, "out", PrintStream::class)
            ldc("<init>: ")
            invokevirtual(PrintStream::class, "print", void, String::class)

            getstatic(System::class, "out", PrintStream::class)
            aload_1 // param
            invokevirtual(PrintStream::class, "println", void, String::class)

            _return
        }
    }

    val classBuffer = ClassWriter(COMPUTE_FRAMES).let {
        helloWorld.accept(it)
        it.toByteArray()
    }
    
    val helloWorldClass = EphemeralClassLoader(classBuffer).loadClass("com.example.HelloWorld")
    helloWorldClass.declaredConstructors.first().newInstance("Parameter")
}

