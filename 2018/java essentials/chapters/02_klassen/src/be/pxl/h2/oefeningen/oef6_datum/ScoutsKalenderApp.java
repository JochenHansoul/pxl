package be.pxl.h2.oefeningen.oef6_datum;

import java.util.Scanner;

public class ScoutsKalenderApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] arrayDatums = new String[12];
        String[] activiteiten = new String[12];
        System.out.println("geef het maandnr in");
        int maand = input.nextInt();
        System.out.println("geef het jaar in");
        int jaar = input.nextInt();
        System.out.println("geef een dag in");
        int dag = input.nextInt();
        int teller = 0;
        while (dag != 0) {
            System.out.println("geef de activiteit in");
            String activitiet = input.next();
            arrayDatums[teller] = dag + "/" + maand + "/" + jaar;
            activiteiten[teller] = activitiet;
            System.out.println("geef een dag in");
            dag = input.nextInt();
            teller++;
        }
        Datum testDatum = new Datum(arrayDatums[0]);
        System.out.println("**** kalender voor " + testDatum.getMaandNaam() + " " + jaar + " ****");
        for (int i = 0; i < teller; i++) {
            Datum datum = new Datum(arrayDatums[i]);
            System.out.printf("%s %20s\n", datum.toString(), activiteiten[i]);
        }
        input.close();
    }
}
