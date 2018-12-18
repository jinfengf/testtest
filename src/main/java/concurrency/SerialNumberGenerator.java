package concurrency;

/**
 * Created by jiguang on 2018/10/23.
 */

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
