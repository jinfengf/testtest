package typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jiguang on 2018/5/22.
 */

public class RegisterFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Class<? extends Part>> partClasses = new ArrayList<>();

    static {
        partClasses.add(FueFilter.class);
        partClasses.add(AirFilter.class);
        partClasses.add(CabinAirFilter.class);
        partClasses.add(OilFilter.class);
        partClasses.add(FanBelt.class);
        partClasses.add(PowerSteerinBelt.class);
        partClasses.add(GeneratorBelt.class);
    }

    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partClasses.size());
        try {
            return partClasses.get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static class Filter extends Part {}

    static class FueFilter extends Filter {
        public static class Factory implements typeinfo.Factory<FueFilter> {
            @Override
            public FueFilter create() {
                return new FueFilter();
            }
        }
    }

    static class AirFilter extends Filter {
        public static class Factory implements typeinfo.Factory<AirFilter> {
            @Override
            public AirFilter create() {
                return new AirFilter();
            }
        }
    }

    static class CabinAirFilter extends Filter {
        public static class Factory implements typeinfo.Factory<CabinAirFilter> {
            @Override
            public CabinAirFilter create() {
                return new CabinAirFilter();
            }
        }
    }

    static class OilFilter extends Filter {
        public static class Factory implements typeinfo.Factory<OilFilter> {
            @Override
            public OilFilter create() {
                return new OilFilter();
            }
        }
    }

    static class Belt extends Part {}

    static class FanBelt extends Belt {
        public static class Factory implements typeinfo.Factory<FanBelt> {
            @Override
            public FanBelt create() {
                return null;
            }
        }
    }

    static class GeneratorBelt extends Belt {
        public static class Factory implements typeinfo.Factory<GeneratorBelt> {
            @Override
            public GeneratorBelt create() {
                return new GeneratorBelt();
            }
        }
    }

    static class PowerSteerinBelt extends Belt {
        public static class Factory implements typeinfo.Factory<PowerSteerinBelt> {
            @Override
            public PowerSteerinBelt create() {
                return new PowerSteerinBelt();
            }
        }
    }
}

