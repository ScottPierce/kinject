package kinject.android

import androidx.lifecycle.ViewModel
import kinject.ObjectGraph

/**
 * A ViewModel representation that delegates to
 */
inline fun <reified T : ViewModel> ObjectGraph.Builder.viewModel(
    noinline provider: ObjectGraph.() -> T,
): Unit = factory(T::class, provider)
