package be.pxl.h1.Oefeningen;

public class Oef3_kolommenb {
    public static void main(String[] args) {
        // kolom 1 - rechts uitgelijnd
        // kolom 2 - lings uitgelijnd
        // kolom 3 - rechts met voorloopnullen
        // kolom 4 - rechts met 3 decimalen
        double getal = 0;
        int aantalNullen = 9;
        for (int i = 1; i < 10; i++) {
            for (int j = 9; j > i; j--) { // kol 1 - spaties voor zetten
                System.out.print(" ");
            }
            getal += i;
            System.out.printf("%.6f \t %.6f", getal, getal); // printen kol1 en kol2
            for (int j = 9; j > i; j--) { // kol 2 - spaties achter zetten
                System.out.print(" ");
            }
            System.out.printf("\t" + "0".repeat(aantalNullen) + "%.6f \t", getal); // printen kol 3
            for (int j = 9; j > i; j--) { // kol 4 - spaties voor zetten
                System.out.print(" ");
            }
            System.out.printf("%.3f", getal); // printen kol 4
            System.out.println(); // naar volgende lijn
            // berekeningen
            aantalNullen--;
            getal *= 10;
        }
    }
}
