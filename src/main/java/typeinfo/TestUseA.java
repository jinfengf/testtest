package typeinfo;

import java.lang.reflect.Method;

import typeinfo.eg25.A;

/**
 * Created by jiguang on 2018/6/6.
 */

public class TestUseA {
    public static void main(String[] args) {
        try {
            Class a = Class.forName("typeinfo.eg25.A");
//            System.out.println(a.getName());
//            System.out.println(a.getSimpleName());
//            System.out.println(a.getCanonicalName());
//            for (Method method : a.getDeclaredMethods()) {
//                System.out.println(method);
//                method.setAccessible(true);
//                method.invoke(a.newInstance());
//            }
            Method method = a.getDeclaredMethod("m");
            method.setAccessible(true);
            method.invoke(new Object());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class B1 extends A {

}
