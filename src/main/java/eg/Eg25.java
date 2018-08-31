package eg;

/**
 * Created by jiguang on 2018/8/15.
 */

interface Eat {
    void eat();
}

interface Sleep {
    void sleep();
}

class Hum implements Eat, Sleep {
    @Override
    public void eat() {
        System.out.println("hum eat");
    }

    @Override
    public void sleep() {
        System.out.println("hum sleep");
    }
}

public class Eg25 {
    static <T extends Eat> void eat(T t) {
        t.eat();
    }

    static <T extends Sleep> void sleep(T t) {
        t.sleep();
    }

    public static void main(String[] args) {
        Hum hum = new Hum();
        eat(hum);
        sleep(hum);
    }
}
