package kinject.benchmark

class A()
class B(val a: A)
class C(val a: A, val b: B)
class D(val a: A, val b: B, val c: C)
class E(val d: D)
