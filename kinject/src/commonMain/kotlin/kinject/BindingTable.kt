package kinject

internal interface BindingTable : Iterable<Binding> {
    fun put(binding: Binding)
    operator fun get(className: String): Binding?
}

internal fun BindingTable(capacity: Int): BindingTable = HashMapBindingTable(capacity = capacity)

private class HashMapBindingTable(capacity: Int) : BindingTable {
    private val map = HashMap<String, Binding>(capacity)

    override fun put(binding: Binding) {
        if (map.containsKey(binding.id)) {
            throw KinjectException("Duplicate binding for class '${binding.id}'")
        } else {
            map[binding.id] = binding
        }
    }

    override fun get(className: String): Binding? = map[className]

    override fun iterator(): Iterator<Binding> = map.values.iterator()
}
