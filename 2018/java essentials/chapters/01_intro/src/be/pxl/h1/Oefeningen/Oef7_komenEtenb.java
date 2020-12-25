package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef7_komenEtenb {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef het aantal kandidaten in:");
        int kandidaten = input.nextInt();
        input.nextLine(); // hier een input.nextLine invoegen voor de int invoer te stoppen
        String [][] arrayKandidaten = new String[kandidaten][2];
        String [] tekst = {"SFEER", "ETEN"};
        for (int i = 0; i < kandidaten; i++) { // namen ingeven
            System.out.println("Geef de naam van kandidaat nr " + (i + 1) + " in");
            arrayKandidaten[i][0] = input.nextLine(); // niet nextline, slaat eerste naam over !!!
        }
        int score;
        int hoogsteScore = 0;
        String winnaar = "naam";
        String welkePunten = "sfeer";
        for (int i = 0; i < arrayKandidaten.length; i++) {
            System.out.println("punten voor " + arrayKandidaten[i][0]);
            int totaleScore = 0;
            for (int j = 0; j < arrayKandidaten.length; j++){
                if (i != j) {
                    for (String t: tekst) { // if (i != j)
                        System.out.println(arrayKandidaten[j][0] + " Geef uw punten voor " + t + ":");
                        score = input.nextInt();
                        while (score < 0 || score > 10) {
                            System.out.println("Ongeldige punten!");
                            score = input.nextInt();
                        }
                        totaleScore += score;
                    }
                    if (totaleScore > hoogsteScore) {
                        hoogsteScore = totaleScore;
                        winnaar = arrayKandidaten[i][0];
                    }
                    arrayKandidaten[i][1] += "" + totaleScore; // om naar een string om te zetten
                }
            }
        }
        for (int i = 0; i < arrayKandidaten.length; i++) {
            System.out.printf("%s = %s\n", arrayKandidaten[i][0], arrayKandidaten[i][1]);
            }
        System.out.println("Winnaar: " + winnaar);
        input.close();
    }
}
