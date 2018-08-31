package typeinfo;

import util.Null;

/**
 * Created by jiguang on 2018/5/31.
 */

public class Person {
    public final String first;
    public final String last;
    public final String address;
    //etc
    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {
        private NullPerson() {
            super("None", "None", "None");
        }
        public String toString() {
            return "NullPerson";
        }
    }

    public static final Person Null = new NullPerson();
}
