package generics;

/**
 * Created by jiguang on 2018/6/11.
 */

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() {
        return id;
    }
    public String toString() {
        return "CountedObject " + id;
    }
}
