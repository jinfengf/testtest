package generics;

/**
 * Created by jiguang on 2018/8/31.
 */

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}


class G1<T extends Object> {

}

interface Getter extends GenericGetter<Getter> {}

public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter result = g.get();
        GenericGetter genericGetter = g.get();
    }
}
