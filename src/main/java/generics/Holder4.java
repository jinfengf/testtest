package generics;

/**
 * Created by jiguang on 2018/6/6.
 */

public class Holder4<T> {
    private T x, y, z;
    public Holder4(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public void setZ(T z) {
        this.z = z;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public T getZ() {
        return z;
    }
}
