package be.pxl.h2.oefeningen.oef4_bewerkingen;

import java.util.Scanner;

public class BewerkingenApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bewerkingen aftrekken2 = new Bewerkingen();
        System.out.println(aftrekken2.trekAf(210.5, 100.53));
        Bewerkingen aftrekken1 = new Bewerkingen();
        System.out.println(aftrekken1.trekAf(5, 2));
        Bewerkingen som1 = new Bewerkingen();
        System.out.println(som1.telOp(5.5, 3.7));
        Bewerkingen somReeks = new Bewerkingen();
        double[] getallenArray = new double[] {1, 2, 5, 7, 10};
        System.out.println(somReeks.telOp(getallenArray));
        Bewerkingen deling1 = new Bewerkingen();
        System.out.println(deling1.deel(7, 0, input));
        Bewerkingen faculteit1 = new Bewerkingen();
        System.out.println(faculteit1.faculteit(15, input));
        input.close();
    }
}
