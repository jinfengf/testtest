package InnerClass;

/**
 * Created by jiguang on 2018/1/12.
 */

class WithInner {
    public static void main(String[] args) {
    }
}

interface Counter {
    int next();
}
class LocalInnerClass {
    private int count = 0;
    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            @Override
            public int next() {
                return 0;
            }
        }
        return new LocalCounter();
    }
}

class A {
    class B{

    }
}
