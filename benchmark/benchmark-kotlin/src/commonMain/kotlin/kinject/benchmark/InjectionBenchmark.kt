@file:Suppress("unused", "UNUSED_VARIABLE")

package kinject.benchmark

import kinject.ObjectGraph
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.Setup
import kotlinx.benchmark.State
import org.koin.core.Koin

@State(Scope.Benchmark)
class InjectionBenchmark {
    lateinit var smallExampleKinject: ObjectGraph
    lateinit var largeExampleKinject: ObjectGraph
    lateinit var largeExampleKoin: Koin
    lateinit var smallExampleKoin: Koin

    @Setup
    fun setup() {
        smallExampleKinject = SmallExample.createKinject()
        largeExampleKinject = LargeExample.createKinject()
        smallExampleKoin = SmallExample.createKoin()
        largeExampleKoin = LargeExample.createKoin()
    }

    @Benchmark
    fun kinjectSmall() {
        smallExampleKinject.get<SmallExample>()
    }

    @Benchmark
    fun kinjectLarge() {
        largeExampleKinject.get<LargeExample>()
    }

    @Benchmark
    fun koinSmall() {
        smallExampleKoin.get<SmallExample>()
    }

    @Benchmark
    fun koinLarge() {
        largeExampleKoin.get<LargeExample>()
    }
}
