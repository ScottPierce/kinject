package kinject.android

import androidx.appcompat.app.AppCompatActivity
import kinject.HasObjectGraph
import kinject.ObjectGraph
import kinject.android.KinjectApplication.Companion.KINJECT_SERVICE

abstract class KinjectAppCompatActivity : AppCompatActivity(), HasObjectGraph {
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
