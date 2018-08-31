package generics;

import java.util.List;

/**
 * Created by jiguang on 2018/8/31.
 */

public class UserList2<W, T> {
    void f1(List<T> v) {}
    void f2(List<W> w) {}
}
