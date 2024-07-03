package kinject.android

import android.content.Context
import kinject.ObjectGraph

fun Context.objectGraphOrNull(): ObjectGraph? {
    return getSystemService(KinjectApplication.KINJECT_SERVICE) as ObjectGraph?
}

fun Context.objectGraph(): ObjectGraph {
    return objectGraphOrNull() ?: error("ObjectGraph not found in Context.")
}
