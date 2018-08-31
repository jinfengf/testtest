package generics;

/**
 * Created by jiguang on 2018/7/23.
 */

public class ReturnGenericType<T extends HasF> {
    private T obj;
    public ReturnGenericType(T x) {
        obj = x;
    }
    public T get() {
        return obj;
    }
}
