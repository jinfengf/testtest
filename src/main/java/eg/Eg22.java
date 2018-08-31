package eg;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jiguang on 2018/8/8.
 */

class Building1 {}

class House1 extends Building1 {
    private String location;
    private Integer area;
    public House1() {
        location = null;
    }
    public House1(Integer area) {
        this.area = area;
    }
    public House1(String location) {
        this.location = location;
    }
    public House1(String location, Integer area) {
        this.location = location;
        this.area = area;
    }
    public String toString() {
        return "House" + ((location == null) ? "" : " in " + location)
                + ((area != null) ? (", " + area + " sqft") : "");
    }
}

public class Eg22<T> {
    Class<?> kind;
    public Eg22(Class<?> kind) {
        this.kind = kind;
    }
    public Object createNew(String typename) throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        return Class.forName(typename).newInstance();
    }

    public Object createNew(String typename, Object... args)
        throws IllegalAccessException,
            InstantiationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {
        switch (args.length) {
            case 1 : return  Class.forName(typename).getConstructor(args[0].getClass()).newInstance(args[0]);
            case 2 : return Class.forName(typename).getConstructor(args[0].getClass(), args[1].getClass()).
                    newInstance(args[0], args[1]);
        }
        return null;
    }

    public static void main(String[] args) {
        Eg22<Building1> egb = new Eg22<>(Building1.class);
        Eg22<House1> egh = new Eg22<>(House1.class);
        try {
            Building1 b = (Building1) egb.createNew("eg.Building1");
            System.out.println("House1 constructors");
            Constructor[] ctors = House1.class.getConstructors();
            for (Constructor ctor : ctors) {
                System.out.println(ctor);
            }
            House1 h = (House1) egh.createNew("eg.House1", "Hawaii");
            House1 h2 = (House1) egh.createNew("eg.House1", 3000);
            House1 h3 = (House1) egh.createNew("eg.House1", "Manila", 5000);
            House1 h4 = (House1) egh.createNew("eg.House1", "asssss", 10000, 20000);
            System.out.println("Constructed House objects:");
            System.out.println(h);
            System.out.println(h2);
            System.out.println(h3);
            System.out.println(h4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
