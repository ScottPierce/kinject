package kinject.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import kinject.ObjectGraph

object LocalObjectGraph {
    /**
     * Returns current composition local value for an [ObjectGraph] or throws an
     * [IllegalStateException] if one has not been provided.
     */
    val current: ObjectGraph
        @Composable
        get() = LocalKinjectContext.current.objectGraph

    internal infix fun provides(objectGraph: ObjectGraph): ProvidedValue<KinjectContext> {
        return LocalKinjectContext.provides(KinjectContext(objectGraph))
    }
}
