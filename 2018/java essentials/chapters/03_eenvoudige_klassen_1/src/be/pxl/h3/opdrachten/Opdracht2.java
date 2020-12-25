package be.pxl.h3.opdrachten;
// bereken de diameter van een cirkel bij een gegeven opp

import java.util.Scanner;

public class Opdracht2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef de oppervlakte van de cirkel in");
        double oppervlakte = input.nextDouble();
        double r = Math.sqrt(oppervlakte / Math.PI);
        double diameter = Math.round(2 * r * 100) / 100.0; // de .0 niet vergeten voor double te maken!
        System.out.println("de diameter is " + diameter);
        input.close();
    }
}
