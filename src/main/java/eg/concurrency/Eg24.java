package eg.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiguang on 2018/12/7.
 */

class Item {
    private final int itemNum;
    Item(int itemNum) {
        this.itemNum = itemNum;
    }

    @Override
    public String toString() {
        return "Item " + itemNum;
    }
}

class Consumer implements Runnable {
    int consumed = 0;
    Market24 market;
    Consumer(Market24 market) {
        this.market = market;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                synchronized (this) {
                    while (market.storage.size() <= 0) {
                        wait();
                    }
                }
                if (market.storage.poll() != null) {
                    System.out.println("Consuming Item " + ++consumed);
                    synchronized (market.producer) {
                        market.producer.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
                System.out.println("Consumered " + consumed + " Items");
            }
        }
    }
}

class Producer implements Runnable {
    int count;
    Market24 market;
    Producer(Market24 market) {
        this.market = market;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                while (count < 100) {
                    synchronized (this) {
                        while (!(market.storage.size() < 10)) {
                            wait();
                        }
                    }
                    Item item = new Item(++count);
                    if (market.storage.offer(item)) {
                        System.out.println("Produced " + item);
                        synchronized (market.consumer) {
                            market.consumer.notifyAll();
                        }
                    }
                }
                System.out.println("Produced " + count + " Items" + "\nStopping production");
                market.exec.shutdownNow();
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
                System.out.println("Produced " + count + " Items");
            }
        }
    }
}

class Market24 {
    ExecutorService exec = Executors.newCachedThreadPool();
    Queue<Item> storage = new LinkedList<>();
    Producer producer = new Producer(this);
    Consumer consumer = new Consumer(this);
    Market24() {
        exec.execute(producer);
        exec.execute(consumer);
    }
}

public class Eg24 {
    public static void main(String[] args) {
        Market24 market = new Market24();
    }
}
