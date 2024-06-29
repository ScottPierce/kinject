package kinject.benchmark

class A

class B(val a: A)

class C(val a: A, val b: B)

class D(val a: A, val b: B, val c: C)

class E(val d: D)

class F(val e: E)

class G(val f: F, val b: B)

class H(val g: G, val c: C)

class I(val h: H, val d: D)

class J(val i: I, val e: E)

class K(val j: J, val f: F)

class L(val k: K, val g: G)

class M(val l: L, val h: H)

class N(val m: M, val i: I)

class O(val n: N, val j: J)

class P(val o: O, val k: K)

class Q(val p: P, val l: L)

class R(val q: Q, val m: M)

class S(val r: R, val n: N)

class T(val s: S, val o: O)

class U(val t: T, val p: P)

class V(val u: U, val q: Q)

class W(val v: V, val r: R)

class X(val w: W, val s: S)

class Y(val x: X, val t: T)

class Z(val y: Y, val u: U)

class AA(val z: Z, val v: V)

class BB(val aa: AA, val w: W)

class CC(val bb: BB, val x: X)

class DD(val cc: CC, val y: Y)

class EE(val dd: DD, val z: Z)

class FF(val ee: EE, val aa: AA)

class GG(val ff: FF, val bb: BB)

class HH(val gg: GG, val cc: CC)

class II(val hh: HH, val dd: DD)

class JJ(val ii: II, val ee: EE)

class KK(val jj: JJ, val ff: FF)

class LL(val kk: KK, val gg: GG)

class MM(val ll: LL, val hh: HH)

class NN(val mm: MM, val ii: II)

class OO(val nn: NN, val jj: JJ)

class PP(val oo: OO, val kk: KK)

class QQ(val pp: PP, val ll: LL)

class RR(val qq: QQ, val mm: MM)

class SS(val rr: RR, val nn: NN)

class TT(val ss: SS, val oo: OO)

class UU(val tt: TT, val pp: PP)

class VV(val uu: UU, val qq: QQ)

class WW(val vv: VV, val rr: RR)

class XX(val ww: WW, val ss: SS)

class YY(val xx: XX, val tt: TT)

class ZZ(val yy: YY, val uu: UU)

class AAA(val zz: ZZ, val vv: VV)

class BBB(val aaa: AAA, val ww: WW)

class CCC(val bbb: BBB, val xx: XX)

class DDD(val ccc: CCC, val yy: YY)

class EEE(val ddd: DDD, val zz: ZZ)

class FFF(val eee: EEE, val aaa: AAA)

class GGG(val fff: FFF, val bbb: BBB)

class HHH(val ggg: GGG, val ccc: CCC)

class III(val hhh: HHH, val ddd: DDD)

class JJJ(val iii: III, val eee: EEE)

class KKK(val jjj: JJJ, val fff: FFF)

class LLL(val kkk: KKK, val ggg: GGG)

class MMM(val lll: LLL, val hhh: HHH)

class NNN(val mmm: MMM, val iii: III)

class OOO(val nnn: NNN, val jjj: JJJ)

class PPP(val ooo: OOO, val kkk: KKK)

class QQQ(val ppp: PPP, val lll: LLL)

class RRR(val qqq: QQQ, val mmm: MMM)

class SSS(val rrr: RRR, val nnn: NNN)

class TTT(val sss: SSS, val ooo: OOO)

class UUU(val ttt: TTT, val ppp: PPP)

class VVV(val uuu: UUU, val qqq: QQQ)

class WWW(val vvv: VVV, val rrr: RRR)

class XXX(val www: WWW, val sss: SSS)

class YYY(val xxx: XXX, val ttt: TTT)

class ZZZ(val yyy: YYY, val uuu: UUU)

class AAAA(val zzz: ZZZ, val vvv: VVV)

class BBBB(val aaaa: AAAA, val www: WWW)

class CCCC(val bbbb: BBBB, val xxx: XXX)

class DDDD(val cccc: CCCC, val yyy: YYY)

class EEEE(val dddd: DDDD, val zzz: ZZZ)

class FFFF(val eeee: EEEE, val aaaa: AAAA)

class GGGG(val ffff: FFFF, val bbbb: BBBB)

class HHHH(val gggg: GGGG, val cccc: CCCC)

class IIII(val hhhh: HHHH, val dddd: DDDD)

class JJJJ(val iiii: IIII, val eeee: EEEE)

class KKKK(val jjjj: JJJJ, val ffff: FFFF)

class LLLL(val kkkk: KKKK, val gggg: GGGG)

class MMMM(val llll: LLLL, val hhhh: HHHH)

class NNNN(val mmmm: MMMM, val iiii: IIII)

class OOOO(val nnnn: NNNN, val jjjj: JJJJ)

class PPPP(val oooo: OOOO, val kkkk: KKKK)

class QQQQ(val pppp: PPPP, val llll: LLLL)

class RRRR(val qqqq: QQQQ, val mmmm: MMMM)

class SSSS(val rrrr: RRRR, val nnnn: NNNN)

class TTTT(val ssss: SSSS, val oooo: OOOO)

class UUUU(val tttt: TTTT, val pppp: PPPP)

class VVVV(val uuuu: UUUU, val qqqq: QQQQ)

class WWWW(val vvvv: VVVV, val rrrr: RRRR)

class XXXX(val wwww: WWWW, val ssss: SSSS)

class YYYY(val xxxx: XXXX, val tttt: TTTT)

class ZZZZ(val yyyy: YYYY, val uuuu: UUUU)

class AllDependencies(
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
)
