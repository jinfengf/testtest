/**
 * Created by jiguang on 2018/3/2.
 */

public class HashCodeTest {
    public static void main(String[] args) {
        String a = "123";
        String b = new String("123");
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
