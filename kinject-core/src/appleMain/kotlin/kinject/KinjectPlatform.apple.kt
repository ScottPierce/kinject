@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package kinject

import platform.objc.objc_sync_enter
import platform.objc.objc_sync_exit
import kotlin.reflect.KClass

internal actual object KinjectPlatform {
    actual val KClass<*>.className: String
        get() = this.qualifiedName ?: error("No qualified name found for '$this'")

    actual inline fun <R> synchronized(lock: Any, func: () -> R): R {
        objc_sync_enter(lock)
        try {
            return func()
        } finally {
            objc_sync_exit(lock)
        }
    }
}
