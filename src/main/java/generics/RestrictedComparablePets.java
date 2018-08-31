package generics;

/**
 * Created by jiguang on 2018/8/31.
 */

public class RestrictedComparablePets {
}

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet comparablePet) {
        return 0;
    }
}

class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet comparablePet) {
        return 0;
    }
}
