package concurrency;

/**
 * Created by jiguang on 2018/10/22.
 */

public class SynchroizedEvenGenerator extends IntGenerator {
    private int currentEvenValue;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchroizedEvenGenerator());
    }
}
