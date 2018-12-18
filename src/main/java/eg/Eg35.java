package eg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coffee.Breve;
import coffee.Cappuccino;

/**
 * Created by jiguang on 2018/9/4.
 */

public class Eg35 {
    static void oldStyleMethod(List probablyBreve) {
        probablyBreve.add(new Cappuccino());
    }

    public static void main(String[] args) {
        List<Breve> list = new ArrayList<>();
        oldStyleMethod(list);
        List<Breve> list1 = Collections.checkedList(new ArrayList(), Object.class);
        oldStyleMethod(list1);
    }
}
