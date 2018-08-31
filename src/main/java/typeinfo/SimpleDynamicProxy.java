package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiguang on 2018/5/29.
 */

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    private static Map<String, Integer> countMap = new HashMap<>();
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Method method1 : proxy.getClass().getMethods()) {
            System.out.println(method1);
        }
        System.out.println("**** proxy: " + proxy.getClass() + ".method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        if (countMap.containsKey(method.getName())) {
            countMap.put(method.getName(), countMap.get(method.getName()) + 1);
        } else {
            countMap.put(method.getName(), 1);
        }
        System.out.println(method.getName() + ":" + countMap.get(method.getName()));
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        // Insert a proxy and call again
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
        consumer(proxy);
        consumer(proxy);
        System.out.println(proxy.getClass());
    }
}
