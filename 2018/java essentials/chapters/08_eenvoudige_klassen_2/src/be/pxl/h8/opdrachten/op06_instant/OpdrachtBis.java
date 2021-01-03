package be.pxl.h8.opdrachten.op06_instant;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Opdracht6_classInstantBis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Instant voor = Instant.now();
        System.out.println("Geef je naam in");
        String naam = input.nextLine();
        System.out.println(naam);
        Instant na = Instant.now();
        // duur uitgedrukt metcijfers na de kommma
        System.out.println("naam ingegeven + afprinten " + ChronoUnit.MILLIS.between(voor, na) / 1000.0 + " seconden");
        input.close();
    }
}
