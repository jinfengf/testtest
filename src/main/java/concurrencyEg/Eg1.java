package concurrencyEg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiguang on 2018/9/14.
 */

public class Eg1 {

    static class A implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + ":task finished");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; ++ i) {
            exec.execute(new A());
        }
        exec.shutdown();
    }
}
