package generics;

/**
 * Created by jiguang on 2018/8/30.
 */

interface Payable {
    void f();
}

class Employee1 implements Payable {
    @Override
    public void f() {
        System.out.println("Employee");
    }
}

class Hourly extends Employee1 implements Payable {

}

public class MultipleInterfaceVariants {

}
