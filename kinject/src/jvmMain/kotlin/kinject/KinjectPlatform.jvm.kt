@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package kinject

import kotlin.reflect.KClass

internal actual object KinjectPlatform {
    actual val KClass<*>.bindingId: String
        get() = this.java.name

    actual inline fun <R> synchronized(lock: Any, func: () -> R): R {
        return kotlin.synchronized(lock, func)
    }
}
