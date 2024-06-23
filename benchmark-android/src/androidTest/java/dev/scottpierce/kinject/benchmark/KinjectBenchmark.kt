package dev.scottpierce.kinject.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import kinject.benchmark.LargeExample
import kinject.benchmark.SmallExample
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KinjectBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun kinjectCreateSmall() {
        benchmarkRule.measureRepeated {
            SmallExample.createKinject()
        }
    }

    @Test
    fun kinjectCreateLarge() {
        benchmarkRule.measureRepeated {
            LargeExample.createKinject()
        }
    }

    @Test
    fun kinjectInjectSmall() {
        benchmarkRule.measureRepeated {
            val objectGraph = SmallExample.createKinject()
            objectGraph.get<SmallExample>()
        }
    }

    @Test
    fun kinjectInjectLarge() {
        benchmarkRule.measureRepeated {
            val objectGraph = LargeExample.createKinject()
            objectGraph.get<LargeExample>()
        }
    }

    @Test
    fun koinCreateSmall() {
        benchmarkRule.measureRepeated {
            SmallExample.createKoin()
        }
    }

    @Test
    fun koinCreateLarge() {
        benchmarkRule.measureRepeated {
            LargeExample.createKoin()
        }
    }

    @Test
    fun koinInjectSmall() {
        benchmarkRule.measureRepeated {
            val koin = SmallExample.createKoin()
            koin.get<SmallExample>()
        }
    }

    @Test
    fun koinInjectLarge() {
        benchmarkRule.measureRepeated {
            val koin = LargeExample.createKoin()
            koin.get<LargeExample>()
        }
    }
}
