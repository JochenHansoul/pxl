package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef4_bedragPersoneel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef het personeelsnummer in");
        int nummer = input.nextInt();
        int eersteNummer = Integer.parseInt(Integer.toString(nummer).substring(0, 1));
        int i = "string".length();
        System.out.println(i);
        int bedrag = 1;
        int vast = 2500;
        double loon = 0;
        int teller = 0;
        int meerDan75000 = 0;
        while (eersteNummer < 9) {
            System.out.println("Geef het bedrag van vorig jaar in");
            bedrag = input.nextInt();
            if (bedrag < 50000) {
                loon = vast + bedrag * 0.05;
            } else if (bedrag < 75000) {
                loon = vast + bedrag * 0.1;
            } else {
                loon = vast + bedrag * 0.15;
                meerDan75000++;
            }
            System.out.printf("Het personeelsnummer is %04d, het verkochte bedrag is %d en het loon is %.0f.%n%n", nummer, bedrag, loon);
            teller++;
            System.out.println("Geef het personeelsnummer in");
            nummer = input.nextInt();
            eersteNummer = Integer.parseInt(Integer.toString(nummer).substring(0, 1));
        }
        System.out.println("Aantal personeelsleden meer dan 75 000 verdient: " + (double)meerDan75000 / teller * 100 + "%");
        input.close();
    }
}