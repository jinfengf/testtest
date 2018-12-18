package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/9/14.
 */

public class CachedThreadPool {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; i++) {
            Future<?> f = exec.submit(new LiftOff());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cancel");
            System.out.println(f.cancel(true));
        }
        exec.shutdown();
        System.out.println("aaaaa");
    }
}
