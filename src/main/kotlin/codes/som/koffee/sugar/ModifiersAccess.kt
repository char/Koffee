package codes.som.koffee.sugar

import codes.som.koffee.modifiers.Modifiers

@Suppress("PropertyName")
public interface ModifiersAccess {
    /**
     * Package-private indicates that this class, method, or field is visible only within the package.
     */
    public val package_private: Modifiers get() = codes.som.koffee.modifiers.package_private

    /**
     * Public indicates that this class, method, or field is visible to all callers.
     */
    public val public:          Modifiers get() = codes.som.koffee.modifiers.public

    /**
     * Private indicates that this class, method, or field is visible only within the defining file.
     */
    public val private:         Modifiers get() = codes.som.koffee.modifiers.private

    /**
     * Protected indicates that this class, method, or field is visible only within the defining file and to all subclasses.
     */
    public val protected:       Modifiers get() = codes.som.koffee.modifiers.protected

    /**
     * Static indicates that this class, method, or field is not attached to an instance of its declaring class.
     */
    public val static:          Modifiers get() = codes.som.koffee.modifiers.static

    /**
     * Final indicates that this class, method, or field cannot be overridden or mutated.
     */
    public val final:           Modifiers get() = codes.som.koffee.modifiers.final

    /**
     * Super is a special flag that is always considered set for classes in Java 8 and later.
     */
    public val `super`:         Modifiers get() = codes.som.koffee.modifiers.`super`
    public val _super:          Modifiers get() = codes.som.koffee.modifiers._super

    /**
     * Synchronized is a method modifier indicating that invocations are wrapped with a monitor lock.
     */
    public val synchronized:    Modifiers get() = codes.som.koffee.modifiers.synchronized

    /**
     * Open is a module modifier indicating that the module is open for reflective access.
     */
    public val open:            Modifiers get() = codes.som.koffee.modifiers.open

    /**
     * Transitive is a module modifier indicating that the dependencies
     * implicitly declare dependencies on the declared module.
     */
    public val transitive:      Modifiers get() = codes.som.koffee.modifiers.transitive

    /**
     * Volatile is a field modifier indicating that a field will update all threads' views of its value upon each write.
     */
    public val volatile:        Modifiers get() = codes.som.koffee.modifiers.volatile

    /**
     * Bridge is a method modifier indicating that the method is a bridge method generated by the compiler.
     */
    public val bridge:          Modifiers get() = codes.som.koffee.modifiers.bridge

    /**
     * Static phase is a module modifier indicating that the module is required during static analysis,
     * but is optional during runtime.
     */
    public val static_phase:    Modifiers get() = codes.som.koffee.modifiers.static_phase

    /**
     * Varargs is a method modifier indicating that the method consumes an array as a variable number of arguments.
     * This is used for compilers to depend on compiled code containing varargs methods.
     */
    public val varargs:         Modifiers get() = codes.som.koffee.modifiers.varargs

    /**
     * Transient is a field modifier indicating that a field is not to be serialized.
     */
    public val transient:       Modifiers get() = codes.som.koffee.modifiers.transient

    /**
     * Native is a method modifier indicating that the method is implemented in a language other than Java.
     */
    public val native:          Modifiers get() = codes.som.koffee.modifiers.native

    /**
     * Interface is a class modifier indicating that the class is an interface.
     * Annotations also have this modifier.
     */
    public val `interface`:     Modifiers get() = codes.som.koffee.modifiers.`interface`
    public val _interface:      Modifiers get() = codes.som.koffee.modifiers._interface

    /**
     * Abstract is a class modifier indicating that the class is abstract.
     * Interfaces and annotations also have this modifier.
     */
    public val abstract:        Modifiers get() = codes.som.koffee.modifiers.abstract

    /**
     * Strict is a field modifier indicating that a floating-point value should use the IEEE 754 standard
     * for arithmetic operations instead of Java's legacy close-enough-but-not-quite behavior.
     */
    public val strict:          Modifiers get() = codes.som.koffee.modifiers.strict

    /**
     * Synthetic is a class, field, or method modifier indicating that the item is not part of the source code.
     */
    public val synthetic:       Modifiers get() = codes.som.koffee.modifiers.synthetic

    /**
     * Annotation is a class modifier indicating that the class is an annotation.
     * All annotations must implement the [java.lang.annotation.Annotation] interface.
     */
    public val annotation:      Modifiers get() = codes.som.koffee.modifiers.annotation

    /**
     * Enum is a class modifier indicating that the class is an enum.
     * All enums must extend the [java.lang.Enum] class.
     */
    public val enum:            Modifiers get() = codes.som.koffee.modifiers.enum

    /**
     * Mandated is a class, field, or method modifier indicating that the item is not
     * considered implementation artifacts despite being compiler-generated.
     */
    public val mandated:        Modifiers get() = codes.som.koffee.modifiers.mandated

    /**
     * Module is a class modifier indicating that the class is a module declaration.
     * Modules are funky. To understand them, please read the specification:
     * - [HTML](https://docs.oracle.com/javase/specs/jvms/se18/html/index.html)
     * - [PDF](https://docs.oracle.com/javase/specs/jvms/se18/jvms18.pdf)
     */
    public val module:          Modifiers get() = codes.som.koffee.modifiers.module

    /**
     * Deprecated is a special class, field, or method modifier indicating that the item is deprecated.
     * In modern versions, a [Deprecated] annotation is preferred.
     */
    public val deprecated:      Modifiers get() = codes.som.koffee.modifiers.deprecated
}
