package concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/11/12.
 */

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("sleep start");
            System.out.println(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(10);
            System.out.println("sleep over");
        } catch (InterruptedException e) {
            System.out.println(System.currentTimeMillis());
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked(InputStream is) {
        in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        System.out.println("f():" + Thread.currentThread().getName());
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                System.out.println("aaaaaaaaaaaaaaa:" + Thread.currentThread().getName());
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f():" + Thread.currentThread().getName());
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}