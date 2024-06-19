package kinject

import kotlin.math.absoluteValue

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

private class HashedBindingTable(capacity: Int) : BindingTable {
    /** Table size should be at least 30% larger than the storage size and also a prime number */
    val tableSize: Int = PrimeNumbers.getNextPrime(((capacity * 1.3f) + 1).toInt())
    val bindings: Array<Binding?> = arrayOfNulls(tableSize)

    private fun lookup(className: String): Int {
        var hashCode = className.hashCode()

        var currentBinding: Binding?
        var index: Int
        do {
            hashCode = hashCode * 57 + 43
            index = (hashCode % tableSize).absoluteValue
            currentBinding = bindings[index]
        } while (
            currentBinding != null && currentBinding.id != className
        )

        return index
    }

    override fun get(className: String): Binding? {
        val index = lookup(className)
        return bindings[index]
    }

    override fun put(binding: Binding) {
        val i = lookup(binding.id)
        if (bindings[i] == null) {
            bindings[i] = binding
        } else {
            throw KinjectException("Duplicate binding for class '${binding.id}'")
        }
    }

    override fun iterator(): Iterator<Binding> = BindingHashTableIterator(this)
}

private class BindingHashTableIterator(val table: HashedBindingTable) : Iterator<Binding> {
    companion object {
        private const val COMPLETE = -2
    }

    private var nextI = -1 // initialized to -1 as findNext() could set it to 0

    init {
        findNext()
    }

    private fun findNext() {
        for (i in (nextI + 1) until table.tableSize) {
            if (table.bindings[i] != null) {
                nextI = i
                return
            }
        }

        nextI = COMPLETE
    }

    override fun hasNext(): Boolean = nextI != COMPLETE

    override fun next(): Binding {
        val binding = table.bindings[nextI]!!
        findNext()
        return binding
    }
}
