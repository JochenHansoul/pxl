package be.pxl.h1.voorbeelden;

import java.util.Scanner;

public class Opdracht7_Fahrenheit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de temperatuur in C: ");
        int celsius = input.nextInt();
        double fahrenheit = ((double) 9 / 5) * celsius + 32; /* één getal afronden na de comma: 9 / 5 een int / int is altijd 1. (double) In de haakjes zetten OF 9.0 schrijven */
        double fahrenheitAfgerond = Math.round(fahrenheit * 10) / 10.0; /* een double gedeeld door in int mag niet! */
        System.out.println("De temperatuur in f is " + fahrenheitAfgerond);
        input.close();
    }
}