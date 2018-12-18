package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/9/19.
 */

class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting Adaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.start();
    }
}