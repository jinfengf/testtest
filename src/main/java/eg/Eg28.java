package eg;

/**
 * Created by jiguang on 2018/8/22.
 */

public class Eg28<T> {
    static class Generic1<T> {
        T t;
        void add(T t) {
            this.t = t;
        }
    }

    static class Generic2<T> {
        T t;
        T get() {
            return t;
        }
    }

    void add(Generic1<? super T> glt, T t) {
        glt.add(t);
    }

    T get(Generic2<? extends T> glt) {
        return glt.get();
    }

    static class Pet {

    }

    static class Cat extends Pet {

    }

    public static void main(String[] args) {
        Eg28<Pet> eg28 = new Eg28<Pet>();
        eg28.add(new Generic1<Pet>(), new Cat());
        eg28.get(new Generic2<Cat>());
    }
}
