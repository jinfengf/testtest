package generics;

/**
 * Created by jiguang on 2018/8/31.
 */

class Base {}
class Derived extends Base{}

interface OrdianryGetter {
    Base get();
}

interface DerivedGetter extends OrdianryGetter {
    @Override
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}
