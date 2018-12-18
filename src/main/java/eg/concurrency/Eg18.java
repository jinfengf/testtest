package eg.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/11/25.
 */

class NoTask {
    public static void test() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        } finally {
            System.out.println("Good bye");
        }
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        NoTask.test();
    }
}

public class Eg18 {
    public static void main(String[] args) throws Exception {
        // use thread
        Thread thread = new Thread(new Worker());
        thread.start();
        thread.interrupt();
        // use Executor execute
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new Worker());
        exec.shutdownNow();
        // use submit
        ExecutorService exec2 = Executors.newSingleThreadExecutor();
        Future<?> f = exec2.submit(new Worker());
        exec2.shutdown();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(f.cancel(true));
    }
}
