package generics;

import net.mindview.util.Tuple;
import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiguang on 2018/9/7.
 */

class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                if (!delegatesByMethod.containsValue(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {

    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(Tuple.tuple(new BasicImp(), Basic.class), Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
                Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class), Tuple.tuple(new Bounded(), HasColor.class));
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        HasColor h = (HasColor) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
        System.out.println(h.getColor());
    }
}
