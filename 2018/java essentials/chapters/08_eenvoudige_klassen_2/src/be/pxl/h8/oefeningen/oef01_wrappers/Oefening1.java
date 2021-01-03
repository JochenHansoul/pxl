package be.pxl.h8.oefeningen.oef1_wrappers;

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
        Double wrapDedimaalGetal = decimaalGetal;
        // array test
        ArrayList<Object> test = new ArrayList<>();
        test.add(wrapKarakter);
        test.add(wrapGetal);
        test.add(wrapLangGetal);
        test.add(wrapDedimaalGetal);
        System.out.println("long compare: " + Long.compare(wrapLangGetal, 0));
        for (Object o : test) {
            System.out.print(o);
            // character
            if (o instanceof Character) {
                if (Character.isLetter((Character) o)) {
                    if (Character.isLowerCase((Character)o)){
                        System.out.println(" is een kleine letter");
                    } else {
                        System.out.println(" is een grote letter");
                    }
                }
            } else if (o instanceof Integer) {
                System.out.println(" is een integer en de afstand tot het grootste is " + (Integer.MAX_VALUE - (Integer) o));
            } else if (o instanceof Long) {
                System.out.print(" is een long en de afstand tot het kleinste is ");
                if (Long.compare((Long) o, 0) > 0) {
                    System.out.println(Long.MAX_VALUE - (Long) o);
                } else {
                    System.out.println((Long) o - Long.MIN_VALUE);
                }
            } else if (o instanceof Double) {
                System.out.println(" is een double en het aantal cijfers na de komma is "
                        + (o.toString().length() - o.toString().indexOf(".") - 1)
                        + " en voor de komma is " + o.toString().indexOf("."));
            }
            // iets anders
        }
        Collections.shuffle(test);
        input.close();
    }
}
