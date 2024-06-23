package kinject.benchmark

/**
 * A main method for profiling the application
 */
fun main() {
    val largeExamples = (1..10000)
        .map {
            val objectGraph = LargeExample.createKinject()
            objectGraph.get<LargeExample>()
        }
    println(largeExamples.size)
}
