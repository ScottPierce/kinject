package kinject.android

import android.app.Application
import kinject.HasObjectGraph
import kinject.ObjectGraph

abstract class KinjectApplication : Application(), HasObjectGraph {
    companion object {
        const val KINJECT_SERVICE = "kinject"
    }

    override val objectGraph: ObjectGraph by lazy { createObjectGraph() }

    protected abstract fun createObjectGraph(): ObjectGraph

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
