package be.pxl.h1.Oefeningen;

public class Oef3_kolommen {
    public static void main(String[] args) {
        // kolom 1
        for (int a = 1; a < 10; a++) {
            for (int c = 9; c > a; c--) {
                System.out.print(" ");
            }
            for (int b = 1; b <= a; b++) {
                System.out.print(b);
            }
            System.out.println(".000000");
        }
        System.out.println();
        // kolom 2
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(".000000");
        }
        System.out.println();
        // kolom 3
        for (int a = 1; a < 10; a++) {
            for (int c = 9; c > a; c--) {
                System.out.print(0);
            }
            for (int b = 1; b <= a; b++) {
                System.out.print(b);
            }
            System.out.println(".000000");
        }
        // kolom 4
    }
}