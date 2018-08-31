package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiguang on 2018/7/24.
 */

public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<T>();
    }
    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
    }
}
