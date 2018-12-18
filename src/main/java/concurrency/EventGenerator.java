package concurrency;

/**
 * Created by jiguang on 2018/10/19.
 */

public class EventGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EventGenerator());
    }
}
