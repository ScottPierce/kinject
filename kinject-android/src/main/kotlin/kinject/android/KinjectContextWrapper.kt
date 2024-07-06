package kinject.android

import android.content.Context
import android.content.ContextWrapper
import kinject.HasObjectGraph
import kinject.ObjectGraph
import kinject.android.KinjectApplication.Companion.KINJECT_SERVICE

class KinjectContextWrapper(
    base: Context,
    override val objectGraph: ObjectGraph,
) : ContextWrapper(base), HasObjectGraph {
    override fun getSystemService(name: String): Any {
        return when (name) {
            KINJECT_SERVICE -> objectGraph
            else -> super.getSystemService(name)
        }
    }

    override fun getSystemServiceName(serviceClass: Class<*>): String? {
        return if (serviceClass === ObjectGraph::class.java) {
            KINJECT_SERVICE
        } else {
            super.getSystemServiceName(serviceClass)
        }
    }
}
