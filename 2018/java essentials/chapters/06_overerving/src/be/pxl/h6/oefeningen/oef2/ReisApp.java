package be.pxl.h6.oefeningen.oef2;

import java.io.PrintStream;

public class ReisApp {
    public static void main(String[] args) {
        PrintStream ps = System.out.format("%d\n", 5);
        System.out.println(ps);
        // treinrijzen
        TreinReis treinReis1 = new TreinReis("Antwerpen"); // inheritance: er wordt een klasse treinreis aangemaakt, deze klasse erft al de eingenschappen van de klasse Reis.
        TreinReis treinReis2 = new TreinReis("Gent", 12, true, "IR"); // constructor overloading, constructor zelfde naam maar andere parameters
        System.out.println("trein 1 datahiding: " + treinReis1.getPrijs()); // data-hiding. de instantievariabele is private en kan niet rechtstreekt aangeroepen worden. Moet een getter gebruiken
        System.out.println("trein1 " + treinReis1.toString());
        System.out.println("trein2 " + treinReis2.toString());
        System.out.println();
        // vliegtuigreis
        VliegtuigReis vliegtuigReis1 = new VliegtuigReis("Deinzen");
        VliegtuigReis vliegtuigReis2 = new VliegtuigReis("Luik", 20, "A17");
        System.out.println("vliegtuig1: " + vliegtuigReis1.toString());
        System.out.println("vliegtuig2: " + vliegtuigReis2.toString());
        System.out.println();
        // arrays treinreizen
        String[] arrayTreinReizen = {"Lissabon", "Ethiopie", "Amsterdam", "Londen", "Kreta", "Kuala Lampur"};
        int[] arrayPrijzen = {110, 100, 50, 70, 80, 60};
        boolean[] arrayNationaal = {true, true, true, false, false, false};
        String[] arraySpecificaties = {"IC", "IR", "L", "P", "IR", "L"};
        // arrays vliegtuigreizen
        String[] arrayVliegtuigReizen = {"Seattle", "Dublin", "Florida"};
        int[] arrayVliegtuigPrijzen = {150, 250, 350};
        String[] arrayVluchtnummers = {"AZ150", "B1245", "F0007"};
        // array reizen aanmaken en eigenschappen toevoegen
        Reis[] meerdereReizen = new Reis[arrayTreinReizen.length + arrayVliegtuigReizen.length]; // polymorfisme - er kunnen objecten van klasse Treinreis en klasse Vliegtuigreis aan deze array worden toegevoegd omdat ze tot dezelfde superklasse horen
        for (int i = 0; i < arrayTreinReizen.length; i++) { // treinreizen
            meerdereReizen[i] = new TreinReis(arrayTreinReizen[i], arrayPrijzen[i], arrayNationaal[i], arraySpecificaties[i]);
        }
        for (int i = 0; i < arrayVliegtuigReizen.length; i++) { // vliegtuigreizen
            meerdereReizen[i + arrayTreinReizen.length] = new VliegtuigReis(arrayVliegtuigReizen[i], arrayVliegtuigPrijzen[i], arrayVluchtnummers[i]);
        }
        // object geboekte reis aanmaken en objecten toevoegen
        GeboekteReis boeking = new GeboekteReis("Jochen Hansoul", meerdereReizen.length);
        for (int i = 0; i < meerdereReizen.length; i++) {
            boeking.voegReisToe(meerdereReizen[i]);
        }
        System.out.println();
        boeking.print();
    }
}
