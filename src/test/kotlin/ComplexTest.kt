import codes.som.koffee.assembleClass
import codes.som.koffee.insns.jvm.*
import codes.som.koffee.insns.sugar.construct
import codes.som.koffee.modifiers.final
import codes.som.koffee.modifiers.public
import codes.som.koffee.sugar.ClassAssemblyExtension.clinit
import codes.som.koffee.sugar.ClassAssemblyExtension.init
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.objectweb.asm.ClassWriter
import java.util.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ComplexTest {
    @Test
    fun `Test if a complex class compiles as intended`() {
        val classNode = assembleClass(public + final, "com/example/TestClass") {
            field(public + static + final, "theAnswer", int, value = 42)
            field(public + static + final, "instance", self)
            field(private, "privateField", int)

            init(private) {
                aload_0
                construct(Random::class)
                invokevirtual(Random::class, "nextInt", int)
                putfield(self, "privateField", int)
                `return`
            }

            method(public, "getField", int) {
                aload_0
                getfield(self, "privateField", int)
                ireturn
            }

            clinit {
                construct(self)
                putstatic(self, "instance", self)
                `return`
            }
        }

        val bytes = ClassWriter(ClassWriter.COMPUTE_FRAMES).also { classNode.accept(it) }.toByteArray()

        val `class` = EphemeralClassLoader(bytes).loadClass("com.example.TestClass")

        assertNotNull(`class`, "A class should be generated")

        val answerField = assertDoesNotThrow("Answer field should exist") { `class`.getDeclaredField("theAnswer")!! }
        assertEquals(42, answerField.getInt(null), "Answer field should be 42")

        val instanceField = assertDoesNotThrow("Instance field should exist") { `class`.getDeclaredField("instance")!! }
        val instance = Assertions.assertInstanceOf(`class`, instanceField.get(null)!!, "Instance field should be an instance of the class")

        val getFieldMethod = assertDoesNotThrow("getField method should exist") { `class`.getDeclaredMethod("getField")!! }
        val fieldField = assertDoesNotThrow("privateField field should exist") { `class`.getDeclaredField("privateField")!! }
        fieldField.isAccessible = true
        assertEquals(fieldField.getInt(instance), getFieldMethod.invoke(instance), "getField should return the value of privateField")
    }
}