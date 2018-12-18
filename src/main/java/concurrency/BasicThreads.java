package concurrency;

/**
 * Created by jiguang on 2018/9/14.
 */

public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
