package kinject.coroutines

import kinject.ObjectGraph
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kinject.KinjectException

class KinjectCoroutineContextElement(
    val objectGraph: ObjectGraph
) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<KinjectCoroutineContextElement>
}

/**
 * Takes the given [CoroutineContext] and combines it with a [KinjectCoroutineContextElement].
 */
operator fun CoroutineContext.plus(objectGraph: ObjectGraph): CoroutineContext =
    this.plus(KinjectCoroutineContextElement(objectGraph))

/**
 * Retrieve the closest [ObjectGraph] from the current [CoroutineContext], or returns null if one
 * can't be found.
 */
fun CoroutineContext.objectGraphOrNull(): ObjectGraph? {
    return this[KinjectCoroutineContextElement]?.objectGraph
}

/**
 * Retrieve the closest [ObjectGraph] from the given [CoroutineContext].
 *
 * @throws [KinjectException] if the [ObjectGraph] can't be retrieved because there is no
 *  [KinjectCoroutineContextElement] in the current [CoroutineContext].
 */
fun CoroutineContext.objectGraph(): ObjectGraph {
    return this[KinjectCoroutineContextElement]?.objectGraph
        ?: throw KinjectException("Can't find 'KinjectCoroutineContextElement' in the current CoroutineContext.")
}

/**
 * Retrieve the closest [ObjectGraph] from the current [CoroutineContext], or returns null if one
 * can't be found.
 */
suspend fun objectGraphOrNull(): ObjectGraph? = coroutineContext.objectGraphOrNull()

/**
 * Retrieve the closest [ObjectGraph] from the current [CoroutineContext].
 *
 * @throws [KinjectException] if the [ObjectGraph] can't be retrieved because there is no
 *  [KinjectCoroutineContextElement] in the current [CoroutineContext].
 */
suspend fun objectGraph(): ObjectGraph = coroutineContext.objectGraph()

/**
 * Lazily inject a dependency from the closest [ObjectGraph] in the current [CoroutineContext].
 */
suspend inline fun <reified T : Any> inject(): Lazy<T> {
    val objectGraph = objectGraph()
    return lazy { objectGraph.get(T::class) }
}
