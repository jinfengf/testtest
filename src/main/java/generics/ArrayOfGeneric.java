package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiguang on 2018/8/10.
 */

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        // gia = (Generic<Integer>[])new Object[SIZE];
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        Object[] objects = gia;
        objects[0] = "aaaaa";

    }

    static void f(long a) {

    }
}
