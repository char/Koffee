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

## Example

```kotlin
val helloWorld: ClassNode = assembleClass(public, "com/example/HelloWorld") {
    name = "com/example/HelloWorld"

    method(public + static, "main", Array<String>::class) {
        getstatic(System::class, "out", PrintStream::class)
        ldc("Hello, world!")
        invokevirtual(PrintStream::class, void, String::class)
        _return
    }
}
```

## Goals

- Koffee is designed to be used in projects that already make use of ASM, so we don't need to abstract too far away.
- Despite this, Koffee should aim to make the use of ASM easier - High-level abstractions are acceptable if they are common. (e.g. 'load int constant' can be made uniform)
