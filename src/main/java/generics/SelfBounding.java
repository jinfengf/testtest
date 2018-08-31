package generics;

/**
 * Created by jiguang on 2018/8/31.
 */

class SelfBounded<T extends SelfBounded<T>> {
    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() {
        return element;
    }
}

class A1 extends SelfBounded<A1> {
}

class B1 extends SelfBounded<A1> {
}

class C1 extends SelfBounded<C1> {
    C1 setAndGet(C1 arg) {
        set(arg);
        return get();
    }
}

class D1 {}

//class E1 extends SelfBounded<D1> {}

class F1 extends SelfBounded {

}

public class SelfBounding {
    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.set(new A1());
        a1 = a1.set(new A1()).get();
        a1 = a1.get();
        C1 c1 = new C1();
        c1 = c1.setAndGet(new C1());
    }
}
