package be.pxl.h5.oefeningen.oef2_pxl;

import java.util.Scanner;

public class PXLApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // arrays voor vakken aanmaken
        String codeArray[] = {"41TIN1100", "41TIN1130", "41TIN1140",
                "41TIN1180", "41TIN1230", "41TIN1240", "41TIN1280",
                "41TIN1300","42TIN1220", "42TIN1230", "43AON3120", "43AON3130"};
        String[] naamArray = {"Web Essentials", "Java Essentials", ".Net Essentials",
                "Business flow Essentials", "Cisco Academy: CCNA", "Os Essentials",
                "Communication skills 1","It Essentials", ".Net Advanced", "Java Advanced", "Programming Expert", "Mobile development"};
        int[] studiepuntenArray = {3, 6, 6, 3, 3, 6, 6, 6, 3, 3, 3, 3};
        Vak[] vakken = new Vak[codeArray.length];
        // arrays voor leraren aanmaken
        String[] namen = {"Herrewegen", "Achten", "Sam"};
        String[] voornamen = {"Ingrid", "Sam", "Dries"};
        int[] aanstelling = {100, 70, 90};
        Leraar[] leraars = new Leraar[namen.length];
        // eigenschappen aan vakken toevoegen
        for (int i = 0; i < codeArray.length; i++) {
            vakken[i] = new Vak(codeArray[i], naamArray[i], studiepuntenArray[i]);
        }
        int[] vakkenToegewezen = new int[codeArray.length]; // array voor selectie vakken
        int teller = 0;
        int nogToeTeWijzenVakken = codeArray.length;
        // begin van lus voor vakken aan leraren toe te voegen
        for (int i = 0; i < namen.length; i++) {
            leraars[i] = new Leraar(namen[i], voornamen[i], aanstelling[i]);
            System.out.println("Leraar " + (i + 1) + ": " + leraars[i].getNaam() + " " + leraars[i].getAanstellingsPercentage() + "%");
            System.out.println("Geef in hoeveel vakken u wilt ingeven");
            int aantalVakken = input.nextInt();
            while (aantalVakken >  Leraar.MAXIMUM_AANTALVAKKEN || aantalVakken > nogToeTeWijzenVakken) {
                System.out.println("U heeft te veel vakken ingegeven, voer een lager getal in");
                aantalVakken = input.nextInt();
            }
            nogToeTeWijzenVakken -= aantalVakken;
            System.out.println();
            for (int j = 0; j < aantalVakken; j++) { // lus voor vakken in te geven
                for (int k = 1; k < codeArray.length + 1; k++) { // voor vakken op te vragen
                    if (vakkenToegewezen[0] != k && vakkenToegewezen[1] != k && vakkenToegewezen[2] != k && vakkenToegewezen[3] 
                            != k && vakkenToegewezen[4] != k && vakkenToegewezen[5] != k && vakkenToegewezen[6] != k && vakkenToegewezen[7] 
                            != k && vakkenToegewezen[8] != k && vakkenToegewezen[9] != k && vakkenToegewezen[10] != k && vakkenToegewezen[11] != k) { // enkel niet ingevoerde vakken afprinten
                        System.out.println((k ) + " " + vakken[k - 1].toString());
                    }
                }
                System.out.println();
                System.out.println("Geef een getal in");
                int welkVak = input.nextInt();
                while (welkVak == vakkenToegewezen[0] || welkVak == vakkenToegewezen[1] || welkVak == vakkenToegewezen[2] || welkVak == vakkenToegewezen[3] 
                        || welkVak == vakkenToegewezen[4] || welkVak == vakkenToegewezen[5] || welkVak == vakkenToegewezen[6] || welkVak == vakkenToegewezen[7] 
                        || welkVak == vakkenToegewezen[8] || welkVak == vakkenToegewezen[9] || welkVak == vakkenToegewezen[10] || welkVak == vakkenToegewezen[11]) { // controle of ingevoerde getal correct is
                    System.out.println("Geef een getal dat nog niet ingegeven is");
                    System.out.println(vakkenToegewezen[j]);
                    welkVak = input.nextInt();
                }
                System.out.println();
                leraars[i].voegVakToe(vakken[welkVak - 1]);
                vakkenToegewezen[teller] = welkVak;
                teller++;
            }
        }
        // afprinten leraren
        System.out.println();
        for (int i = 0; i < namen.length; i++) {
            leraars[i].print();
            System.out.println();
        }
        input.close();
    }
}
