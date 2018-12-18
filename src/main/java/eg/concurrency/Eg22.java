package eg.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/12/3.
 */

class Flag {
    private boolean value = false;
    public synchronized void waitFor() throws InterruptedException {
        while (!value) {
            wait();
        }
    }
    public synchronized void set() {
        value = true;
        notifyAll();
    }

    public synchronized void setFalse() {
        value = false;
        notifyAll();
    }
}

class Task3 implements Runnable {
    Flag flag;
    public Task3(Flag flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            flag.set();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//class Task4 implements Runnable {
//    Task3 task3;
//    long start, end;
//    Task4(Task3 task3) {
//        this.task3 = task3;
//    }
//    @Override
//    public void run() {
//        start = System.currentTimeMillis();
//        while (!Thread.interrupted()) {
//            if (task3.flag) {
//                System.out.println("flag is true");
//                task3.flag = false;
//                end = System.currentTimeMillis();
//                System.out.println("wait:" + (end - start));
//                start = end;
//            }
//        }
//    }
//}

class Task5 implements Runnable {
    private Flag flag;
    public Task5(Flag flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                flag.waitFor();
                System.out.println("flag is true");
                flag.setFalse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Eg22 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Flag flag = new Flag();
        exec.execute(new Task3(flag));
        exec.execute(new Task5(flag));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();
    }
}
