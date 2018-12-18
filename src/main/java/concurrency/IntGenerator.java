package concurrency;

/**
 * Created by jiguang on 2018/10/18.
 */

public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
