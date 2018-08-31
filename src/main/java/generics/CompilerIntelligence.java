package generics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jiguang on 2018/8/20.
 */

public class CompilerIntelligence {
    public static void main(String[] args) {
        Apple apple = new Apple();
        List<? extends Fruit> flist = Arrays.asList(apple);
        Apple a = (Apple) flist.get(0);
        System.out.println(flist.contains(apple));
        System.out.println(flist.indexOf(apple));
    }
}
