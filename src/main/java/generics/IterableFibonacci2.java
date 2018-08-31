package generics;

import java.util.Iterator;

/**
 * Created by jiguang on 2018/6/8.
 */

public class IterableFibonacci2 implements Iterable<Integer> {
    private int n;
    Fibonacci fibonacci = new Fibonacci();
    public IterableFibonacci2(int count) {
        n = count;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int a : new IterableFibonacci2(18)) {
            System.out.print(a + " ");
        }
    }
}
