package be.pxl.h1.extraOefeningen;

import java.util.Scanner;

public class Oef1b_x {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een oneven getal in tussen 5 en 49");
        int getal = input.nextInt();
        while (getal < 5 || getal > 49 && getal % 2 == 0) {
            System.out.println("Geef een correct oneven getal in tussen 5 en 49");
            getal = input.nextInt();
        }
        System.out.println();
        int gemiddelde = getal / 2;
        int tweedeSpaties = gemiddelde * 2;
        for (int i = 0; i < getal; i++){
            if (i < gemiddelde) {
                System.out.format("%sX%sX", " ".repeat(i), " ".repeat(tweedeSpaties)); // bovenste deel afprinten
                tweedeSpaties -= 2;
            } else if ( i == gemiddelde){
                System.out.printf("%sX", " ".repeat(gemiddelde)); // middelste deel afprinten
            } else {
                tweedeSpaties += 2;
                System.out.format("%sX%sX", " ".repeat(i - 2 * (i - gemiddelde)), " ".repeat(tweedeSpaties)); // onderste deel afprinten
            }
            System.out.println();
        }
        input.close();
    }
}