package kinject.benchmark

import kinject.ObjectGraph
import kinject.objectGraph
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class SmallExample(
    val a: A,
    val b: B,
    val c: C,
    val d: D,
    val e: E,
) {
    companion object {
        fun createKinject(): ObjectGraph {
            return objectGraph {
                singleton { A() }
                singleton { B(get()) }
                singleton { C(get(), get()) }
                singleton { D(get(), get(), get()) }
                singleton { E(get()) }

                singleton {
                    SmallExample(get(), get(), get(), get(), get())
                }
            }
        }

        fun createKoin(): Koin {
            val koinApp = koinApplication {
                modules(
                    module {
                        single { A() }
                        single { B(get()) }
                        single { C(get(), get()) }
                        single { D(get(), get(), get()) }
                        single { E(get()) }
                        single { SmallExample(get(), get(), get(), get(), get()) }
                    }
                )
            }
            return koinApp.koin
        }
    }
}
