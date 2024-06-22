# Kinject

[![Download](https://img.shields.io/maven-central/v/dev.scottpierce/kinject)](https://central.sonatype.com/artifact/dev.scottpierce/kinject/versions)

**This is from a blog post series on creating a Kotlin Dependency Injection Library.
You can find all the posts [here](https://scottpierce.dev/categories/making-a-kotlin-dependency-injection-library/).**

A multiplatform Dependency Injection library.

## Usage

```kotlin
class A

class B(val a: A)

class C(
    val a: A,
    val b: B,
)

val graph = objectGraph {
    singleton(A())                          // Provided Binding
    singleton { B(a = get()) }              // Lazy Binding
    singleton { C(a = get(), b = get()) }   // Lazy Binding
}

val a: A = graph.get()
val b: B = graph.get()
val c: C = graph.get()
```
