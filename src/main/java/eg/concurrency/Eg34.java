package eg.concurrency;

import net.mindview.util.Generator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import generics.BasicGenerator;

/**
 * Created by jiguang on 2019/2/22.
 */

public class Eg34 {
    static int size = 10;
    private static int delay = 5;
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            size = Integer.valueOf(args[0]);
        }
        if (args.length > 1) {
            delay = Integer.valueOf(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<MyClass>> xc = new Exchanger<>();
        List<MyClass> producerList = new CopyOnWriteArrayList<>();
        List<MyClass> consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer34<>(xc, BasicGenerator.create(MyClass.class), producerList));
        exec.execute(new ExchangerConsumer34<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}

class ExchangerProducer34<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    ExchangerProducer34(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
        exchanger = exchg;
        generator = gen;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < Eg34.size; i++) {
                    holder.add(generator.next());
                }
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExchangerConsumer34<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    ExchangerConsumer34(Exchanger<List<T>> ex, List<T> holder) {
        exchanger = ex;
        this.holder = holder;
        System.out.println("holer:" + holder.hashCode());
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x;
                    holder.remove(x); //
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final value: " + value);
    }
}

class MyClass {
    private static int count = 0;
    private final int id = count++;

    @Override
    public String toString() {
        return "myClass:" + id;
    }
}
