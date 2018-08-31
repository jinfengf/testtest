import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jiguang on 2018/3/7.
 */

public class StaticClassTest {
    public enum Dtae {
        MONDAY (1),
        TUESDAT(1);

        private int value;

        Dtae(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Set<Long> set = new LinkedHashSet<>();
        set.add(1l);
        set.add(2l);
        set.add(3l);
        System.out.println(set);
        List<Long> list = new ArrayList<>();
        list.add(3l);
        list.add(2l);
        list.add(1l);
        System.out.println(list);
        System.out.println(set.addAll(list));
        System.out.println(set);
    }

}
