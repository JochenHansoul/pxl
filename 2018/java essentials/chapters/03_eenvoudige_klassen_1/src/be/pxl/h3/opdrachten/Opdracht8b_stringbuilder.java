package be.pxl.h3.opdrachten;

import java.util.Scanner;

// controleer dat artikelcode bestaat uit 2 letters gevolgd door 2 cijfers
public class Opdracht8b_stringbuilder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een artikelcode in");
        String artikelCode = input.next();
        if (artikelCode.length() != 4) {
            System.out.println("Artikelcode bestaat niet uit 4 tekens");
        } else {
            char[] letter = new char[artikelCode.length()];
            for (int i = 0; i < artikelCode.length(); i++) {
                letter[i] = artikelCode.charAt(i);
            }
            if (Character.isLetter(letter[0]) && Character.isLetter(letter[1]) && Character.isDigit(letter[2]) && Character.isDigit(letter[3])) {
                System.out.println("artikelcode is oké");
                // eerste letter hoofdletter, 2e letter kleine letter
                StringBuilder hulp = new StringBuilder();
                hulp.append(Character.toUpperCase(letter[0]));
                hulp.append(Character.toLowerCase(letter[1]));
                hulp.append(letter[2] + "" + letter[3]); // lege spate tussen zetten anders teld het de ascii waarden op
                artikelCode = hulp.toString();
                System.out.println("nieuwe artikel " + artikelCode);
            } else {
                System.out.println("artikelcode is niet oké");
            }
        }
        input.close();
    }
}
