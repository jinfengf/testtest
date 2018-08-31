package net.mindview.util;

/**
 * Created by jiguang on 2018/6/6.
 */

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C thrid;
    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        thrid = c;
    }
    public String toString() {
        return "(" + first + ", " + second + ", " + thrid + ")";
    }
}
