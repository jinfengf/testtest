/**
 * Created by jiguang on 2018/2/26.
 */

public class DeadLockTest {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(a) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        for (int i = 0; i < 10; ++i) {
                            System.out.println("Thread1:" + i);
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    synchronized (a) {
                        for (int i = 0; i < 10; ++i) {
                            System.out.println("Thread2:" + i);
                        }
                    }
                }
            }
        }).start();
    }
}
