package typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jiguang on 2018/5/31.
 */

public class SnowRemovalRobot implements Robot {
    private String name;
    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public String model() {
        return "SnowBot Series 11";
    }

    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can shovel snow";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " shoveling snow");
                    }
                }, new Operation() {
                    @Override
                    public String description() {
                        return name + " can chip ice";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " chipping ice");
                    }
                }, new Operation() {
                    @Override
                    public String description() {
                        return name + " can clear the roof";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " clearing roof");
                    }
                }
        );
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
