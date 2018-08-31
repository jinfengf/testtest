/**
 * Created by jiguang on 2018/8/28.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    /** 当前线程的名字 */
    private char currentThreadName = 'A';

    public static void main(String[] args) {
        SyncObj syncObj = new SyncObj();

        Thread threadA = new Thread(new PrintLetterRunnable(syncObj, 'A'));
        Thread threadB = new Thread(new PrintLetterRunnable(syncObj, 'B'));
        Thread threadC = new Thread(new PrintLetterRunnable(syncObj, 'C'));

        threadB.start();
        threadA.start();
        threadC.start();
    }
}

class SyncObj {

    private char letter = 'A';

    public void nextLetter() {
        switch (letter) {
            case 'A':
                letter = 'B';
                break;
            case 'B':
                letter = 'C';
                break;
            case 'C':
                letter = 'A';
                break;
            default:
                break;
        }
    }

    public char getLetter() {
        return letter;
    }

}

class PrintLetterRunnable implements Runnable {

    private SyncObj syncObj;

    private char letter;

    public PrintLetterRunnable(SyncObj syncObj, char letter) {
        this.syncObj = syncObj;
        this.letter = letter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (syncObj) {
                /**
                 * 如果当前线程的字符和同步对象的字符不一致，则当前线程一直等待
                 */
                while (letter != syncObj.getLetter()) {
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                /**
                 * 输出当前线程的字符
                 */
                System.out.print(letter);

                /**
                 * 改变同步对象的letter值
                 */
                syncObj.nextLetter();

                /**
                 * 通知其它所有等待线程
                 */
                syncObj.notifyAll();

            }
        }
    }

}