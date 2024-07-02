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
    internal fun <T : Any> internalGet(className: String): T {
        val binding = bindings[className]
            ?: throw BindingNotFoundException("Binding not found for class '$className'")
        return binding.resolve(this) as T
    }

    class Builder {
        private val bindings: MutableMap<String, Binding> = HashMap()

        fun add(objectGraph: ObjectGraph) {
            for ((bindingKey, binding) in objectGraph.bindings) {
                addBinding(binding = binding, key = bindingKey)
            }
        }

        inline fun <reified T : Any> singleton(
            noinline provider: ObjectGraph.() -> T,
        ): Unit = singleton(T::class, provider)

        fun <T : Any> singleton(
            clazz: KClass<T>,
            provider: ObjectGraph.() -> T,
        ) {
            val bindingKey = clazz.className
            addBinding(
                key = bindingKey,
                binding = SingletonLazyBinding(key = bindingKey, provider = provider),
            )
        }

        fun <T : Any> singleton(
            instance: T,
            bindType: KClass<*> = instance::class,
        ) {
            val bindingKey = bindType.className
            addBinding(
                key = bindingKey,
                binding = SingletonBinding(key = bindingKey, instance = instance),
            )
        }

        inline fun <reified T : Any> factory(
            noinline provider: ObjectGraph.() -> T,
        ): Unit = singleton(T::class, provider)

        fun <T : Any> factory(
            clazz: KClass<T>,
            provider: ObjectGraph.() -> T,
        ) {
            val bindingKey = clazz.className
            addBinding(
                key = bindingKey,
                binding = FactoryBinding(key = bindingKey, provider = provider),
            )
        }

        private fun addBinding(
            key: String,
            binding: Binding,
        ) {
            if (bindings.containsKey(key)) {
                throw KinjectException("Duplicate binding for class '${binding.key}'")
            } else {
                bindings[key] = binding
            }
        }

        fun build(): ObjectGraph {
            return ObjectGraph(bindings)
        }
    }
}
