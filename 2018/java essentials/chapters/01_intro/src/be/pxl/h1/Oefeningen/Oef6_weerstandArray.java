package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef6_weerstandArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] weerstandArray = {"z","b", "r", "o", "g", "G", "B", "V", "L", "W"};
        System.out.println("Voer 3 waarstandstypen in:");
        String weerstand1 = input.next();
        String weerstand2 = input.next();
        String weerstand3 = input.next();
        int a = 0;
        int b = 0;
        int c = 0;
        int teller = 0;
        for (String n: weerstandArray) {
            if (n.equals(weerstand1)) {
                a = teller;
            }
            if (n.equals(weerstand2)) {
                b = teller;
            }
            if (n.equals(weerstand3)) {
                c = teller;
            }
            teller++;
        }
        System.out.println((10 * a + b) * Math.pow(10, c));
        input.close();
    }
}
