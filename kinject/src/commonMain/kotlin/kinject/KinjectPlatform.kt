@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package kinject

import kotlin.reflect.KClass

internal expect object KinjectPlatform {
    val KClass<*>.className: String

    inline fun <R> synchronized(lock: Any, func: () -> R): R
}
