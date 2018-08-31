package typeinfo;

import java.lang.reflect.Method;

import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

/**
 * Created by jiguang on 2018/5/31.
 */

public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
        Method m = a.getClass().getDeclaredMethod("u", int.class);
        m.setAccessible(true);
        m.invoke(a, 967);
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
