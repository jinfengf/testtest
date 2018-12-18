package eg.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiguang on 2018/11/3.
 */

class SyncTest1 {
    public void f() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f1()");
                Thread.yield();
            }
        }
    }

    public void g() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g1()");
                Thread.yield();
            }
        }
    }

    public void h() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("h1()");
                Thread.yield();
            }
        }
    }
}

class SyncTest2 {
    Object[] objects =  {new Object(), new Object(), new Object()};

    public void f() {
        synchronized (objects[0]) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f2()");
                Thread.yield();
            }
        }
    }

    public void g() {
        synchronized (objects[1]) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g2()");
                Thread.yield();
            }
        }
    }

    public void h() {
        synchronized (objects[2]) {
            for (int i = 0; i < 5; i++) {
                System.out.println("h2()");
                Thread.yield();
            }
        }
    }
}

public class Eg15 {
    public static void main(String[] args) {
        SyncTest2 syncTest2 = new SyncTest2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                syncTest2.f();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                syncTest2.g();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                syncTest2.h();
            }
        });
        executorService.shutdown();
    }
}
