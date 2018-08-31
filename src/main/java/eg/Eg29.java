package eg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generics.Holder;

/**
 * Created by jiguang on 2018/8/28.
 */

public class Eg29 {
    static void f(Holder<List<?>> holder) {
        List<Integer> integers = new ArrayList<>();
        holder.set(integers);
        List list = holder.get();
        list.add("aaaaa");
        list.add(1);
        System.out.println(list);
    }

    public static void main(String[] args) {
        Holder<List<?>> holder = new Holder<>();
        f(holder);
    }
}
