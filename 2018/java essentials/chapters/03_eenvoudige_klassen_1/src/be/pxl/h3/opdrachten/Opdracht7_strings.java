package be.pxl.h3.opdrachten;

import java.util.Scanner;

public class Opdracht7_strings {
    public static void main(String[] args) {
        // lees een zin in
        Scanner input = new Scanner(System.in);
        System.out.println("geef een zin in");
        String zin = input.next();
        System.out.println("de zin is " + zin + " lengte: " + zin.length());
        // b. vervangen de eltters 'a' door de letter 'o'
        zin = zin.replace('a', 'o');
        System.out.println("de nieuwe zin " + zin);
        // c. tel het aantal letters e
        int tel = 0;
        int positie = zin.indexOf('e');
        while (positie != -1) {
            tel++;
            positie = zin.indexOf('e', positie + 1);
        }
        System.out.println("het aantal letters e " + tel);
        // de middelste, of de twee middelste leetters uppercase maken
        // even (2 letters) substringen en in 2 kappen
        // d. vergelijk de inhoud van 2 Strings
        String tekst1 = "1TINC";
        String tekst2 = "1tinc";
        System.out.println("Hebben de 2 strings dezelfde inhoud " + tekst1.equals(tekst2));
        // e. middelste of 2 middelste letters in hoofdletters
        System.out.println("geef een woord in");
        String woord = input.next();
        int lengte = woord.length();
        int midden = lengte / 2;
        int middenU = midden + 1;
        if (lengte % 2 == 0) { // even aantal tekens
            midden -= 1;
        }
        String deel1 = woord.substring(0, midden);
        String deel2 = woord.substring(midden, middenU).toUpperCase(); // middelste deel uppercase
        String deel3 = woord.substring(middenU);
        woord = deel1 + deel2 + deel3;
        System.out.println("het woord is " + woord);
        input.close();
    }
}
