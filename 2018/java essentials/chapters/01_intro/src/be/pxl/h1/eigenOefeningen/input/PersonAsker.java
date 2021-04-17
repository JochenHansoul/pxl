package be.pxl.h1.eigenOefeningen.input;

import java.util.Scanner;

public class PersonAsker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter fist and last name:");
        String firstName = input.next();
        String lastName = input.next(); // dit werkt maar wat als de naam uit meerdere delen bestaat (Otto Jan Ham)
        System.out.println("enter age:");
        int age = input.nextInt();
        System.out.printf("name: %s %s, age: %d\n", firstName, lastName, age);
        input.close();
    }
}