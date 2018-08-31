package net.mindview.util;

/**
 * Created by jiguang on 2018/6/6.
 */

public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;
    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }
    public String toString() {
        return "(" + first + ", " + second + ", " + thrid + ", " + fourth + ", " + fifth + ")";
    }
}
