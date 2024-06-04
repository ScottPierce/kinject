package kinject.benchmark

import kinject.ObjectGraph
import kinject.objectGraph

object ObjectGraphs {
    fun simpleObjectGraph(): ObjectGraph {
        return objectGraph {
            singleton { A() }
            singleton { B(get()) }
            singleton { C(get(), get()) }
            singleton { D(get(), get(), get()) }
            singleton { E(get()) }
        }
    }
}
