@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package kinject

internal actual object KinjectPlatform {
    actual inline fun <R> synchronized(lock: Any, func: () -> R): R = func()
}
