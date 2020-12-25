package be.pxl.h1.Oefeningen;

public class Oef3_kolommenc {
    public static void main(String[] args) {
        // kolom 1 - rechts uitgelijnd
        // kolom 2 - lings uitgelijnd
        // kolom 3 - rechts met voorloopnullen
        // kolom 4 - rechts met 3 decimalen
        int getal = 0;
        double getalPrint = 0;
        for (int i = 1; i < 10; i++) {
            getal = getal * 10 + i;
            if (i >= 6) {
                getalPrint = getal / Math.pow(10, i - 5);
            } else
                getalPrint = getal;
            System.out.printf("%20.6f\t\t%-21.6f", getalPrint, getalPrint); // printen kol1 en kol2
            System.out.printf("%020.6f", getalPrint); // print kol 3
            System.out.printf("%17.3f%n", getalPrint); // print kol 4, en volgende lijn
        }
    }
}