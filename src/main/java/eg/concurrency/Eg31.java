package eg.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrency.Chopstick;
import concurrency.Philosopher;

/**
 * Created by jiguang on 2019/1/7.
 */

class Philosopher31 implements Runnable {
    private final int id;
    private final int ponderFactor;
    private Chopstick left;
    private Chopstick right;
    private BlockingQueue<Chopstick> bin;
    private Random rand = new Random(47);
    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }
    public Philosopher31(int ident, int ponder, BlockingQueue<Chopstick> bin) {
        id = ident;
        ponderFactor = ponder;
        this.bin = bin;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.print(this + " " + "thinking ");
                pause();
                System.out.print(this + " " + "grabbing right ");
                right = bin.take();
                System.out.print(this + " " + "grabbing left ");
                left = bin.take();
                System.out.print(this + " " + "eating ");
                pause();
                bin.put(right);
                bin.put(left);
            }
        } catch (InterruptedException e) {
            System.out.print(this + " " + "exiting via interrupt");
        }
    }
    public String toString() {
        return "Philosopher " + id;
    }
}

public class Eg31 {
    public static void main(String[] args) throws Exception {
        int size = 5;
        int ponder = 0;
        Chopstick[] ticks = new Chopstick[size];
        LinkedBlockingQueue<Chopstick> bin = new LinkedBlockingQueue<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            ticks[i] = new Chopstick();
            bin.put(ticks[i]);
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher31(i, ponder, bin));
        }
        System.out.println("Press 'Enter' to quit");
        System.in.read();
        exec.shutdownNow();
    }
}
