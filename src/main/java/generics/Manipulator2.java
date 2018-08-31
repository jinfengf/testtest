package generics;

/**
 * Created by jiguang on 2018/7/23.
 */

public class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}
