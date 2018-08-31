package generics;

/**
 * Created by jiguang on 2018/6/6.
 */

public class Holder3<T> {
    private T a;
    public Holder3(T a) {
        this.a = a;
    }
    public void set(T a) {
        this.a = a;
    }
    public T get() {
        return a;
    }
    public static void main(String[] args) {
    }
}

class A {

}

class B extends A {

}
