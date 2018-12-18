package generics;

/**
 * Created by jiguang on 2018/7/23.
 */

public class ErasureAndInheritance {
    public static void main(String[] args) {
//        Derived2 d2 = new Derived2();
//        Object obj = d2.get();
//        d2.set(obj);
        Derived1<String> d1 = new Derived1<>();
        String s = d1.get();
        d1.set(s);
    }
}

class GenericBase<T> {
    private T element;
    public void set(T arg) {
        arg = element;
    }
    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {

}

class Derived2 extends GenericBase {

}

