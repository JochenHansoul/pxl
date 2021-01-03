package be.pxl.h8.opdrachten.op01_bitsAndBytes;

import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een getal in");
        String waarde1 = input.next(); // je kan hier ook een verkeerde waarde ingeven zoals 4.3 -> runtime error
        System.out.println("Geef een volgend getal in");
        String waarde2 = input.next();
        // opdracht2
        Integer objectWaarde1 = Integer.parseInt(waarde1); // new Intiger(waarde1)
        // opdracht3
        objectWaarde1 += Integer.parseInt(waarde2);
        System.out.println(objectWaarde1);
        // opdracht4 => aantal bits, is een constante dus CAPITAL LETTERS
        System.out.println("aantal bits " + Integer.SIZE);
        // opdracht5 => aantal bytes
        System.out.println("aantal bytes " + Integer.BYTES);
        input.close();
    }
}
