package be.pxl.h1.extraOefeningen;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Oef3_vakkenLeerkrachten {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] teachers = new String[] {"Nys", "Thans", "Custers", "Lambrechts", "Vanherwegen"};
        String [][] courses = new String[][] {
                {"IT Essentials", ""},
                {"Java", ""},
                {"data", ""},
                {"C#", ""},
                {"Cisko", ""}
        };
        int [] numbers = new int[] {-1, -1, -1, -1};
        for (int i = 0; i < courses.length - 1; i++) {
            System.out.printf("opleidingsonderdeel %d :%s\n", (i + 1), courses[i][0]);
            for (int j = 0; j < courses.length; j++) {
                if (j != numbers[0] && j != numbers[1] && j != numbers[2] && j != numbers[3]) {
                    System.out.printf("nr %d. %s\n", (j + 1), teachers[j]);
                }
            }
            System.out.print("geef het nr voor de lector die u voor het olod kiest");
            numbers[i] = (input.nextInt() - 1);
            courses[i][1] = teachers[numbers[i]];
            System.out.println();
        }
        courses[4][1] = teachers[10 - IntStream.of(numbers).sum()];
        System.out.println("overzicht olod - lector");
        for (int k = 0; k < courses.length; k++) {
            System.out.printf("%-17s%s\n", courses[k][0], courses[k][1]);
        }
        input.close();
    }
}