package typeinfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/**
 * Created by jiguang on 2018/5/25.
 */

public class ClassInfo {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: name of class");
            System.exit(0);
        }
        Class<?> c = null;
        try {
            c = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
        System.out.println("c: " + c);
        System.out.println("c.getAnnotations(): ");
        if (c.getAnnotations().length == 0) {
            System.out.println("none");
        }
        for (Annotation a : c.getAnnotations()) {
            System.out.println(a);
        }
        System.out.println("c.getCanonicalName(): " + c.getCanonicalName());
        System.out.println("c.getClasses(): ");
        if (c.getClasses().length == 0) {
            System.out.println("none");
        }
        for (Class c1 : c.getClasses()) {
            System.out.println(c1);
        }
        System.out.println("c.getClassLoader(): " + c.getClassLoader());
        System.out.println("c.getConstructors(): ");
        if (c.getConstructors().length == 0) {
            System.out.println("none");
        }
        for (Constructor ctor : c.getConstructors()) {
            System.out.println(ctor);
        }
        System.out.println("c.getDeclareAnnotations(): ");
        if (c.getDeclaredAnnotations().length == 0) {
            System.out.println("none");
        }
        for (Annotation a : c.getDeclaredAnnotations()) {
            System.out.println(a);
        }
        System.out.println("c.getDeclaredClasses(): ");
        if (c.getDeclaredClasses().length == 0) {
            System.out.println("none");
        }
        for (Class c1 : c.getDeclaredClasses()) {
            System.out.println(c1);
        }
        System.out.println("c.getDeclaredCons");
    }
}
