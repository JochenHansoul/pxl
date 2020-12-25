package be.pxl.h1.voorbeelden;

import java.util.Scanner;

public class Opdracht6_begroeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef je voornaam in");
        String voornaam = input.next();
        System.out.println("Geef je achernaam in");
        String achternaam = input.next();
        String naam = voornaam + " " + achternaam;
        System.out.println("Hallo, je bent " + naam);
        input.close();
    }
}