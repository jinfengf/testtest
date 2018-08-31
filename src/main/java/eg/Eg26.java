package eg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiguang on 2018/8/15.
 */

public class Eg26 {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
        Number integer = list.get(0);
    }
}
