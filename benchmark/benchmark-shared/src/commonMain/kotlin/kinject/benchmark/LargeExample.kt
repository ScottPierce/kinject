package kinject.benchmark

import kinject.ObjectGraph
import kinject.objectGraph
import org.koin.core.Koin
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class LargeExample(
    val a: A,
    val b: B,
    val c: C,
    val d: D,
    val e: E,
    val f: F,
    val g: G,
    val h: H,
    val i: I,
    val j: J,
    val k: K,
    val l: L,
    val m: M,
    val n: N,
    val o: O,
    val p: P,
    val q: Q,
    val r: R,
    val s: S,
    val t: T,
    val u: U,
    val v: V,
    val w: W,
    val x: X,
    val y: Y,
    val z: Z,
    val aa: AA,
    val bb: BB,
    val cc: CC,
    val dd: DD,
    val ee: EE,
    val ff: FF,
    val gg: GG,
    val hh: HH,
    val ii: II,
    val jj: JJ,
    val kk: KK,
    val ll: LL,
    val mm: MM,
    val nn: NN,
    val oo: OO,
    val pp: PP,
    val qq: QQ,
    val rr: RR,
    val ss: SS,
    val tt: TT,
    val uu: UU,
    val vv: VV,
    val ww: WW,
    val xx: XX,
    val yy: YY,
    val zz: ZZ,
    val aaa: AAA,
    val bbb: BBB,
    val ccc: CCC,
    val ddd: DDD,
    val eee: EEE,
    val fff: FFF,
    val ggg: GGG,
    val hhh: HHH,
    val iii: III,
    val jjj: JJJ,
    val kkk: KKK,
    val lll: LLL,
    val mmm: MMM,
    val nnn: NNN,
    val ooo: OOO,
    val ppp: PPP,
    val qqq: QQQ,
    val rrr: RRR,
    val sss: SSS,
    val ttt: TTT,
    val uuu: UUU,
    val vvv: VVV,
    val www: WWW,
    val xxx: XXX,
    val yyy: YYY,
    val zzz: ZZZ,
    val aaaa: AAAA,
    val bbbb: BBBB,
    val cccc: CCCC,
    val dddd: DDDD,
    val eeee: EEEE,
    val ffff: FFFF,
    val gggg: GGGG,
    val hhhh: HHHH,
    val iiii: IIII,
    val jjjj: JJJJ,
    val kkkk: KKKK,
    val llll: LLLL,
    val mmmm: MMMM,
    val nnnn: NNNN,
    val oooo: OOOO,
    val pppp: PPPP,
    val qqqq: QQQQ,
    val rrrr: RRRR,
    val ssss: SSSS,
    val tttt: TTTT,
    val uuuu: UUUU,
    val vvvv: VVVV,
    val wwww: WWWW,
    val xxxx: XXXX,
    val yyyy: YYYY,
    val zzzz: ZZZZ,
    val allDependencies: AllDependencies,
) {
    companion object {
        fun createKinject(): ObjectGraph {
            return objectGraph {
                singleton { A() }
                singleton { B(get()) }
                singleton { C(get(), get()) }
                singleton { D(get(), get(), get()) }
                singleton { E(get()) }
                singleton { F(get()) }
                singleton { G(get(), get()) }
                singleton { H(get(), get()) }
                singleton { I(get(), get()) }
                singleton { J(get(), get()) }
                singleton { K(get(), get()) }
                singleton { L(get(), get()) }
                singleton { M(get(), get()) }
                singleton { N(get(), get()) }
                singleton { O(get(), get()) }
                singleton { P(get(), get()) }
                singleton { Q(get(), get()) }
                singleton { R(get(), get()) }
                singleton { S(get(), get()) }
                singleton { T(get(), get()) }
                singleton { U(get(), get()) }
                singleton { V(get(), get()) }
                singleton { W(get(), get()) }
                singleton { X(get(), get()) }
                singleton { Y(get(), get()) }
                singleton { Z(get(), get()) }
                singleton { AA(get(), get()) }
                singleton { BB(get(), get()) }
                singleton { CC(get(), get()) }
                singleton { DD(get(), get()) }
                singleton { EE(get(), get()) }
                singleton { FF(get(), get()) }
                singleton { GG(get(), get()) }
                singleton { HH(get(), get()) }
                singleton { II(get(), get()) }
                singleton { JJ(get(), get()) }
                singleton { KK(get(), get()) }
                singleton { LL(get(), get()) }
                singleton { MM(get(), get()) }
                singleton { NN(get(), get()) }
                singleton { OO(get(), get()) }
                singleton { PP(get(), get()) }
                singleton { QQ(get(), get()) }
                singleton { RR(get(), get()) }
                singleton { SS(get(), get()) }
                singleton { TT(get(), get()) }
                singleton { UU(get(), get()) }
                singleton { VV(get(), get()) }
                singleton { WW(get(), get()) }
                singleton { XX(get(), get()) }
                singleton { YY(get(), get()) }
                singleton { ZZ(get(), get()) }
                singleton { AAA(get(), get()) }
                singleton { BBB(get(), get()) }
                singleton { CCC(get(), get()) }
                singleton { DDD(get(), get()) }
                singleton { EEE(get(), get()) }
                singleton { FFF(get(), get()) }
                singleton { GGG(get(), get()) }
                singleton { HHH(get(), get()) }
                singleton { III(get(), get()) }
                singleton { JJJ(get(), get()) }
                singleton { KKK(get(), get()) }
                singleton { LLL(get(), get()) }
                singleton { MMM(get(), get()) }
                singleton { NNN(get(), get()) }
                singleton { OOO(get(), get()) }
                singleton { PPP(get(), get()) }
                singleton { QQQ(get(), get()) }
                singleton { RRR(get(), get()) }
                singleton { SSS(get(), get()) }
                singleton { TTT(get(), get()) }
                singleton { UUU(get(), get()) }
                singleton { VVV(get(), get()) }
                singleton { WWW(get(), get()) }
                singleton { XXX(get(), get()) }
                singleton { YYY(get(), get()) }
                singleton { ZZZ(get(), get()) }
                singleton { AAAA(get(), get()) }
                singleton { BBBB(get(), get()) }
                singleton { CCCC(get(), get()) }
                singleton { DDDD(get(), get()) }
                singleton { EEEE(get(), get()) }
                singleton { FFFF(get(), get()) }
                singleton { GGGG(get(), get()) }
                singleton { HHHH(get(), get()) }
                singleton { IIII(get(), get()) }
                singleton { JJJJ(get(), get()) }
                singleton { KKKK(get(), get()) }
                singleton { LLLL(get(), get()) }
                singleton { MMMM(get(), get()) }
                singleton { NNNN(get(), get()) }
                singleton { OOOO(get(), get()) }
                singleton { PPPP(get(), get()) }
                singleton { QQQQ(get(), get()) }
                singleton { RRRR(get(), get()) }
                singleton { SSSS(get(), get()) }
                singleton { TTTT(get(), get()) }
                singleton { UUUU(get(), get()) }
                singleton { VVVV(get(), get()) }
                singleton { WWWW(get(), get()) }
                singleton { XXXX(get(), get()) }
                singleton { YYYY(get(), get()) }
                singleton { ZZZZ(get(), get()) }
                singleton {
                    AllDependencies(
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(),
                    )
                }

                singleton {
                    LargeExample(
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                        get(), get(), get(), get(), get(), get(), get(), get(), get(),
                    )
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
                        single { F(get()) }
                        single { G(get(), get()) }
                        single { H(get(), get()) }
                        single { I(get(), get()) }
                        single { J(get(), get()) }
                        single { K(get(), get()) }
                        single { L(get(), get()) }
                        single { M(get(), get()) }
                        single { N(get(), get()) }
                        single { O(get(), get()) }
                        single { P(get(), get()) }
                        single { Q(get(), get()) }
                        single { R(get(), get()) }
                        single { S(get(), get()) }
                        single { T(get(), get()) }
                        single { U(get(), get()) }
                        single { V(get(), get()) }
                        single { W(get(), get()) }
                        single { X(get(), get()) }
                        single { Y(get(), get()) }
                        single { Z(get(), get()) }
                        single { AA(get(), get()) }
                        single { BB(get(), get()) }
                        single { CC(get(), get()) }
                        single { DD(get(), get()) }
                        single { EE(get(), get()) }
                        single { FF(get(), get()) }
                        single { GG(get(), get()) }
                        single { HH(get(), get()) }
                        single { II(get(), get()) }
                        single { JJ(get(), get()) }
                        single { KK(get(), get()) }
                        single { LL(get(), get()) }
                        single { MM(get(), get()) }
                        single { NN(get(), get()) }
                        single { OO(get(), get()) }
                        single { PP(get(), get()) }
                        single { QQ(get(), get()) }
                        single { RR(get(), get()) }
                        single { SS(get(), get()) }
                        single { TT(get(), get()) }
                        single { UU(get(), get()) }
                        single { VV(get(), get()) }
                        single { WW(get(), get()) }
                        single { XX(get(), get()) }
                        single { YY(get(), get()) }
                        single { ZZ(get(), get()) }
                        single { AAA(get(), get()) }
                        single { BBB(get(), get()) }
                        single { CCC(get(), get()) }
                        single { DDD(get(), get()) }
                        single { EEE(get(), get()) }
                        single { FFF(get(), get()) }
                        single { GGG(get(), get()) }
                        single { HHH(get(), get()) }
                        single { III(get(), get()) }
                        single { JJJ(get(), get()) }
                        single { KKK(get(), get()) }
                        single { LLL(get(), get()) }
                        single { MMM(get(), get()) }
                        single { NNN(get(), get()) }
                        single { OOO(get(), get()) }
                        single { PPP(get(), get()) }
                        single { QQQ(get(), get()) }
                        single { RRR(get(), get()) }
                        single { SSS(get(), get()) }
                        single { TTT(get(), get()) }
                        single { UUU(get(), get()) }
                        single { VVV(get(), get()) }
                        single { WWW(get(), get()) }
                        single { XXX(get(), get()) }
                        single { YYY(get(), get()) }
                        single { ZZZ(get(), get()) }
                        single { AAAA(get(), get()) }
                        single { BBBB(get(), get()) }
                        single { CCCC(get(), get()) }
                        single { DDDD(get(), get()) }
                        single { EEEE(get(), get()) }
                        single { FFFF(get(), get()) }
                        single { GGGG(get(), get()) }
                        single { HHHH(get(), get()) }
                        single { IIII(get(), get()) }
                        single { JJJJ(get(), get()) }
                        single { KKKK(get(), get()) }
                        single { LLLL(get(), get()) }
                        single { MMMM(get(), get()) }
                        single { NNNN(get(), get()) }
                        single { OOOO(get(), get()) }
                        single { PPPP(get(), get()) }
                        single { QQQQ(get(), get()) }
                        single { RRRR(get(), get()) }
                        single { SSSS(get(), get()) }
                        single { TTTT(get(), get()) }
                        single { UUUU(get(), get()) }
                        single { VVVV(get(), get()) }
                        single { WWWW(get(), get()) }
                        single { XXXX(get(), get()) }
                        single { YYYY(get(), get()) }
                        single { ZZZZ(get(), get()) }
                        single {
                            AllDependencies(
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(),
                            )
                        }

                        single {
                            LargeExample(
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
                                get(), get(), get(), get(), get(), get(), get(), get(), get(),
                            )
                        }
                    }
                )
            }
            return koinApp.koin
        }
    }
}

