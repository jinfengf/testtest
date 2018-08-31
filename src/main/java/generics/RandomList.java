package generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jiguang on 2018/6/7.
 */

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);
    public void add(T item) {
        storage.add(item);
    }
    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<String>();
        for (String s : ("The quick brown fox jumped over " + "the lazy brown dog").split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(rs.select() + " ");
        }
        System.out.println();
        RandomList<Integer> ri = new RandomList<>();
        for (int i = 0; i < 11; i++) {
            ri.add(i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(ri.select() + " ");
        }
    }
}
