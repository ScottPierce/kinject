package kinject.viewmodel

import androidx.lifecycle.ViewModel
import kinject.ObjectGraph

/**
 * A ViewModel representation that delegates to factory.
 */
inline fun <reified VM : ViewModel> ObjectGraph.Builder.viewModel(
    noinline provider: ObjectGraph.() -> VM,
): Unit = factory(VM::class, provider)
