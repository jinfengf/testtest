package generics;

import java.util.List;

/**
 * Created by jiguang on 2018/8/20.
 */

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());

    }
}
