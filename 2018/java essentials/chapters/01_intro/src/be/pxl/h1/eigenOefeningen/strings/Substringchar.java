package be.pxl.h1.eigenOefeningen.strings;

import java.util.Scanner;

public class Substringchar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef een code in");
        String code = input.nextLine();
        System.out.println(code.substring(0, 1));
        char kar = code.charAt(1);
        /*for (kar > 0 && kar < 3) {
            System.out.println(kar);
        }*/
        input.close();
    }
}
