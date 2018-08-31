package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiguang on 2018/8/28.
 */

public class ByteSet {
    static Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possibles));
    static Set<Byte> mySet2 = new HashSet(Arrays.asList(1, 2,3, 4, 5));

    public static void main(String[] args) {
        System.out.println(mySet.iterator().next().getClass().getName());
        System.out.println(mySet2.iterator().next().getClass());

    }
}
