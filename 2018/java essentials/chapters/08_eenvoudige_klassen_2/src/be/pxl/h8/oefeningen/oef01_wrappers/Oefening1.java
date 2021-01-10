package be.pxl.h8.oefeningen.oef01_wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Oefening1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // primitieve variabelen
        System.out.println("geef een karakter in");
        char karakter = input.nextLine().charAt(0);
        System.out.println("Geef een getal in");
        int getal = input.nextInt();
        System.out.println("geef een ander getal in");
        long langGetal = input.nextLong();
        System.out.println("geef een getal met decimalen in");
        double decimaalGetal = input.nextDouble();
        // wrappers
        Character wrapKarakter = karakter;
        Integer wrapGetal = getal;
        Long wrapLangGetal = langGetal;
        Double wrapDecimaalGetal = decimaalGetal;
        // array test
        ArrayList<Object> test = new ArrayList<>();
        test.add(karakter);
        test.add(getal);
        test.add(langGetal);
        test.add(decimaalGetal);
        for (Object o : test) {
            System.out.println(o);
        }
        Collections.shuffle(test);
        for (Object o : test) {
            printInfoAboutInstance(o);
        }
        input.close();
    }

    private static void printInfoAboutInstance(Object object) {
        if (object instanceof Character) {
            char c = (char) object;
            if (Character.isLetter(c)) {
                if (Character.isLowerCase((Character) object)) {
                    System.out.println(c +" is een kleine letter");
                } else {
                    System.out.println(c + " is een grote letter");
                }
            } else if (Character.isDigit(c)) {
                System.out.println(c + " is een nummer");
            } else {
                System.out.println( c +" is een onbekend karakter");
            }
        } else if (object instanceof Integer) {
            int i = (int) object;
            if (i > 0) {
                System.out.printf("%1$d is een int en de afstand tot het grootste getal is: %2$d%n",
                        i, Integer.MAX_VALUE - i);
            } else {
                System.out.printf("%1$d is een int en de afstand tot het kleinste getal is: %2$d%n",
                        i, i - Integer.MIN_VALUE);
            }
        } else if (object instanceof Long) {
            long l = (long) object;
            if (l > 0) {
                System.out.printf("%1$d is een long en de afstand tot het grootste getal is: %2$d %n",
                        l, Long.MAX_VALUE - l);
            } else {
                System.out.printf("%1$d is een long en de afstand tot het kleinste getal is: %d %n",
                        l - Long.MIN_VALUE);
            }
        } else if (object instanceof Double) {
            double d = (double) object;
            String[] array = Double.toString(d).split("\\.");
            System.out.printf("%1$f is een double en het aatal cijfers voor de komma is %2$d en na de komma is %3$d%n",
                    d, array[0].length(), array[1].length());
        }
    }
}
