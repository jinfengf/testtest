package generics;

import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.SixTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import typeinfo.Person;

import static net.mindview.util.Tuple.tuple;

/**
 * Created by jiguang on 2018/6/6.
 */

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }
    static TwoTuple f2() {
        return tuple("hi", "1111");
    }
    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }
    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }
    static SixTuple<String, Vehicle, Amphibian, String, Integer, Double> m() {
        return tuple("123", new Vehicle(), new Amphibian(), "456", 47, 11.2);
    }
    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(m());
    }
}

class Amphibian {}
class Vehicle {}
