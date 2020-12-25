package be.pxl.h7.oefeningen.exoef;

import java.util.Scanner;

public class TshirtApp_fout {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // alle soorten tshirten aanmaken
        Tshirt[] tshirts = new Tshirt[TShirtSize.values().length * Kleur.values().length];
        int teller = 0;
        for (TShirtSize s : TShirtSize.values()) {
            for (Kleur k : Kleur.values()) {
                tshirts[teller] = new Tshirt(s, k);
                teller++;
            }
        }
        // tsirts aantallen toevoegen
        String persoon;
        int borstomtrek;
        System.out.println("Geef een naam in");
        persoon = input.nextLine();
        while (!persoon.equals("stop") && !persoon.equals("Stop")) {
            System.out.println("Geef een borstomtrek in");
            borstomtrek = input.nextInt();
            String juisteMaat = "EXTRA_EXTRA_EXTRA_LARGE";
            teller = 0; // hergebruik van teller doorheen oefening
            for (TShirtSize s : TShirtSize.values()) {
                if (s.getBorstomtrek() >= borstomtrek) {
                    juisteMaat = s.name();
                    break;
                }
                teller++;
            }
            teller *= Kleur.values().length;
            System.out.println("De juiste maat is " + juisteMaat);
            System.out.println("Geef de gewenste kleur in (0 = rood, 1 = groen, 2 = blauw en 3 = wit)");
            int kleur = input.nextInt();
            System.out.println("geef het gewenste aantal in");
            int aantal = input.nextInt();
            tshirts[teller  + kleur].voegTShirtsToe(aantal);
            input.nextLine();
            System.out.println("Geef een naam in");
            persoon = input.nextLine();
        }
        // tshirts afprinten
        System.out.printf("%-8s%s\t%s\t%s\t%s\t%s\t%s\t%s", "", "XS", "S", "M", "L", "XL", "XXL", "3XL"); // bovenste rij
        teller = 0;
        for (Kleur k : Kleur.values()) { // onderste rijen
            System.out.printf("%n%-8s", k);
            teller = k.ordinal();
            for (TShirtSize s : TShirtSize.values()) {
                System.out.printf("%S\t", tshirts[teller].getHoeveelheid());
                teller += 4;
            }
            System.out.println();
        }
        // meeste kleur gekocht
        int laagste = 0;
        int hoogste = 0;
        String meesteKleur = "rood";
        for (Kleur k : Kleur.values()) {
            teller = k.ordinal();
            for (int j = 0; j < TShirtSize.values().length; j++) {
                laagste += tshirts[teller].getHoeveelheid();
                teller += 4;
            }
            if (laagste > hoogste) {
                meesteKleur = k.name();
                hoogste = laagste;
            }
        }
        System.out.println("Meest aantal kleuren is " + meesteKleur);
        // maat minst besteld
        hoogste = 999999; // hergebruik van vorige hoogste en laagste!
        teller = 0;
        String minstAantal = "";
        for (TShirtSize s : TShirtSize.values()) {
            laagste = 0;
            for (int i = 0; i < Kleur.values().length; i++) {
                laagste += tshirts[teller].getHoeveelheid();
                teller++;
            }
            //System.out.println("laagste nummer in lus " + laagste); // ter controle
            if (laagste < hoogste - 1) {
                //System.out.println("laatste nummer " + laagste + " en hoogste nummer " + hoogste); // ter controle
                minstAantal = s.name();
                hoogste = laagste;
                //System.out.println("laagste aantal " + minstAantal);
            }
        }
        System.out.println("De maat die het minst aantal besteld werd is " + minstAantal);
        input.close();
    }
}
