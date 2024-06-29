package kinject.compose

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import kinject.ObjectGraph

val LocalKinjectContext = compositionLocalOf<KinjectContext> {
    error(
        "No ObjectGraph or KinjectCache provided. Please use the `ObjectGraphProvider` " +
            "Composable in a root Composable.",
    )
}

@Stable
class KinjectContext(
    val objectGraph: ObjectGraph,
) {
    private var map: MutableMap<String, Any>? = null

    fun put(key: String, value: Any) {
        val map = map
            ?: HashMap<String, Any>()
                .also { map = it }

        map[key] = value
    }

    operator fun <T : Any> get(key: String): T? {
        @Suppress("UNCHECKED_CAST")
        return map?.get(key) as T?
    }
}
