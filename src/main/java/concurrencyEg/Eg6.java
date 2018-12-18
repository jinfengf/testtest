package concurrencyEg;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/9/14.
 */

public class Eg6 {
    static class RandomSleepingTask implements Runnable {
        @Override
        public void run() {
            try {
                Random random = new Random();
                int rand = 1 + random.nextInt(9);
                TimeUnit.SECONDS.sleep(rand);
                System.out.println("thread:" + Thread.currentThread().getName() + "sleeping time:" + rand + "seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; ++i) {
            exec.execute(new RandomSleepingTask());
        }
        exec.shutdown();
    }
}
