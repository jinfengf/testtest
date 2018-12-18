package net.mindview.util;

import java.util.concurrent.ThreadFactory;

/**
 * Created by jiguang on 2018/9/18.
 */

public class DameonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
