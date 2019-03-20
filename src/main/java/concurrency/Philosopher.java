package concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2019/1/6.
 */

public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);
    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }
    public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
        this.left = left;
        this.right = right;
        id = ident;
        ponderFactor = ponder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.print(this + " " + "thinking ");
                pause();
                System.out.print(this + " " + "grabbing right ");
                right.take();
                System.out.print(this + " " + "grabbing left ");
                left.take();
                System.out.print(this + " " + "eating ");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.print(this + " " + "exiting via interrupt");
        }
    }
    public String toString() {
        return "Philosopher " + id;
    }
}
