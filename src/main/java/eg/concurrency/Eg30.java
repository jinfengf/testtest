package eg.concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2019/1/6.
 */

class CharacterBlockingQueue extends LinkedBlockingQueue<Character> {}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private CharacterBlockingQueue characterQueue;
    public Sender(CharacterBlockingQueue characterQueue) {
        this.characterQueue = characterQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    characterQueue.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println("\n" + e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private CharacterBlockingQueue characterQueue;
    public Receiver(CharacterBlockingQueue characterQueue) {
        this.characterQueue = characterQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.print("Read: " + characterQueue.take() + ", ");
            }
        } catch (InterruptedException e) {
            System.out.print("\n" + e + " Receiver read exception");
        }
    }
}

public class Eg30 {
    public static void main(String[] args) throws Exception {
        CharacterBlockingQueue characterQueue = new CharacterBlockingQueue();
        Sender sender = new Sender(characterQueue);
        Receiver receiver = new Receiver(characterQueue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
