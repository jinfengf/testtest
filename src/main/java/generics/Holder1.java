package generics;

/**
 * Created by jiguang on 2018/6/6.
 */

public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) {
        this.a = a;
    }
    Automobile get() {
        return a;
    }
    public static void main(String[] args) {
        System.out.println("");
    }
}

class Automobile {}
