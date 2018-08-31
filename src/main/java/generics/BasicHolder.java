package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiguang on 2018/8/31.
 */

public class BasicHolder<T> {
    T element;
    void set(T arg) {
        element = arg;
    }
    T get() {
        return element;
    }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
