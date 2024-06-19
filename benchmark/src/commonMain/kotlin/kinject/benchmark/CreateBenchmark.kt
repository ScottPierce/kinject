@file:Suppress("unused")

package kinject.benchmark

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.BenchmarkMode
import kotlinx.benchmark.Mode
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
class CreateBenchmark {
    @Benchmark
    fun kinjectSmall() {
        SmallExample.createKinject()
    }

    @Benchmark
    fun kinjectLarge() {
        LargeExample.createKinject()
    }

//    @Benchmark
//    fun koinSmall() {
//        SmallExample.createKoin()
//    }
//
//    @Benchmark
//    fun koinLarge() {
//        LargeExample.createKoin()
//    }
}
