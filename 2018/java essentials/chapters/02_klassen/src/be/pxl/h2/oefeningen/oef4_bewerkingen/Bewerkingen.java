package be.pxl.h2.oefeningen.oef4_bewerkingen;

import java.util.Arrays;
import java.util.Scanner;

public class Bewerkingen {
    Scanner input;
    public String trekAf(double getal1, double getal2) {
        if (getal2 < 0) {
            return getal1 + " + " + getal2 + " = " + (Math.round((getal1 - getal2) * 100) / 100.0);
        } else {
            return getal1 + " - " + getal2 + " = " + (Math.round((getal1 - getal2) * 100) / 100.0);
        }
    }
    public String trekAf(int getal1, int getal2) {
        if (getal2 < 0) {
            return getal1 + " + " + getal2 + " = " + (getal1 - getal2);
        } else {
            return getal1 + " - " + getal2 + " = " + (getal1 - getal2);
        }
    }
    public String telOp(double getal1, double getal2) {

        if (getal2 < 0) {
            return getal1 + " - " + getal2 + " = " + (Math.round((getal1 + getal2) * 100) / 100.0);
        } else {
            return getal1 + " + " + getal2 + " = " + (Math.round((getal1 + getal2) * 100) / 100.0);
        }
    }
    public String telOp (double[] arrayGetallen) {
        StringBuilder getallenrij = new StringBuilder(arrayGetallen[0] + "");
        for (int i = 1; i < arrayGetallen.length; i++) {
            if (arrayGetallen[i] < 0) {
                getallenrij.append(" - ");
            } else {
                getallenrij.append(" + ");
            }
            getallenrij.append(arrayGetallen[i]);
        }
        return getallenrij.toString() + Math.round(Arrays.stream(arrayGetallen).sum() * 100) / 100.0;
    }
    public String deel (int getal1, int getal2, Scanner input) { // is Scanner input de bedoeling?
        while (getal2 == 0) {
            System.out.println("Geef een getal anders dan 0 in");
            getal2 = input.nextInt();
        }
        return getal1 + " / " + getal2 + " = " + Math.round((getal1 * 100) / getal2) / 100.0;
    }
    public String faculteit(int getal, Scanner keyboard) {
        while (getal < 0) {
            System.out.println("Het getal kan niet kleiner zijn dan 0, geef een nieuw getal in");
            getal = input.nextInt();
        }
        if (getal == 0) {
            return "0";
        } else {
            StringBuilder faculteit = new StringBuilder("1");
            long result = 1;
            for (int i = 2; i < getal + 1; i++) {
                faculteit.append(" x " + i);
                result *= i;
            }
            return faculteit.toString() + " = " + result;
        }
    }
}
