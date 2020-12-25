package be.pxl.h3.oefeningen.oef1_persoon;

import java.util.Scanner;

public class PersoonApp {
    public static void main(String[] args) {
        java.util.Random rand = new java.util.Random();
        Scanner input = new Scanner(System.in);
        Persoon persoon = new Persoon();
        System.out.println("naam: " + persoon.getVoornaam() + " " + persoon.getNaam());
        System.out.println();
        // setten
        persoon.setVoornaam("Jochen");
        persoon.setNaam("Hansoul");
        persoon.setLengte(Math.round(rand.nextInt(52) + 158) / 100.0);
        persoon.setGewicht(rand.nextInt(61) + 40);
        persoon.setGeboortejaar(1990);
        // printen persoon
        System.out.println(persoon.toString());
        System.out.println("initialen: " + persoon.geefInitiaal());
        System.out.println("geëncrypteerde naam: " + persoon.encrypteerNaam(rand.nextInt(20) + 1, input));
        input.close();
    }
}