package eg;

import generics.Holder;

/**
 * Created by jiguang on 2018/8/30.
 */

public class Eg30 {

    public static void main(String[] args) {
        Holder<Integer> integerHolder = new Holder<>();
        Holder<Double> doubleHolder = new Holder<>();
        Holder<Boolean> booleanHolder = new Holder<>();
        integerHolder.set(1);
        int a = integerHolder.get();
        doubleHolder.set(1.2);
        double d = doubleHolder.get();
        booleanHolder.set(true);
        boolean b = booleanHolder.get();
    }
}
