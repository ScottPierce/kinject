package kinject.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import kinject.ObjectGraph

@Composable
fun ObjectGraphProvider(
    objectGraph: ObjectGraph,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalKinjectContext provides KinjectContext(objectGraph),
        content = content,
    )
}
