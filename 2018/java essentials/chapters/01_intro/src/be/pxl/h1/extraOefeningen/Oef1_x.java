package be.pxl.h1.extraOefeningen;

import java.util.Scanner;

public class Oef1_x {
    static void printAnX(String symbol, int size) {
        printAnX(symbol, size, " ");
    }

    static void printAnX(String symbol, int size, String padding) {
        int halfLength = size / 2;
        int firstPadding;
        int secondPadding = halfLength * 2;
        for (int currentLine = 0; currentLine < size; currentLine++) {
            firstPadding = (currentLine < halfLength) ? currentLine : currentLine - 2 * (currentLine - halfLength);
            System.out.print(padding.repeat(firstPadding) + symbol);
            // for uneven numbers the middle of the X the second symbol may not be printed
            if (currentLine < halfLength) {
                System.out.print(padding.repeat(secondPadding) + symbol);
                secondPadding -= 2;
            } else if (currentLine > halfLength) {
                secondPadding += 2;
                System.out.print(padding.repeat(secondPadding) + symbol);
            }
            System.out.println(); // must be out of if statement in case middle x (uneven rows) is printed
        }
    }

    public static void main(String[] args) {
        final int MIN_SIZE = 5;
        final int MAX_SIZE = 49;

        Scanner input = new Scanner(System.in);
        System.out.print("Geef een oneven getal in tussen " + MIN_SIZE + " en " + MAX_SIZE + ": ");
        int n = input.nextInt();
        while (n % 2 == 0 || n < MIN_SIZE || n > MAX_SIZE) {
            System.out.print("Geef een correct oneven getal in tussen " + MIN_SIZE + " en " + MAX_SIZE + ": ");
            n = input.nextInt();
        }
        printAnX("X", n);
        //printAnX("Z", 6, "a");
        input.close();
    }
}