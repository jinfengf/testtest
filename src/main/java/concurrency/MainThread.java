package concurrency;

/**
 * Created by jiguang on 2018/9/14.
 */

public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
