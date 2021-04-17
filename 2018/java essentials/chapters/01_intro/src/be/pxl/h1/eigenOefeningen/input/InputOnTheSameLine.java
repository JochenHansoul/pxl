package be.pxl.h1.eigenOefeningen.input;

import java.util.Scanner;

public class InputOnTheSameLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter first name, last name and age: ");
        String firstName = input.next();
        String lastName = input.next();
        int age = input.nextInt();
        System.out.printf("%s %s, age %d", firstName, lastName, age);
    }
}