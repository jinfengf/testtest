package concurrency;

/**
 * Created by jiguang on 2018/9/19.
 */

public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    public String toString() {
        new Thread().start();
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if(--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
