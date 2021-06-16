package be.jochenhansoul.varandvalues;

import java.util.List;
import java.util.ArrayList;

public class DifferenceValueReference {
    public static void main(String[] args) {
        int i = 1;
        Integer integer = 1;
        String s = "hello, world";
        List<String> list1 = new ArrayList<>();
        list1.add("word1");

        newValue(i);
        newValue(integer);
        newStringValue(s);

        // the reference inside the methods is changed but not the object
        System.out.println("int: " + i); // 1
        System.out.println("Integer: " + integer); // 1
        System.out.println("String: " + s);

        // the real difference: the object is changed by calling it's method
        System.out.println("List: " + list1);
        clearList(list1);
        System.out.println("List cleared: " + list1);
    }

    public static void newValue(Integer i) {
        i = 9;
    }

    public static void newStringValue(String s) {
        s = "goodbye, world";
    }

    public static void clearList(List<String> list) {
        list.clear();
    }
}
