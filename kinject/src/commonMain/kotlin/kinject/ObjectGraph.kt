package kinject

import kinject.KinjectPlatform.bindingId
import kotlin.reflect.KClass

inline fun objectGraph(
    create: ObjectGraph.Builder.() -> Unit,
): ObjectGraph {
    val builder = ObjectGraph.Builder()
    builder.create()
    return builder.build()
}

class ObjectGraph private constructor(
    private val bindingTable: BindingTable,
) {
    inline fun <reified T : Any> get(): T = get(T::class)

    fun <T : Any> get(clazz: KClass<T>): T = internalGet(clazz.bindingId)

    @Suppress("UNCHECKED_CAST")
    private fun <T : Any> internalGet(className: String, tag: String? = null): T {
        val binding = bindingTable[className]
            ?: throw BindingNotFoundException("Binding not found for class '$className'")
        return binding.resolve(this) as T
    }

    class Builder {
        private val bindings: MutableList<Binding> = mutableListOf()

        fun add(objectGraph: ObjectGraph) {
            bindings.addAll(objectGraph.bindingTable)
        }

        inline fun <reified T : Any> singleton(
            noinline provider: ObjectGraph.() -> T,
        ): Unit = singleton(T::class, provider)

        fun <T : Any> singleton(
            clazz: KClass<T>,
            provider: ObjectGraph.() -> T,
        ) {
            bindings += SingletonLazyBinding(clazz.bindingId, provider)
        }

        fun <T : Any> singleton(
            instance: T,
            bindType: KClass<*> = instance::class,
        ) {
            bindings += SingletonBinding(bindType.bindingId, instance)
        }

        fun build(): ObjectGraph {
            val bindingTable = BindingTable(bindings.size)
            for (binding in bindings) {
                bindingTable.put(binding)
            }
            return ObjectGraph(bindingTable)
        }
    }
}
