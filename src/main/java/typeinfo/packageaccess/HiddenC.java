package typeinfo.packageaccess;

import typeinfo.interfacea.A;

/**
 * Created by jiguang on 2018/5/31.
 */

public class HiddenC {
    public static A makeA() {
        return new C();
    }
}

class C implements A {
    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("C.g()");
    }

    void u(int a) {
        System.out.println("package C.u()");
        System.out.println("a:" + a);
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}
