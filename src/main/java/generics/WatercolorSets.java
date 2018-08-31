package generics;


import java.util.EnumSet;
import java.util.Set;

import generics.Watercolors.Watercolors;

import static generics.Watercolors.Watercolors.BRILLLIANT_RED;
import static generics.Watercolors.Watercolors.BURNT_UMBER;
import static generics.Watercolors.Watercolors.CERULEAN_BLUE_HUE;
import static generics.Watercolors.Watercolors.VIRIDIAN_HUE;
import static net.mindview.util.Print.print;
import static net.mindview.util.Print.println;
import static net.mindview.util.Sets.complement;
import static net.mindview.util.Sets.difference;
import static net.mindview.util.Sets.intersection;
import static net.mindview.util.Sets.union;

/**
 * Created by jiguang on 2018/6/11.
 */

public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        println("set1: " + set1);
        println("set2: " + set2);
        println("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        println("intersection(set1, set2): " + subset);
        println("difference(set1, subset): " + difference(set1, subset));
        println("difference(set2, subset): " + difference(set2, subset));
        println("complement(set1, set2): " + complement(set1, set2));
    }
}
