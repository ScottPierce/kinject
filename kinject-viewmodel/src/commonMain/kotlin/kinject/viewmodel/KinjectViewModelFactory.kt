package kinject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kinject.ObjectGraph
import kotlin.reflect.KClass

class KinjectViewModelFactory(
    private val objectGraph: ObjectGraph,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        return objectGraph.get(modelClass)
    }
}
