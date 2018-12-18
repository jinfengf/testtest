import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiguang on 2018/2/24.
 */

public class PatternTest<T> {

    private static Object object = new Object();
    private static Object object1 = new Object();

    private static boolean stopRequested = false;
    private static Map<Integer, Integer> map = new ConcurrentHashMap();

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

    static class Counter2 {
        String counter;
    }


    static void fff2() {
        System.out.println("aaaaaaa");
        return;
    }

    private static void requestStop() {
        stopRequested = true;
    }
    private static synchronized boolean stopRequested() {
        return stopRequested;
    }
    private static AtomicInteger id = new AtomicInteger();

    static class IntegerCompator implements Comparator<Integer> {
        @Override
        public int compare(Integer t1, Integer t2) {
            int result = 0;
            if (t1 > t2) {
                result = 1;
            } else if (t1 > t2) {
                result = -1;
            }
            System.out.println("compare" + t1 + "," + t2 + ".result:" + result);
            return result;
        }
    }

    static <T extends Collection<G>> T kkkk(T t) {
        return t;
    }

    static class MM<T> {
        void g(T t) {
        }

        static <T> MM<T>get(T t) {
            return new MM<T>();
        }
    }

    static void ffff(String s, String s1, String... param) {
        System.out.println(param == null);
        System.out.println(param[1]);
        fffff(param);
    }

    static void fffff(String... param) {
        System.out.println(param == null);
        System.out.println(param.length);
    }
    static AtomicBoolean b = new AtomicBoolean(true);

//    public synchronized static boolean getBoolean() {
//        return b;
//    }

    public static <T extends G> void test1(List<T> list) {
    }

    public static class Cache<T> {
        T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }

    interface Lam {
        void f(int a, int b, G c);
    }

    enum M {
        A, B, C, D;

        public int getValue() {
            return 1;
        }
    }


    static boolean as = true;

    static int a;

    static int fff() {
        Random random = new Random(System.currentTimeMillis());
        a = random.nextInt(100) + 1;
        System.out.println(a);
        if (a % 2 != 0) {
            fff();
        }
        return a;
    }

    static abstract class MMM<T> {
        public abstract void getResult(T t);
        public void getResult(Object... objects) {
            if (objects != null && objects.length > 0 && objects[0] != null) {
                getResult((T) objects[0]);
            }
        }
    }

    static class KK {
        MMM mm;
        KK(MMM mm) {
            this.mm = mm;
        }
        void f(Object... objects) {
            mm.getResult(objects);
        }
    }

    static boolean cancel = false;

    static void f(G... parm) {
        System.out.println(parm == null);
        System.out.println(parm.length);
        Object o = null;
        G g = (G) o;
        System.out.println((G) parm[0]);
    }

    static class Compa implements Comparator<Integer> {
        @Override
        public int compare(Integer integer, Integer t1) {
            return integer > t1 ? -1 : integer < t1 ? 1 : 0;
        }
    }

    static class FF {
        boolean flag = false;

//        synchronized boolean get() {
//            return flag;
//        }
    }
    static volatile FF ff = new FF();

    public static void main(String[] args) {
        G g = new G();
        GG gg = new GG();
        gg.a = 1;
        gg.b = 2;
        g.gg = gg;
        Gson gson = new Gson();
        Gson gson1 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(g);
        String json1 = gson1.toJson(g);
        System.out.println(json);
        System.out.println(json1);
        G g1 = gson1.fromJson(json, G.class);
        System.out.println(g1.gg.a);
        System.out.println(g1.gg.b);
        GGG g2 = gson.fromJson(json, GGG.class);
        System.out.println(g2.a);
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        System.out.println(jsonObject.getAsJsonPrimitive("a").isString());
        System.out.println(jsonObject.has("c"));
        System.out.println(jsonObject.getAsJsonPrimitive("c"));

//        System.out.println(list1.get(0));
//        System.out.println(list.get(0).getClass().getName());


//        String s = "aaaaa";
//        System.out.println(json);
//        String json2 = json.replace("aaa", "bbb");
//        System.out.println(json2);
//        G g1 = gson.fromJson(json2, G.class);
//        System.out.println(g1.b);


//        System.out.println(Charset.defaultCharset().toString());
//        String a = new String("?abcdef");
//        System.out.println(a.length());
//        System.out.println(a);
//        System.out.println(a.getBytes().length);
//        System.out.println(a.getBytes("UTF-8").length);
//        System.out.println(a.getBytes("UTF-16").length);
//        System.out.println(a.getBytes("GBK").length);
//        System.out.println(a);
//        byte[] bytes = a.getBytes("GBK");
//        String b = new String(bytes, "UTF-8");
//        System.out.println(b);
//        System.out.println(new String(a.getBytes("UTF-8"), "UTF-8"));
//        System.out.println(new String(a.getBytes("UTF-8"), "GBK"));
//        System.out.println(a.length());
//        System.out.println(a.getBytes().length);
//        System.out.println(b.length());
//        System.out.println(bytes.length);
//        System.out.println(b.getBytes().length);
//        String c = new String(b.getBytes());
//        System.out.println(c);
//        FF ff = G.ff;
//        System.out.println(G.ff.a);
//        System.out.println(ff.hashCode());
//        ff.a = 3;
//        System.out.println(G.ff.a);
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

interface A1 {
    void f();
}

class B1 implements A1 {
    @Override
    public void f() {

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

class FF {
    public int a = 1;
}

abstract class G1 {
    String c = "ccccccccc";

    abstract void f();
}

class G2 extends G1 {
    String a = "aaaaaa";
    String b = "bbbbbbbbbbbb";

//    public G2() {
//        a = "ddddddddddd";
//    }

    public G2(int a1, int b1) {
        super();
        a = "ddddddddddddd";

    }
    @Override
    void f() {

    }
}

class G {
    @Expose
    GG gg;
    @Expose
    final String a = "aaaaaa";

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}

class GG {
    @Expose
    int a;
    @Expose
    int b ;
}

class GGG {
    String a;
}

class GCompator implements Comparator<G> {
    @Override
    public int compare(G o, G t1) {
        return 0;
    }
}

interface C {
    void f();
}

abstract class M2 {
    private void f() {
        System.out.println("M2");
    }
}



interface H<T> {
    void h();
}



