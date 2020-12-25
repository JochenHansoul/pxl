package be.pxl.h7.oefeningen.exoef;

import java.util.Scanner;

public class TshirtApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // alle soorten tshirten aanmaken
        Tshirt[][] tshirts = new Tshirt[Kleur.values().length][TShirtSize.values().length];
        for (Kleur k : Kleur.values()) {
            for (TShirtSize s : TShirtSize.values()) {
                tshirts[k.ordinal()][s.ordinal()] = new Tshirt(s, k);
            }
        }
        // tsirts aantallen toevoegen
        int teller;
        String persoon;
        int borstomtrek;
        System.out.println("Geef een naam in");
        persoon = input.nextLine();
        while (!persoon.equals("stop") && !persoon.equals("Stop")) {
            System.out.println("Geef een borstomtrek in");
            borstomtrek = input.nextInt();
            String juisteMaat = "Maat overschreden";
            teller = 0;
            for (TShirtSize s : TShirtSize.values()) { // juiste maat bepalen
                if (s.getBorstomtrek() >= borstomtrek) {
                    juisteMaat = s.name();
                    break;
                }
                teller++;
            }
            System.out.println("De juiste maat is " + juisteMaat);
            System.out.println("Geef de gewenste kleur in (0 = rood, 1 = groen, 2 = blauw en 3 = wit)");
            int kleur = input.nextInt();
            System.out.println("geef het gewenste aantal in");
            int aantal = input.nextInt();
            tshirts[kleur][teller].voegTShirtsToe(aantal);
            input.nextLine();
            System.out.println("Geef een naam in");
            persoon = input.nextLine();
        }
        // tshirts afprinten
        System.out.printf("%-8s%s\t%s\t%s\t%s\t%s\t%s\t%s", "", "XS", "S", "M", "L", "XL", "XXL", "3XL"); // bovenste rij
        for (Kleur k : Kleur.values()) { // onderste rijen
            System.out.printf("%n%-8s", k);
            teller = k.ordinal();
            for (TShirtSize s : TShirtSize.values()) {
                System.out.printf("%S\t", tshirts[k.ordinal()][s.ordinal()].getHoeveelheid());
            }
            System.out.println();
        }
        // meeste kleur gekocht
        int laagste = 0;
        int hoogste = 0;
        String meesteKleur = "rood";
        for (Kleur k : Kleur.values()) {
            for (int j = 0; j < TShirtSize.values().length; j++) {
                laagste += tshirts[k.ordinal()][j].getHoeveelheid();
            }
            if (laagste > hoogste) {
                meesteKleur = k.name();
                hoogste = laagste;
            }
        }
        System.out.println("Meest aantal kleuren is " + meesteKleur);
        // maat minst besteld
        // hergebruik van variabele "laatste"!
        int minste = 999999;
        String minstAantal = "";
        for (TShirtSize s : TShirtSize.values()) {
            laagste = 0;
            for (int i = 0; i < Kleur.values().length; i++) {
                laagste += tshirts[i][s.ordinal()].getHoeveelheid();
            }
            if (laagste < minste) {
                minstAantal = s.name();
                minste = laagste;
            }
        }
        System.out.println("De maat die het minst aantal besteld werd is " + minstAantal);
        input.close();
    }
    private static void tshirtTabelAfprinten() {

    }
}
