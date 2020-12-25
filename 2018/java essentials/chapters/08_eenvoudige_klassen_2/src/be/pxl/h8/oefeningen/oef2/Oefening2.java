package be.pxl.h8.oefeningen.oef2;

import java.util.ArrayList;
import java.util.Scanner;

public class Oefening2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int aantal;
        int minimum = 1;
        int maximum = 0;
        String[] arrayWaarden = {"0", "1", "2"};
        String drieWaarden = "";
        System.out.println("Geef het aantal getallen, de minimumwaarde en de maximumwaarde in");
        input.nextLine();
        while (minimum < maximum) {
            arrayWaarden = drieWaarden.split(" ");
            minimum = Integer.parseInt(arrayWaarden[1]);
            maximum = Integer.parseInt(arrayWaarden[2]);
        }
        aantal = Integer.parseInt(arrayWaarden[0]);
        ArrayList<Integer> waarden = new ArrayList<Integer>();
        for (int i = 0; i < aantal; i++) {

        }
        input.close();
    }
}