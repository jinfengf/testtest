package eg;

/**
 * Created by jiguang on 2018/7/23.
 */

public class Eg20 {
    public static <T extends aaa> void f(T x) {
        x.f1();
        x.f2();
    }

    public static void main(String[] args) {
        f(new A());
    }
}

interface aaa {
    void f1();
    void f2();
}

class A implements aaa {
    @Override
    public void f1() {
        System.out.println("f1()");
    }

    @Override
    public void f2() {
        System.out.println("f2()");
    }

    public void f3() {
        System.out.println("f3()");
    }
}
