package kinject.compose.voyager

import cafe.adriel.voyager.core.model.ScreenModel
import kinject.ObjectGraph

/**
 * A ScreenModel representation that delegates to factory.
 */
inline fun <reified SM : ScreenModel> ObjectGraph.Builder.screenModel(
    noinline provider: ObjectGraph.() -> SM,
): Unit = factory(SM::class, provider)
