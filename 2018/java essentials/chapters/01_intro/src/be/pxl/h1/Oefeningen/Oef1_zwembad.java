package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef1_zwembad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Geef de lengte in: ");
        int lengte = input.nextInt();
        System.out.print("Geef de breedte in: ");
        int breedte = input.nextInt();
        System.out.print("Geef de hoogte in: ");
        int hoogte = input.nextInt();
        int volume = lengte * breedte * hoogte * 1000; // * 1000 om van m3 naar dm3 (liter) te gaan
        double ontsmettingsmiddel = volume / 50.0;
        System.out.println("het volume is " + Math.round(volume * 9.8) / 10
                + " liter en het aantal ontsmettingsmiddel dat toegevoegd moet worden is "
                + Math.round(ontsmettingsmiddel * 10) / 10.0 + " l.");
        input.close();
    }
}
