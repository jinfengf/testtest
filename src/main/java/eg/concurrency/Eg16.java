package eg.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiguang on 2018/11/3.
 */

public class Eg16 {
    static class SyncTest1 {
        private Lock lock = new ReentrantLock();
        public void f() {
            lock.lock();
            System.out.println(((ReentrantLock) lock).getHoldCount());
            System.out.println(lock.tryLock());
            lock.lock();
            System.out.println(((ReentrantLock) lock).getHoldCount());
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("f1()");
                    Thread.yield();
                }
            } finally {
                lock.unlock();
            }
            System.out.println(((ReentrantLock) lock).getHoldCount());
        }

        public void g() {
            lock.lock();
            System.out.println(((ReentrantLock) lock).getHoldCount());
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("g1()");
                    Thread.yield();
                }
            } finally {
                lock.unlock();
            }
            System.out.println(((ReentrantLock) lock).getHoldCount());
        }
    }

    public static void main(String[] args) {
        SyncTest1 syncTest1 = new SyncTest1();
        syncTest1.f();
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest1.g();
            }
        }).start();
    }

}
