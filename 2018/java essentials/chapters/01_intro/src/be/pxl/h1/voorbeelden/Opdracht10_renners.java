package be.pxl.h1.voorbeelden;

import java.util.Scanner;

public class Opdracht10_renners {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef het inschrijvingsnummer in");
        int nummer = input.nextInt();
        int kleinsteTijd = 999999;
        int snelsteSpeler = 0;
        int teller = 0;
        int trageRenners = 0;
        while (nummer >= 0) {
            System.out.println("Geef de tijd in seconden in");
            int tijd = input.nextInt();
            if (tijd < kleinsteTijd) {
                snelsteSpeler = nummer;
                kleinsteTijd = tijd;
            }
            if (tijd > 3600) {
                trageRenners++;
            }
            System.out.println("Geef het inschrijvingsnummer in");
            nummer = input.nextInt();
            teller++;
        }

        System.out.print("De snelste renner is " + snelsteSpeler + " en het aantal renners dat er langer over heeft gedaan dan 1 uur is " + (double)trageRenners / teller * 100 + "%.");
        input.close();
    }
}
