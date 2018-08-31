package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by jiguang on 2018/7/23.
 */

public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[])Array.newInstance(A.class, size);
    }
    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
//        A[] a = stringMaker.create(9);
    }
}
