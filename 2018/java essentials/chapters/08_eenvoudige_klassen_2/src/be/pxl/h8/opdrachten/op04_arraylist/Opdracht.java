package be.pxl.h8.opdrachten.op04_arraylist;

import java.util.ArrayList;

public class Opdracht {
    public static void main(String[] args) {
        // opdracht1
        ArrayList <String> test = new ArrayList<String>();
        // opdracht2 voeg 3 strings object"en toe
        String voorbeeld1 = "element 1";
        String voorbeeld2 = "element 2";
        String voorbeeld3 = "element 3";
        test.add(voorbeeld1);
        test.add(voorbeeld2);
        test.add(voorbeeld3);
        test.add(1, "element 4");
        System.out.println("eerste afdruk");
        for (String s : test) { // for each
            System.out.println(s);
        }
        //opdracht 3 element 4 => aangepast element 4
        test.set(1, "aangepast element 4");
        System.out.println("tweede afdruk"); // geen for each
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        // opdracht 4 => juist gewijzigd element verwijderen
        test.remove(1); // wordt verwijderd en alles daarna schuift een rij terug
        System.out.println("derde afdruk");
        for (String s: test) {
            System.out.println(s);
        }
        // opdracht 5 op welke plaats komt het object voorbeeld2
        System.out.println("voorbeeld2 komt op plaats " + test.indexOf(voorbeeld2));
        System.out.println("String met test element3 komt op plaats " + test.indexOf("element 3"));
        // opdracht 6 verwijder alle elementen uit de lijst
        test.clear();
        System.out.println("aantal objecten in de arraylist " + test.size());
    }
}
