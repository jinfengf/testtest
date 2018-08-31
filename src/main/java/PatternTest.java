import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.net.www.content.text.Generic;

/**
 * Created by jiguang on 2018/2/24.
 */

public class PatternTest<T> {

    private static Object object = new Object();
    private static Object object1 = new Object();

    public enum DateType {
        im_response(0), network_change(1);

        private int value;
        DateType(int value) {
            this.value = value;
        }
    }

    public static void f1() {
        synchronized (object) {
            System.out.println("f1():synchronized object");
            synchronized (object1) {
                System.out.println("f1():synchronized object1");
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void f111(String s) {
        System.out.println("String");
    }

    public static void f111(Object o) {
        System.out.println("Object");
    }

    public static void f11() {
        synchronized (object1) {
            System.out.println("f11():synchronized object1");
            synchronized (object) {
                System.out.println("f11():synchronized object");
            }
        }
    }

//    public static void g(int[][] a, int x, int y, int start, int n) {
//        for (int i = 0; i <= 4 * n - 4; ++i, ++start) {
//            if (i < n) {
//                a[x][y] = start % 10;
//                y++;
//            }
//            if (i == n) {
//                x++;
//                y--;
//            }
//            if ((i >= n) && (i < 2 * n - 1)) {
//                a[x][y] = start % 10;
//                x++;
//            }
//            if (i == 2 * n - 1) {
//                x--;
//                y--;
//            }
//            if (i >= 2 * n - 1 && i < 3 * n - 2) {
//                a[x][y] = start % 10;
//                y--;
//            }
//            if (i == 3 * n -2) {
//                y++;
//                x--;
//            }
//            if (i >= 3 * n - 2 && i < 4 * n - 4) {
//                a[x][y] = start % 10;
//                x--;
//            }
//            if (i == 4 * n - 4) {
//                x++;
//                y++;
//                g(a, x, y, start, n - 2);
//            }
//        }
//    }
//
//
//    public static void k(int n) {
//        int[][] a = new int[n][n];
//        g(a, 0, 0, 0, n);
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                System.out.print(a[i][j]);
//            }
//            System.out.println();
//        }
//    }


    public static void h(long... a) {
        System.out.println(a);
    }

    public static void ff1() {
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("aaaaaaaa");
        }
    }

    public static boolean ff2() {
        ff1();
         return true;
    }

    public static void ff3() {
        if (ff2()) {
            System.out.println("bbbbbbbbb");
        }
    }

    public static <T> void ff33(Object t) {
        System.out.println();
        T t1 = (T) t;
        System.out.println(t1.getClass().getSimpleName());
    }

    public static void ff4(String... strings) {
        System.out.println(strings == null);
    }

    public static void ass1(Object a, Object b) {

    }

    public static void ass1(long a, long b) {

    }

    static class Generic1<T> extends TypeToken<T> {
        Generic1() {
        }
    }

    static void f1(String[] strings) {
        for (String s : strings) {
            System.out.println(s);
        }
        throw new UnsupportedOperationException("aaa");
    }

    public static boolean validNullableName(String name) {
        if (null == name) {
            return true;
        }

        boolean invalidLength = false;
        boolean haveInvalidMark;
        if (name.getBytes().length > 200) {
            invalidLength = true;
        }
        Pattern pattern = Pattern.compile("\\t");
        Matcher matcher = pattern.matcher(name);
        haveInvalidMark = matcher.find();
        System.out.println("find:" + haveInvalidMark);
        return !invalidLength && !haveInvalidMark;
    }

    static class StringA {
        String name = "123\n";
    }

    static class Counter {
        int i = 0;
        String s = "aaa";
    }

    static class Counter1 {
        JsonElement counter;
    }

    static class Counter2 {
        String counter;
    }

    public static void main(String[] args) {
//        Gson gson = new Gson();
//        Counter counter = new Counter();;
//        JsonElement jsonElement = gson.toJsonTree(counter);
//        Counter1 counter1 = new Counter1();
//        counter1.counter = jsonElement;
//        String json = gson.toJson(counter1);
//        System.out.println(json);
//        Counter1 counter11 = gson.fromJson(json, Counter1.class);
//        System.out.println(counter11.counter);
//        Counter2 counter2 = gson.fromJson(json, Counter2.class);
//        System.out.println(counter2.counter);
//        Map map = new HashMap();
//        Set set = new HashSet(map.keySet());
//        System.out.println(set.size());
//        System.out.println(new Generic1<String>().getType().getTypeName());
//        Generic1<String> generic1 = new Generic1<>();
//        System.out.println(generic1.getClass().getGenericSuperclass());
//        System.out.println(new TypeToken<String>(){}.getClass().getGenericSuperclass());
//        int a =  0x7FFFFFFF;
//        System.out.println(a);
//        Gson gson = new Gson();
////        Map<String, Integer> map = new HashMap<>();
//        map.put("aaa", 11);
//        String json = gson.toJson(map);
//        System.out.println(json);
//        System.out.println(new TypeToken<Map<String, Integer>>(){}.getType().getTypeName());
//        Map map1 = gson.fromJson(json, new TypeToken<Map<String, Integer>>(){}.getType());
//        map1.put("bbb", 3.9);
//        System.out.println(map1.getClass().getName());
//        System.out.println(gson.toJson(map1));
//        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
//        for (Map.Entry entry : entries) {
//            System.out.println(entry.getKey().getClass().getName());
//            System.out.println(entry.getValue().getClass().getName());
//        }
//        G g1 = gson.fromJson(json, G.class);
//        System.out.println(gson.toJson(g1));
//        System.out.println(aa.extras);

//        if (b instanceof a.getClass()) {
//            System.out.println("true");
//        }
//        for (int i = 0; i < 9; ++i) {
//            final CountDownLatch countDownLatch = new CountDownLatch(1);
//            System.out.println(i + "");
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                        countDownLatch.countDown();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//        Map<P, String> map = new TreeMap<>(new Comparator<P>() {
//            @Override
//            public int compare(P o, P t1) {
//                return o.compareTo(t1);
//            }
//        });
//        for (int i = 999; i > 0; --i) {
//            P p = new P(i, i);
//            map.put(p, "" + i);
//        }
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(map));
//        System.out.println(map.get(new P(88, 0)));
//        Map<Long, String> map = new TreeMap<>();
//        map.put(3L, "33333");
//        map.put(2L, "22222");
//        map.put(1L, "11111");
//        System.out.println(map);
//        Map<Long, String> map = new HashMap<>();
//        System.out.println(map);
//        System.out.println(map.keySet());
//        map.put(1L, "11111");
//        map.put(2L, "222222");
//        map.put(3L, "333333");
//        map.put(4L, "444444");
//        System.out.println(map);
//        Long[] array = {1L, 2L, 3L};
//        List<Long> longs = Arrays.asList(array);
//        map.keySet().removeAll(longs);
//        System.out.println(map);
    }


    public static int f1(long l) {
        try {
            int i = 0;
            prepareData(false);
            try {
                userDataProvider(true);
                return i;
            } catch (Exception e) {
//                System.out.println("use dataProvider failed caused by :" + e.getMessage() + ".user broadcast");
                useBroadcast(true);
                return i;
            } finally {
                System.out.println("11111111111111111111111");
            }
        } catch (Exception e) {
            System.out.println("222222222222222222");
            e.printStackTrace();
            return -1;
        }
    }
    public static int k() {
        try {
            prepareData(true);
            return 1;
        } catch (Exception e) {

        }
        return 2;
    }

    public static void prepareData(boolean isThrows) throws Exception1 {
        if (isThrows) {
            throw new Exception1();
        }
    }

    public static void userDataProvider(boolean isThrows) throws Exception2 {
        if (isThrows) {
            throw new Exception2();
        } else {
            System.out.println("userDataProvider");
        }
    }

    public static void useBroadcast(boolean isThrows) throws Exception3 {
        if (isThrows) {
            throw new Exception3();
        } else {
            System.out.println("useBroadcast");
        }
    }

    public static void f2() {
        String s = null;
        s.toString();
    }
}

class P implements Comparable<P> {
    long uid;
    long cTime;

