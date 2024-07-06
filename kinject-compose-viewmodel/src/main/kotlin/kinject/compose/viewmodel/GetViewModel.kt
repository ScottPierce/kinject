package kinject.compose.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kinject.compose.LocalKinjectContext

@Composable
inline fun <reified VM : ViewModel> injectViewModel(): VM {
    val vmClass = VM::class
    val kinjectContext = LocalKinjectContext.current
    val viewModelProvider = kinjectContext.viewModelProvider()

    return remember(vmClass, viewModelProvider) {
        viewModelProvider[vmClass.java]
    }
}
