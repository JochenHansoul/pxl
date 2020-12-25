package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef2_voetballers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de naam in ");
        String naam = input.nextLine();
        System.out.println("Geef de Prijs van het vorige seizoen in");
        int prijs = input.nextInt();
        System.out.println("Geef de leeftijd in");
        int leeftijd = input.nextInt();
        System.out.println("Geef de gemiddelde beoordeling in, 0 - 10");
        int beoordeling = input.nextInt();
        input.nextLine();
        System.out.println("Geef het type speler in, Aanvaller, Middenverder, Verdediger, Doelman");
        String typeSpeler = input.nextLine();
        System.out.println("Geef het aantal doelpunten gescoord of vermeden");
        int doelpunten = input.nextInt();
        double basisprijs = prijs;
        if (leeftijd <= 25) {
            basisprijs *= 1.1;
        }  else if (leeftijd >= 30) {
            basisprijs *= 0.95;
        }
        if (typeSpeler.equals("Aanvaller")) {
            if (doelpunten <= 5) {
                basisprijs += (doelpunten * 10000);
            }
            else {
                basisprijs += 50000 + (doelpunten - 5) * 20000;
            }
        } else {
            basisprijs += beoordeling * 10000;
            if (typeSpeler.equals("Doelman")) {
                if (doelpunten > 20) {
                    basisprijs -= 9000;
                }
            }
        }
        System.out.println(naam + "prijs vorig seizoen: " + prijs + ", nieuwe prijs: " + basisprijs);
        input.close();
    }
}
