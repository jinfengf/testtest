package eg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiguang on 2018/8/9.
 */

public class ClassTypeCapture24<T> {
    static class Building {}
    static class House extends Building {}

    static class BuildingFactory implements Factory<Building> {
        @Override
        public Building create() {
            return new Building();
        }
    }

    static class HouseFactory implements Factory<House> {
        @Override
        public House create() {
            return new House();
        }
    }

    Class<?> kind;
    Map<String, Factory> factoryMap;

    public ClassTypeCapture24(Class<?> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture24(Class<?> kind, Map<String, Factory> factoryMap) {
        this.kind = kind;
        this.factoryMap = factoryMap;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typename, Factory factory) {
        factoryMap.put(typename, factory);
    }

    public Object createNew(String typename) {
        if (factoryMap.containsKey(typename)) {
            return factoryMap.get(typename).create();
        }
        System.out.println(typename + " class not available");
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture24<Building> ctt1 = new ClassTypeCapture24<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture24<House> ctt2 = new ClassTypeCapture24<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
        ClassTypeCapture24<Building> ct =
                new ClassTypeCapture24<Building>(Building.class, new HashMap<String, Factory>());
        ct.addType("House", new HouseFactory());
        ct.addType("Building", new BuildingFactory());
        System.out.println("ct.map = " + ct.factoryMap);
        Building b = (Building) ct.createNew("Building");
        House h = (House) ct.createNew("House");
        System.out.println("b.getClass().getName():" + b.getClass().getName());
        System.out.println("h.getClass().getName():" + h.getClass().getName());
        System.out.println("House h is instance House: " + (h instanceof House));
        System.out.println("House h is instance of Building: " + (h instanceof Building));
        System.out.println("Building b is instance of House: " + (b instanceof House));
    }
}
interface Factory<T> {
    T create();
}
