# Koffee

A Kotlin DSL for (dis)assembly of Java bytecode, using ObjectWeb ASM.

## Example

```kotlin
val helloWorld: ClassNode = assemble {
    name = "com/example/HelloWorld"

    method(public + static, "main", void, type(Array<String>::class)) {
        getstatic(type(System::class), "out", type(PrintStream::class))
        ldc("Hello, world!")
        invokevirtual(type(PrintStream::class), "println", void, type(String::class))
        return_void
    }
}
```

## Limitations

Since we have to emit working Kotlin, there are a few limitations to the design:

- Since 'interface' is a globally reserved keyword in Kotlin, the access flag `interface` can be referenced using
`` `interface` `` or `_interface` (`_interface` is preferred)
- Since 'super' is a globally reserved keyword in Kotlin, the access flag `super` can be referenced using
`` `super` `` or `_super` (`_super` is preferred)
- Since 'return' is a globally reserved keyword in Kotlin, the instruction `return` can be referenced using
`` `return` ``, `_return`, `return_void`, or `vreturn` (`return_void` is preferred)

## Roadmap

- Support try/catch blocks
- Koffee as a CLI assembler/disassembler
