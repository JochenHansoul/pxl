package be.pxl.h7.oefeningen.oef2;

import java.util.*;

public class KaartApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        // 52 verschillende kaarten aanmaken
        Kaart[] kaarten = new Kaart[52];
        int teller = 0;
        for (Ranking waarde : Ranking.values()) {
            for (Soort soort : Soort.values()) {
                kaarten[teller] = new Kaart(waarde, soort);
                teller++;
            }
        }
        Collections.shuffle(Arrays.asList(kaarten)); // de kaarten schudden
        // computer en persoon een kaart laten kiezen
        int randomComputer = 0;
        int randomPersoon = 0;
        boolean gelijk = true;
        while (gelijk) {
            randomComputer = rand.nextInt(52);
            System.out.println("geef een random getal in tussen 1 en 52");
            randomPersoon = input.nextInt();
            while (randomPersoon < 1 || randomPersoon > 52 || randomPersoon - 1 == randomComputer) {
                System.out.println("Geef een ander getal in");
                randomPersoon = input.nextInt();
            }
            randomPersoon--;
            if (kaarten[randomComputer].getranking().ordinal() != kaarten[randomPersoon].getranking().ordinal()) {
                gelijk = false;
            } else {
                System.out.println("gelijkspel, trek opnieuw een kaart");
            }
        }
        // winnaar of verliezer bepalen en afdrukken
        if (kaarten[randomComputer].getranking().ordinal() > kaarten[randomPersoon].getranking().ordinal()) {
            System.out.println("Winnaar computer met " + kaarten[randomComputer].getKaart());
            System.out.println("verliezer speler met " + kaarten[randomPersoon].getKaart());
        } else {
            System.out.println("Winner speler met " + kaarten[randomPersoon].getKaart());
            System.out.println("verliezer computer met " + kaarten[randomComputer].getKaart());
        }
        input.close();
    }
}
