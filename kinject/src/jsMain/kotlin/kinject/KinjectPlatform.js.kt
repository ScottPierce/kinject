@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package kinject

import kotlin.reflect.KClass

internal actual object KinjectPlatform {
    actual val KClass<*>.className: String
        get() = this.js.name
    actual inline fun <R> synchronized(lock: Any, func: () -> R): R = func()
}
