package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.util.ArrayList;

public class HuwelijkApp {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        System.out.println(String.valueOf(list));
        // persoon 1
        Persoon Jef = new Persoon();
        System.out.println("persoon 1: " + Jef.toString());
        String [] voornamen = new String[] {"Sloppie", "Wim", "Tim", "Ivan"};
        Jef.voegVoornaamToe(voornamen);
        System.out.println("persoon 1 na toevoeging voornamen: " + Jef.getVoornaam());
        Jef.getAdress().setStraat("Draaistraat");
        Jef.getAdress().setHuisNummer("2020A");
        Jef.getAdress().getGemeente().setPostalCode(100);
        Jef.getAdress().getGemeente().setName("Wachtebeke");
        System.out.println("persoon 1 adres: " + Jef.getAdress());
        System.out.println();

        // persoon 2
        Persoon jochenHansoul = new Persoon("Hansoul", "Jochen", 1990, 5, 11, "Langenakker", "47b", 3830, "wellen");
        System.out.println("persoon 2: " + jochenHansoul.toString());
        jochenHansoul.setGeboortedatum(jochenHansoul.getGeboortedatum().withDayOfMonth(25));
        System.out.println("Geboortedatum persoon 2: " + jochenHansoul.getGeboortedatum().toString());
        System.out.println("Adres persoon 2: " + jochenHansoul.getAdress().toString());
        System.out.println();

        // huwelijk
        Huwelijk huwelijk1 = new Huwelijk(Jef, jochenHansoul, 2015, 6, 4);
        System.out.println("Het huwelijksjaar is " + huwelijk1.getHuwelijksdatum());
        System.out.println("Partner 1: " + huwelijk1.getPartner1());
        huwelijk1.adresWijziging("Lentestraat", "15C", 3500, "Hasselt");
        System.out.println();
        huwelijk1.print();
    }
}
