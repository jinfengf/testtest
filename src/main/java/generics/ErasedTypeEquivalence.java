package generics;

import java.util.ArrayList;

/**
 * Created by jiguang on 2018/7/16.
 */

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
