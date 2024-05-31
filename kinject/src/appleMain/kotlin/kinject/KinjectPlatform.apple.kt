@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package kinject

import platform.objc.objc_sync_enter
import platform.objc.objc_sync_exit

internal actual object KinjectPlatform {
    actual inline fun <R> synchronized(lock: Any, func: () -> R): R {
        objc_sync_enter(lock)
        try {
            return func()
        } finally {
            objc_sync_exit(lock)
        }
    }
}
