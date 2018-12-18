package eg.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiguang on 2018/10/22.
 */

public class Eg11 {
    private boolean canceled = false;
    public static void main(String[] args) {
        NumberGeneratorTest.test(new NumberGenerator11());
    }

}

abstract class NumberGenerator {
    private volatile boolean canceled = false;
    abstract int[] next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}

class NumberGeneratorTest implements Runnable {
    private NumberGenerator numberGenerator;

    private final int id;
    NumberGeneratorTest(int id, NumberGenerator numberGenerator) {
        this.id = id;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void run() {
        while (!numberGenerator.isCanceled()) {
            int[] range = numberGenerator.next();
            if (range[0] > range[1]) {
                System.out.println("Error int test #" + id + ": min" + range[0] + ">" + "max " + range[1]);
                numberGenerator.cancel();
            }
        }
    }

    public static void test(NumberGenerator generator, int count) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new NumberGeneratorTest(count, generator));
        }
        exec.shutdown();
    }

    public static void test(NumberGenerator generator) {
        test(generator, 10);
    }
}

class NumberGenerator11 extends NumberGenerator {
    private int minInt;
    private int maxInt;

    private Random random = new Random();
    @Override
    synchronized int[] next() {
        minInt = random.nextInt(100);
        maxInt = random.nextInt(100);
        Thread.yield();
        if (minInt > maxInt) {
            maxInt = minInt;
        }
        return new int[] {minInt, maxInt};
    }
}
