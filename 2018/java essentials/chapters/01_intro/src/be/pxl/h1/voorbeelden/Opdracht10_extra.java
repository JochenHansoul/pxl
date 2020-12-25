package be.pxl.h1.voorbeelden;

import java.util.Scanner;

public class Opdracht10_extra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een getal in tussen 0 en 10");
        int getal = input.nextInt();
        while (getal < 0 || getal > 10) {
            System.out.println("Fout, Geef het getal tussen 0 en 10 opnieuw in");
            getal = input.nextInt(); /* int moet niet opnieuw gedefinieerd worden */
        }
        input.close();
    }
}
