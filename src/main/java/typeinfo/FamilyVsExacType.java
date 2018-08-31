package typeinfo;

/**
 * Created by jiguang on 2018/5/24.
 */

public class FamilyVsExacType {
    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());// Base derived
        System.out.println("x instanceof Base " + (x instanceof Base));//true true
        System.out.println("x instanceof Derived " + (x instanceof Derived));//false true
        System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));//true false
        System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));//false true
        System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));//true fa;se
        System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));//false true
        System.out.println("x.getClass().equals(Base.class) " + (x.getClass().equals(Base.class)));//true false
        System.out.println("x.getClass().equals(Derived.class) " + (x.getClass().equals(Derived.class)));//false true
    }
    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}

class Base {}
class Derived extends Base {}
