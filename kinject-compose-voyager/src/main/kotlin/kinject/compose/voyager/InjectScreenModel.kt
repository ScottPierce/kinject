package kinject.compose.voyager

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import kinject.compose.LocalKinjectContext

@Composable
inline fun <reified SM : ScreenModel> Screen.injectScreenModel(): SM {
    val smClass = SM::class
    val kinjectContext = LocalKinjectContext.current

    return rememberScreenModel {
        kinjectContext.objectGraph.get(smClass)
    }
}

@Composable
inline fun <reified SM : ScreenModel> Navigator.injectNavigatorScreenModel(): SM {
    val smClass = SM::class
    val kinjectContext = LocalKinjectContext.current

    return rememberNavigatorScreenModel {
        kinjectContext.objectGraph.get(smClass)
    }
}
