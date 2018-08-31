package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by jiguang on 2018/8/30.
 */

public class ClassCasting {
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<Widget> lw2 = List.class.cast(in.readObject());

    }
}
