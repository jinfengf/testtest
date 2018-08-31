package generics;

/**
 * Created by jiguang on 2018/7/23.
 */

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}

class Manipulator<T> {
    private T obj;
    public Manipulator(T x) {
        obj = x;
    }
    public void manipulate() {
//        obj.f();
    }
}
