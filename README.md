# Koffee

A Kotlin DSL wrapping ObjectWeb's ASM bytecode manipulation library. (In particular, `asm-tree`.)

## Limitations

Since the DSL is in Kotlin, there are a few reserved words that get in our way.
In order to get around this, we provide properties with the literal name and use backtick-escaping,
and the preferred approach of a leading underscore before the reserved name.

- Since 'interface' is a globally reserved keyword in Kotlin, the access flag `interface` can be referenced using
`` `interface` `` or `_interface`
- Since 'super' is a globally reserved keyword in Kotlin, the access flag `super` can be referenced using
`` `super` `` or `_super`
- Since 'return' is a globally reserved keyword in Kotlin, the instruction `return` can be referenced using
`` `return` `` or `_return`

## Extras

Kotlin makes life a lot easier for simplifying the user's experience. It allows Koffee to do some useful things:
- All bytecode instructions are represented as simple methods (e.g. `getfield(...)`) or properties (e.g. `aconst_null`)
- Fields are created with a single function call (e.g. `field(...)`)
- Methods are created with an easy way to add individual bytecode (see the [example](#simple-example))
- Lots of sugar exists for commonly used constructs:
  - `init` and `clinit` methods
  - Object creation (with `construct`)
  - Try/catch blocks (with `guard` and its returned object to add exception handlers)

## Simple Example

```kotlin
val helloWorld: ClassNode = assembleClass(public, "com/example/HelloWorld") {
    method(public + static, "main", void, Array<String>::class) {
        getstatic(System::class, "out", PrintStream::class)
        ldc("Hello, world!")
        invokevirtual(PrintStream::class, "println", void, String::class)
        _return
    }
}
```

## Complex Example

```kotlin
val myClass = assembleClass(public, "com/example/MyClass") {
    field(public + static + final, "theAnswer", int, value = 42)
    field(private + static + final, "instance", MyClass::class)

    method(public + static, "getInstance", MyClass::class) {
        getstatic(MyClass::class, "instance", MyClass::class)
        dup
        ifnull(L["oh noes"])
        _return
        +L["oh noes"]
        construct(IOException::class, String::class) {
            ldc("no instance exists whatever shall we do?")
        }
        athrow
    }

    init(public) {
        // nothing extra: the superclass is called automatically, and no fields are initialized
    }

    clinit {
        construct(MyClass::class)
        putstatic(MyClass::class, "instance", MyClass::class)
    }
}
```

## Goals

- Koffee is designed to be used in projects that already make use of ASM, so we don't need to abstract too far away.
- Despite this, Koffee should aim to make the use of ASM easier - High-level abstractions are acceptable if they are common. (e.g. 'load int constant' can be made uniform)
