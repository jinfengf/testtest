package eg;

/**
 * Created by jiguang on 2018/9/3.
 */

abstract class Eg34Generic<T extends Eg34Generic<T>> {
    abstract T f(T t);
    T g(T t) {
        return f(t);
    }
}

public class Eg34 extends Eg34Generic<Eg34> {
    @Override
    Eg34 f(Eg34 eg34) {
        return null;
    }

    public static void main(String[] args) {
        Eg34 eg34 = new Eg34();
        eg34.f(eg34).g(eg34);
    }
}
