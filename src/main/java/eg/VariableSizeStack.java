package eg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiguang on 2018/8/30.
 */

public class VariableSizeStack<T> {
    private List<T> storage = new ArrayList<>();

    public int count() {
        return storage.size();
    }

    public void push(T item) {
        storage.add(item);
    }

    public T pop() {
        return storage.remove(storage.size() - 1);
    }

    public static void main(String[] args) {
        VariableSizeStack<String> strings = new VariableSizeStack<>();
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        while (strings.count() > 0) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
