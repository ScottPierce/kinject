package kinject

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

class ObjectGraphTest {
    @Test
    fun objectGraph_conflictingSingletonBinding_ErrorCreatingGraph() {
        assertFailsWith<KinjectException> {
            objectGraph {
                singleton(A())
                singleton(A())
            }
        }
    }

    @Test
    fun objectGraph_conflictingSingletonLazyBinding_ErrorCreatingGraph() {
        assertFailsWith<KinjectException> {
            objectGraph {
                singleton { A() }
                singleton { A() }
            }
        }
    }

    @Test
    fun objectGraph_conflictingBindingAcrossGraphs_ErrorCreatingGraph() {
        val graph1 = objectGraph {
            singleton { A() }
        }

        assertFailsWith<KinjectException> {
            objectGraph {
                singleton(A())
                add(graph1)
            }
        }
    }

    @Test
    fun objectGraph_sharedDependencyInstance_SameInstance() {
        val graph1 = objectGraph {
            singleton { A() }
        }

        val a: A = graph1.get()

        val graph2 = objectGraph {
            singleton { B(get()) }
            add(graph1)
        }

        val b: B = graph2.get()

        assertSame(a, b.a)
    }

    @Test
    fun objectGraph_addGraphToGraph_SameBindings() {
        val g1 = objectGraph {
            singleton(A())
            singleton { B(a = get()) }
        }

        val g2 = objectGraph {
            singleton { C(a = get(), b = get()) }

            add(g1)
        }

        val a: A = g2.get()
        val b: B = g2.get()
        val c: C = g2.get()

        assertSame(b.a, a)
        assertSame(c.a, a)
        assertSame(c.b, b)
    }

    @Test
    fun objectGraph_cyclicalDependencies_ErrorResolvingDependency() {
        val graph = objectGraph {
            singleton { CyclicalA(get()) }
            singleton { CyclicalB(get()) }
        }

        assertFailsWith<KinjectException> {
            graph.get<CyclicalA>()
        }
    }

    @Test
    fun objectGraph_singletonInstanceInheritance_AbleToViewAsParent() {
        val aa = AA()

        val graph = objectGraph {
            singleton<A>(aa)
        }

        val a: A = graph.get()
        assertSame(aa, a)

        assertFailsWith<KinjectException> {
            graph.get<AA>()
        }
    }
}

open class A

class AA : A()

class B(val a: A)

class C(
    val a: A,
    val b: B,
)

class CyclicalA(val b: CyclicalB)

class CyclicalB(val a: CyclicalA)
