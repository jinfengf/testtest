package generics;

import net.mindview.util.New;

import java.util.List;
import java.util.Map;

import typeinfo.Person;

/**
 * Created by jiguang on 2018/6/8.
 */

public class LimitsOfInterence {
    static void f(Map<Person, List<? extends String>> petPeople) {
    }

    public static void main(String[] args) {
        Map<Person, List<? extends String>> map = New.map();
        f(map);
    }
}
