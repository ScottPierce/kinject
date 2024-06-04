@file:Suppress("unused")

package kinject.benchmark

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class ObjectGraphCreationBenchmark {
    @Benchmark
    fun benchmark() {
        ObjectGraphs.simpleObjectGraph()
    }
}
