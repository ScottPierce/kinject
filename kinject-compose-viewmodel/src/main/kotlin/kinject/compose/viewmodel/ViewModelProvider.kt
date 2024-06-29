package kinject.compose.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import kinject.compose.KinjectContext
import kinject.viewmodel.KinjectViewModelFactory

private const val KEY_VIEW_MODEL_PROVIDER = "view-model-provider"

@Composable
fun KinjectContext.viewModelProvider(): ViewModelProvider {
    get<ViewModelProvider>(KEY_VIEW_MODEL_PROVIDER)
        ?.let { return@let it }

    val viewModelStoreOwner = LocalViewModelStoreOwner.current
        ?: error("ViewModelStoreOwner not found")
    val factory = KinjectViewModelFactory(objectGraph)

    return ViewModelProvider(viewModelStoreOwner, factory)
        .also { put(KEY_VIEW_MODEL_PROVIDER, it) }
}
