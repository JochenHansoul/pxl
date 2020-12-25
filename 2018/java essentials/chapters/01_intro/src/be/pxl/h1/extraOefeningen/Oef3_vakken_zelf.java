package be.pxl.h1.extraOefeningen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oef3_vakken_zelf {
    private static void printArrayValuesNotInList(String[] array, List<String> list) {
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i])) {
                System.out.printf("nr %s: %s\n", i + 1, array[i]);
            }
        }
    }

    public static void main(String[] args) {
        final String[] TEACHERS = new String[] {"Nys", "Thans", "Custers", "Lambrechts", "Vanherwegen"};
        final String [] COURSES = new String[] {"IT Essentials", "Java", "data", "C#", "Cisko"};

        Scanner input = new Scanner(System.in);
        ArrayList<String> selectedTeachers = new ArrayList<>();
        for (String course : COURSES) {
            System.out.println("Opleidingsonderdeel: " + course);
            printArrayValuesNotInList(TEACHERS, selectedTeachers); // prints the available teaches
            System.out.printf("Geef het nr. voor de lector die u voor het olod %s kiest: ", course);
            int n = input.nextInt() - 1;
            while (n < 0 || n >= TEACHERS.length || selectedTeachers.contains(TEACHERS[n])) {
                System.out.print("Gelieve een geldig nummer in te geven: ");
                n = input.nextInt() - 1;
            }
            selectedTeachers.add(TEACHERS[n]);
            System.out.println();
        }
        System.out.println("Overzicht olod - lector:");
        for (int i = 0; i < COURSES.length; i++) {
            System.out.printf("%-17s%s\n", COURSES[i], selectedTeachers.get(i)); //-17 richt pad 17 spaties
        }
        input.close();
    }
}