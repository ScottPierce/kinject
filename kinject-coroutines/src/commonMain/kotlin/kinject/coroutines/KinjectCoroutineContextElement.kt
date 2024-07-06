package kinject.coroutines

import kinject.ObjectGraph
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class KinjectCoroutineContextElement(
    val objectGraph: ObjectGraph
) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<KinjectCoroutineContextElement>
}

fun CoroutineContext.objectGraphOrNull(): ObjectGraph? {
    return this[KinjectCoroutineContextElement]?.objectGraph
}

fun CoroutineContext.objectGraph(): ObjectGraph {
    return this[KinjectCoroutineContextElement]?.objectGraph
        ?: error("Can't find 'KinjectCoroutineContextElement' in the current CoroutineContext.")
}

operator fun CoroutineContext.plus(objectGraph: ObjectGraph) =
    this.plus(KinjectCoroutineContextElement(objectGraph))

suspend fun objectGraphOrNull(): ObjectGraph? = coroutineContext.objectGraphOrNull()

suspend fun objectGraph(): ObjectGraph = coroutineContext.objectGraph()
