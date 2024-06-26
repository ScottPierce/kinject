package kinject.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kinject.ObjectGraph
import kinject.get

class KinjectViewModelFactory(
    private val objectGraph: ObjectGraph
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return objectGraph.get(modelClass)
    }
}
