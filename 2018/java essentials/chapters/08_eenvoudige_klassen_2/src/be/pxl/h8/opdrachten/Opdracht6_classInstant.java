package be.pxl.h8.opdrachten;

import java.time.Instant;
import java.util.Scanner;

public class Opdracht6_dayOfWeak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Instant voor = Instant.now();
        System.out.println("Geef je naam in");
        String naam = input.nextLine();
        System.out.println(naam);
        Instant na = Instant.now();
        int duur = (int) (na.getEpochSecond() - voor.getEpochSecond()); // om het verschil tussen de twee tijdstippen te bekomen.
        System.out.println("naam ingegeven + afprinten " + duur + " seconden");
        input.close();
    }
}
