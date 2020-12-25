package be.pxl.h2.oefeningen.oef1_persoon;

import java.util.Scanner;

public class PersoonApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Persoon persoon = new Persoon();
        System.out.println("naam: " + persoon.getVoornaam() + " " + persoon.getNaam());
        System.out.println();
        // setten
        persoon.setVoornaam("Jochen");
        persoon.setNaam("Hansoul");
        persoon.setLengte(2.4);
        persoon.setGewicht(58);
        persoon.setGeboortejaar(1990);
        // printen persoon
        System.out.println(persoon.toString());
        System.out.println();
        // methoden
        System.out.println("BMI \t\t\t:" + persoon.geefOmschrijving()); // BMI
        // meerdere voornamen invoeren
        String [] arrayVoornamen = new String[4];
        System.out.println("Geef een naam in");
        arrayVoornamen[0] = input.nextLine();
        for (int i = 1; i < arrayVoornamen.length; i++) {
            System.out.println("Geef een naam in");
            arrayVoornamen[i] = input.nextLine();
        }
        persoon.voegVoornaamToe(arrayVoornamen);
        System.out.println(persoon.getVoornaam());
        // leeftijd berekenen
        System.out.println("De leeftijd is " + persoon.getLeeftijd());
        persoon.groei(); // groeien
        System.out.println("De lengte van persoon + groei is " + persoon.getLengte());
        System.out.println();
        // persoon 2
        Persoon persoon2 = new Persoon("Dries", "Achten");
        persoon2.setLengte(1.8);
        persoon2.setGewicht(58);
        System.out.println("De naam is: " + persoon2.getVoornaam() + " " + persoon2.getNaam());
        System.out.println("De lengte is " + persoon2.getLengte());
        System.out.println("Het gewicht is " + persoon2.getGewicht());
        System.out.println("Het geboordejaar is " + persoon2.getGeboortejaar());
        System.out.println();
        // persoon3
        Persoon persoon3 = new Persoon(persoon2);
        System.out.println(persoon3.getVoornaam() + " " + persoon3.getNaam());
        System.out.println("De lengte " + persoon3.getLengte());
        System.out.println("Het gewicht " + persoon3.getGewicht());
        System.out.println("Het geboortejaar " + persoon3.getGeboortejaar());
        input.close();
    }
}
