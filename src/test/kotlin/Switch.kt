import codes.som.anthony.koffee.assemble
import codes.som.anthony.koffee.insnsyntax.jvm.*
import util.EphemeralClassLoader
import java.io.PrintStream

fun main() {
    val classBuffer = assemble {
        name = "SwitchTest"
        access = public

        method(public + static, void, "switchTest", int) {
            labelScope {
                iload_0
                lookupswitch(L["switch_default"], 1 to L["switch_1"], 2 to L["switch_2"], 100 to L["switch_100"])

                val exitSwitch = { goto(L["switch_end"]) }

                +L["switch_1"]
                ldc("One!")
                astore_1
                exitSwitch()

                +L["switch_2"]
                ldc("Two!")
                astore_1
                exitSwitch()

                +L["switch_100"]
                ldc("One hundred!")
                astore_1
                exitSwitch()

                +L["switch_default"]
                ldc("I don't know!")
                astore_1
                exitSwitch()

                +L["switch_end"]

                getstatic(type(System::class), "out", type(PrintStream::class))
                aload_1
                invokevirtual(type(PrintStream::class), void, "println", type(String::class))
            }

            return_void
        }

        method(public + static, void, "main", type(Array<String>::class)) {
            iconst_1
            invokestatic(thisType, void, "switchTest", int)

            iconst_2
            invokestatic(thisType, void, "switchTest", int)

            iconst_m1
            invokestatic(thisType, void, "switchTest", int)

            bipush(100)
            invokestatic(thisType, void, "switchTest", int)

            return_void
        }
    }

    val switchTestClass = EphemeralClassLoader(classBuffer).loadClass("SwitchTest")
    switchTestClass.getDeclaredMethod("main", Array<String>::class.java).invoke(null, emptyArray<String>())
}
