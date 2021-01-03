package be.pxl.h8.opdrachten.op03_faculteit;

import java.math.BigInteger;
import java.util.Scanner;

public class Opdracht3_faculteit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef een getal in");
        int getal = input.nextInt();
        BigInteger faculteitBig = BigInteger.ONE; // zet 1 in faculteitBig
        //BigInteger bi1 = new BigInteger("1");
        //BigInteger bi2 = BigInteger.valueOf(5);
        for (int i = 2; i <= getal; i++) { // starten van 1 heeft geen zin dus kan net zo goed starten van 2
            faculteitBig = faculteitBig.multiply(new BigInteger("" + i)); // kan overfloaten, kijkt of de eerste bit een 0 of 1 is en zet de overige getallen in int -> BigInteger gebruiken
        }
        System.out.println("berekende faculteit = " + faculteitBig);
        input.close();
    }
}
