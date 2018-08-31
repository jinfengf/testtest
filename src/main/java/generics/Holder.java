package generics;

/**
 * Created by jiguang on 2018/8/20.
 */

public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T var) {
        value = var;
    }
    public void set(T var) {
        value = var;
    }
    public T get() {
        return value;
    }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple d = appleHolder.get();
        appleHolder.set(d);
//        Holder<Fruit> fruitHolder = appleHolder;
        Holder<? extends Fruit> fruitHolder = appleHolder;
        Fruit p = fruitHolder.get();
        d = (Apple) fruitHolder.get();
        try {
            Orange c = (Orange) fruitHolder.get();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(fruitHolder.equals(d));
    }
}
