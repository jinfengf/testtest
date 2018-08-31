package generics;

/**
 * Created by jiguang on 2018/8/31.
 */

class GenericSetter<T> {
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
    }
}
