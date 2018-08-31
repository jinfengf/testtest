package coffee;

/**
 * Created by jiguang on 2018/6/7.
 */

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

