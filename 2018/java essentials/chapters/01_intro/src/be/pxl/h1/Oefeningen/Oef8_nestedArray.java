package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef8_nestedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = new int[4][3];
        for (int i = 0; i <  array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Geef de waarde van rij " + (i  + 1) + " kolom " + (j + 1) + " in:");
                array[i][j] = input.nextInt();
            }
        }
        // printen
        for (int j = 0; j < array[j].length; j++) {
            int som = 0;
            for (int i = 0; i < array.length; i++) {
                som += array[i][j];
            }
            System.out.println("De som van komom " + (j + 1) + " is " + som);
        }
        input.close();
    }
}
