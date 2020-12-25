package be.pxl.h7.oefeningen.oef1;

import java.util.Scanner;

public class MuntApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef een bedrag in in euro in");
        double bedrag = input.nextDouble(); // werkt niet op decimale getallen
        System.out.println(bedrag);
        while (bedrag < 0.0 || bedrag > 10.0) {
            System.out.println("Geef een bedrag tussen 0 en 10 euro in");
            bedrag = input.nextDouble();
        }
        int intBedrag = (int) (Math.round(bedrag * 100));
        // berekend kleinste aantan munten
        for (Munt munt : Munt.values()) {
            /*int teller = 0;
            while (intBedrag >= munt.getWaarde()) {
                intBedrag -= munt.getWaarde();
                teller++;
            }
            if (teller > 0) {
                System.out.println(munt + ": " + teller);
            }*/
            int teller = intBedrag / munt.getWaarde();
            intBedrag %= munt.getWaarde();
            if (teller > 0) {
                System.out.println(munt + ": " + teller);
            }
        }
        input.close();
    }
}