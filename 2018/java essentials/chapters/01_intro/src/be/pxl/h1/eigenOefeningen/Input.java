package be.pxl.h1.eigenOefeningen;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter string (next line):");
        String s = input.nextLine();
        System.out.println("enter int");
        int i = input.nextInt();
        System.out.println("enter string (next):");
        String s2 = input.next();
        System.out.println(s);
        System.out.println(s2);
        input.close();
    }
}
