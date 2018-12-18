package concurrencyEg;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/10/25.
 */

public class Eg14 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            Timer t= new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("aaaa");
                }
            }, i * 100);
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.cancel();
        }
    }
}
