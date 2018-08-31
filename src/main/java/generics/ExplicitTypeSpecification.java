package generics;

import net.mindview.util.New;

import java.util.List;
import java.util.Map;

import typeinfo.Person;

/**
 * Created by jiguang on 2018/6/8.
 */

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<? extends String>> pet) {}
    public static void main(String[] args) {
        f(New.<Person, List<? extends String>>map());
    }
}
