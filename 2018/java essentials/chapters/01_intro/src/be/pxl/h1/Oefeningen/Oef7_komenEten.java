package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef7_komenEten {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef het aantal kandidaten in:");
        int kandidaten = input.nextInt();
        String [][] arrayKandidaten = new String[kandidaten][2];
        for (int i = 0; i < kandidaten; i++) { // namen ingeven
            System.out.println("Geef de naam van kandidaat nr " + (i + 1) + " in");
            arrayKandidaten[i][0] = input.next(); // niet nextline !!!
        }
        int score;
        int hoogsteScore = 0;
        String winnaar = "naam";
        String welkePunten = "sfeer";
        for (int i = 0; i < arrayKandidaten.length; i++) {
            int totaleScore = 0;
            for (int j = 0; j < arrayKandidaten.length * 2; j++) {
                System.out.println("Geef de punten voor " + welkePunten + " in:");
                score = input.nextInt();
                while (score < 0 || score > 10) {
                    System.out.println("Ongeldige punten!");
                    score = input.nextInt();
                }
                totaleScore += score;
                if (welkePunten.equals("sfeer")) {
                    welkePunten = "eten";
                } else {
                    welkePunten = "sfeer";
                }
            }
            if (totaleScore > hoogsteScore) {
                hoogsteScore = totaleScore;
                winnaar = arrayKandidaten[i][0];
            }
            arrayKandidaten[i][1] += String.valueOf(totaleScore); // meer envoudig om gewoon "" + totale score; te doen
        }
        for (int i = 0; i < arrayKandidaten.length; i++) {
            System.out.printf("%s = %s\n", arrayKandidaten[i][0], arrayKandidaten[i][1]);
        }
        System.out.println("Winnaar: " + winnaar);
        input.close();
    }
}
