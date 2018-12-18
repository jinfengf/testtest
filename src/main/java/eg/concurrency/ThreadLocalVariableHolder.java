package eg.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/11/5.
 */

class Accessor implements Runnable {
    private final int id;
    public Accessor(int idn) {
        id = idn;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(this);
            ThreadLocalVariableHolder.increment();
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };
    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}

