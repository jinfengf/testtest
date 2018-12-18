package eg.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/12/3.
 */

class Task1 implements Runnable {
    private boolean signal = false;
    @Override
    public synchronized void run() {
        try {
            while (!signal) {
                wait();
                System.out.println("task1 finished");
                signal = true;
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
    }
}

class Task2 implements Runnable {
    private Task1 task1;
    Task2(Task1 task1) {
        this.task1 = task1;
    }
    @Override
    public void run() {
        synchronized (task1) {
            try {
                TimeUnit.SECONDS.sleep(2);
                task1.notifyAll();
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
        }
    }
}

public class Eg21 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Task1 task1 = new Task1();
        exec.execute(task1);
        exec.execute(new Task2(task1));
        exec.shutdown();
    }
}
