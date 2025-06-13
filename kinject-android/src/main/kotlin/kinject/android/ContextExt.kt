package kinject.android

import android.annotation.SuppressLint
import android.content.Context
import kinject.HasObjectGraph
import kinject.ObjectGraph

@SuppressLint("WrongConstant")
fun Context.objectGraphOrNull(): ObjectGraph? {
    return if (this is HasObjectGraph) {
        objectGraph
    } else {
        getSystemService(KinjectApplication.KINJECT_SERVICE) as ObjectGraph?
    }
}

fun Context.objectGraph(): ObjectGraph {
    return objectGraphOrNull() ?: error("ObjectGraph not found in Context.")
}
