package codes.som.anthony.koffee.sugar

import codes.som.anthony.koffee.ClassAssembly
import codes.som.anthony.koffee.MethodAssembly
import codes.som.anthony.koffee.insns.jvm.aload_0
import codes.som.anthony.koffee.insns.jvm.invokespecial
import codes.som.anthony.koffee.modifiers.Modifiers
import codes.som.anthony.koffee.types.TypeLike
import org.objectweb.asm.tree.MethodNode
import java.lang.IllegalArgumentException

object ClassAssemblyExtension {
    fun ClassAssembly.init(access: Modifiers, vararg parameterTypes: TypeLike,
                           superClass: TypeLike = Object::class, routine: MethodAssembly.() -> Unit): MethodNode {
        if (access.containsOther(public + private + protected + package_private)) {
            throw IllegalArgumentException("Method 'init' has illegal modifiers! " +
                    "Legal modifiers include: public, private, protected, and package private."
            )
        }

        return method(access, "<init>", void, *parameterTypes) {
            aload_0 // load this
            invokespecial(superClass, "<init>", void)

            routine()
        }
    }

    fun ClassAssembly.clinit(routine: MethodAssembly.() -> Unit): MethodNode {
        return method(static, "<clinit>", void, routine = routine)
    }
}