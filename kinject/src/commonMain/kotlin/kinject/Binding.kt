package kinject

internal interface Binding {
    val key: String

    fun resolve(objectGraph: ObjectGraph): Any
}

internal class SingletonLazyBinding<T>(
    override val key: String,
    provider: ObjectGraph.() -> T,
) : Binding {
    private var instance: T? = null
    private var resolve: (ObjectGraph.() -> T)? = provider
    private var isResolving = false

    override fun resolve(objectGraph: ObjectGraph): Any {
        if (instance == null) {
            KinjectPlatform.synchronized(this) {
                val resolve = resolve
                if (resolve != null) {
                    if (isResolving) {
                        throw CyclicDependencyException("A cyclic dependency was found for '$key'" +
                                "These should be avoided, but ObjectGraph.lazy() can be used as a work around if " +
                                "necessary.")
                    }
                    isResolving = true

                    try {
                        instance = objectGraph.resolve()
                    } catch (e: Exception) {
                        throw KinjectException(message = "Error creating dependency '$key'.", cause = e)
                    } finally {
                        this.resolve = null
                        isResolving = false
                    }
                }
            }
        }

        return instance!!
    }
}

internal class SingletonBinding<out T : Any>(
    override val key: String,
    val instance: T,
) : Binding {
    override fun resolve(objectGraph: ObjectGraph): Any = instance
}

internal class FactoryBinding<T : Any>(
    override val key: String,
    var provider: ObjectGraph.() -> T,
) : Binding {
    override fun resolve(objectGraph: ObjectGraph): Any = objectGraph.provider()
}
