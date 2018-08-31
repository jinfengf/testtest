package generics;

/**
 * Created by jiguang on 2018/7/23.
 */

public class Manipulator3 {
    private HasF obj;
    public Manipulator3(HasF x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}