    public P(long uid, long cTime) {
        this.uid = uid;
        this.cTime = cTime;
    }

    @Override
    public int hashCode() {
        return ((Long) uid).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof P) && ((P) o).uid == uid;
    }

    @Override
    public int compareTo(P o) {
        if (uid == o.uid) {
            return 0;
        } else {
            if (cTime > o.cTime) {
                return 1;
            } else if (cTime < o.cTime) {
                return -1;
            } else {
                if (uid > o.uid) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}

class Exception1 extends Exception {
    public Exception1() {
        super("Exception1");
    }
}

class Exception2 extends  Exception {
    public Exception2() {
        super("Exception2");
    }
}

class Exception3 extends  Exception {
    public Exception3() {
        super("Exception3");
    }
}

class F {
    static List<Integer> list = new ArrayList<>();

    synchronized static void f(int[] a) {
        System.out.println("ffffffffffffffffffffffffff");
        for (int i : a) {
            if (list.contains(i)) {
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(i);
                System.out.println(i);
            }
        }
    }

    static void k(int[] a, String s) {
        System.out.println(s + " start");
        for (int i = 0 ; i < 3; ++i) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s + ":" + i);
        }
        f(a);
        System.out.println(s + " end");
    }
}

class G {
    private String a = "11111";
    public int b = 2;

    public G(int a, int b) {

    }
}

interface C {
    void f();
}



interface H<T> {
    void h();
}



