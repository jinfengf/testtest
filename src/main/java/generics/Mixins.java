package generics;

import java.util.Date;

/**
 * Created by jiguang on 2018/9/7.
 */

interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Id {
    long getId();
}

class IdImp implements Id {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public long getId() {
        return id;
    }
}

interface Basic {
    int a = 2;
    public void set(String val);
    public String get();
}

class BasicImp implements Basic {
    private String value;
    public void set(String val) {
        value = val;
    }
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Id {
    private TimeStampedImp timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Id id = new IdImp();

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public long getId() {
        return id.getId();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " "
        + mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " + mixin1.getId());
        System.out.println(mixin2.get() + " "
        + mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " + mixin2.getId());
    }
}
