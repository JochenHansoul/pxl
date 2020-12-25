package be.pxl.h1.voorbeelden;

import java.util.Scanner;

public class Opdracht9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef de leeftijd in ");
        int leeftijd = input.nextInt();
        System.out.println("Geef het aansluitingsjaarin ");
        int aansluitingsJaar = input.nextInt();
        double lidgeld = 100;
        if (leeftijd < 21 || leeftijd > 60) {
            lidgeld -= 14.5;
        }
        lidgeld -= (2018 - aansluitingsJaar) * 2.5;
        if (lidgeld < 62.5) {
            lidgeld = 62.5;
        }
        System.out.println("Het lidgeld bedraagd " + lidgeld);
        input.close();
    }
}
