@file:Suppress("unused", "UNUSED_VARIABLE")

package kinject.benchmark

import kinject.ObjectGraph
import kinject.objectGraph
import kotlinx.benchmark.*

@State(Scope.Benchmark)
class ObjectGraphInjectionBenchmark {
    private lateinit var objectGraph: ObjectGraph

    @Setup
    fun setup() {
        objectGraph = ObjectGraphs.simpleObjectGraph()
    }

    @Benchmark
    fun benchmark() {
        val a: A = objectGraph.get()
        val b: B = objectGraph.get()
        val c: C = objectGraph.get()
        val d: D = objectGraph.get()
        val e: E = objectGraph.get()
    }

    @TearDown
    fun tearDown() {
        objectGraph = objectGraph { }
    }
}
