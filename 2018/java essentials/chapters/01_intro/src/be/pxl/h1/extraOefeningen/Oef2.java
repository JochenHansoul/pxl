package be.pxl.h1.extraOefeningen;

import java.util.Scanner;

public class Oef2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de begintijd in seconden in");
        int tijd = input.nextInt();
        for (int i = 1; i < 31; i++) {
            if (i <= 15) {
                tijd -= tijd * ((5 - (i - 1) / 3) * 1.0) / 100 ;
            } else if (i > 18) {
                tijd += tijd * 0.02;
            }
            System.out.printf("jaar %d : %d seconden\n", i, tijd);
        }
        input.close();
    }
}
