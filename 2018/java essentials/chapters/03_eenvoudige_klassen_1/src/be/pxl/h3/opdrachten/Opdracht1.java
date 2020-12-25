package be.pxl.h3.opdrachten;
// x^3 berekenen

import java.util.Scanner;

public class Opdracht1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef een geheel getal in");
        int x = input.nextInt();
        int y = (int) Math.pow(x, 3);
        System.out.println("het resulaat is " + y);
        input.close();
    }
}
