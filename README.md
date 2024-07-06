# Kinject

[![Download](https://img.shields.io/maven-central/v/dev.scottpierce/kinject)](https://central.sonatype.com/artifact/dev.scottpierce/kinject-core/versions)

**This library was made from a series of blog posts on creating a Kotlin Dependency Injection Library.
You can find all the posts [here](https://scottpierce.dev/categories/making-a-kotlin-dependency-injection-library/).**

A multiplatform Dependency Injection library.

## Artifacts

```kotlin
implementation("dev.scottpierce:kinject-core:<latest version here>")
```

| Artifact                   | Description                                                                                                                                    |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| kinject-core               | Provides core DI functionality.                                                                                                                |
| kinject-android            | Provides helper methods for working with `ObjectGraph`s embedded in `Context`s, and helper classes for embedding `ObjectGraph`s in `Contexts`. |
| kinject-android-appcompat  | Provides `KinjectAppCompatActivity`.                                                                                                           |
| kinject-android-compose    | Provides `KinjectComponentActivity`.                                                                                                           |
| kinject-compose            | Provides the ability to provide an ObjectGraph in a Compose hierarchy.                                                                         |
| kinject-compose-viewmodel  | Provides the ability to get a ViewModel in a compose hierarchy.                                                                                |
| kinject-coroutines         | Provides a `KinjectCoroutineContextElement`, to easily allow passing an `ObjectGraph` via a `CoroutineContext`.                                |
| kinject-viewmodel          | Provides the ability to declare a view model dependency, and a factory to create it.                                                           |


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
