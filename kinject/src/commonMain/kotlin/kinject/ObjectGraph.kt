package kinject

import kinject.KinjectPlatform.className
import kotlin.reflect.KClass

inline fun objectGraph(
    create: ObjectGraph.Builder.() -> Unit,
): ObjectGraph {
    val builder = ObjectGraph.Builder()
    builder.create()
    return builder.build()
}

class ObjectGraph private constructor(
    private val bindings: Map<String, Binding>,
) {
    inline fun <reified T : Any> get(): T = get(T::class)

    fun <T : Any> get(clazz: KClass<T>): T = internalGet(clazz.className)

    @Suppress("UNCHECKED_CAST")
    private fun <T : Any> internalGet(className: String, tag: String? = null): T {
        val binding = bindings[className]
            ?: throw BindingNotFoundException("Binding not found for class '$className'")
        return binding.resolve(this) as T
    }

    class Builder {
        private val bindings: MutableMap<String, Binding> = HashMap()

        fun add(objectGraph: ObjectGraph) {
            bindings.putAll(objectGraph.bindings)
        }

        inline fun <reified T : Any> singleton(
            noinline provider: ObjectGraph.() -> T,
        ): Unit = singleton(T::class, provider)

        fun <T : Any> singleton(
            clazz: KClass<T>,
            provider: ObjectGraph.() -> T,
        ) {
            val bindingId = clazz.className
            bindings[bindingId] = SingletonLazyBinding(bindingId, provider)
        }

        fun <T : Any> singleton(
            instance: T,
            bindType: KClass<*> = instance::class,
        ) {
            val bindingId = bindType.className
            bindings[bindingId] = SingletonBinding(bindingId, instance)
        }

        fun build(): ObjectGraph {
            return ObjectGraph(bindings)
        }
    }
}
