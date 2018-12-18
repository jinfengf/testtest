package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jiguang on 2018/10/24.
 */

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
