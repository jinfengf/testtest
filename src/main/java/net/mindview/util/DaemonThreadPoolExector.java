package net.mindview.util;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiguang on 2018/9/18.
 */

public class DaemonThreadPoolExector extends ThreadPoolExecutor {
    public DaemonThreadPoolExector() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DameonThreadFactory());
    }
}
