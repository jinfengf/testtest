package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdk.nashorn.internal.ir.CatchNode;

/**
 * Created by jiguang on 2018/9/3.
 */

class Pet {

}

class Cat extends Pet {
}

class Dog extends Pet {

}

public class CheckedList {
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<Dog>();
        oldStyleMethod(dogs1);
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
