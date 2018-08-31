package generics;

/**
 * Created by jiguang on 2018/8/31.
 */

public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A1 a = f(new A1());
    }
}
