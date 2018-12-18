package concurrency;

import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/11/2.
 */

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService =  new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new PriorityBlockingQueue<Runnable>());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("name:" + Thread.currentThread().getName());
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                System.out.println("aaaaaaaaaaa");
                Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
                System.out.println("ddddddddddddddd");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("name:" + Thread.currentThread().getName());
                Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
                System.out.println("bbbbbbb");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("name:" + Thread.currentThread().getName());
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                System.out.println("cccccccccccccc");
            }
        });
        executorService.shutdown();
    }

    static class ThreadFactory1 implements ThreadFactory {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        private int priority;
        ThreadFactory1(int priority) {
            this.priority = priority;
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = threadFactory.newThread(r);
            thread.setPriority(priority);
            return thread;
        }
    }
}
