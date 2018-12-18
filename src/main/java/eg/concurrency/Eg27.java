package eg.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiguang on 2018/12/10.
 */

class Meal {
    private final int orderNum;
    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();
    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                try {
                    lock.lock();
                    while (restaurant.meal == null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                System.out.print("Waitperson got " + restaurant.meal);
                try {
                    restaurant.chef.lock.lock();
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll();
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("\nWaitPerson interrupted");
        }

    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();
    private int count = 0;
    public Chef(Restaurant r) {
        restaurant = r;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                try {
                    lock.lock();
                    while (restaurant.meal != null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    System.out.print("\nOut of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.print("\nOrder up! ");
                try {
                    restaurant.waitPerson.lock.lock();
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
//                if (count == 10) {
//                    System.out.println("aaaaaaaaaaaa");
//                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.print("\nChef interrupted");
        }
    }
}

class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new concurrency.Restaurant();
    }
}

public class Eg27 {
}
