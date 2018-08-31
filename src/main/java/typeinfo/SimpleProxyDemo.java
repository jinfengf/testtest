package typeinfo;

/**
 * Created by jiguang on 2018/5/28.
 */

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    private static int doCount = 0;
    private static int sECount = 0;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        doCount++;
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        System.out.println("doCount:" + doCount);
    }

    public void somethingElse(String arg) {
        sECount++;
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        System.out.println("sECount:" + sECount);
    }
}

public class SimpleProxyDemo {
    public static int count = 0;
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
        count++;
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
        System.out.println("count:" + count);
    }
}
