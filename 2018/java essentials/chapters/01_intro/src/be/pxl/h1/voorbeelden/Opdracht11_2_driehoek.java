package be.pxl.h1.voorbeelden;

import java.util.Scanner;

public class Opdracht11_2_driehoek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de grootte van de driehoek in");
        int grootte = input.nextInt();
        System.out.println("Geef de beginletter in");
        char letter = input.next().charAt(0); /* om van een string een character te maken */
        for (int i = 0; i < grootte; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char)letter + " "); /* geen println want anders beging het op een nieuwe lijn! */
                if (letter == 'Z') {
                    letter = 'A';
                } else {
                    letter++;
                }
            }
            System.out.println(); /* voor naar de volgende lijn te gaan */
        }
    }
}
