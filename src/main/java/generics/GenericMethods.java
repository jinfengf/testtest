package generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiguang on 2018/6/8.
 */

public class GenericMethods {
    public <T,M> void f(T x, String y, M z) {
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("","", 2.0);
        Map<String, ? extends GenericMethods> a = new HashMap<>();
    }
}
