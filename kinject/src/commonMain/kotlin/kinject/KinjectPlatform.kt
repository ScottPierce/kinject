@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package kinject

internal expect object KinjectPlatform {
    inline fun <R> synchronized(lock: Any, func: () -> R): R
}
