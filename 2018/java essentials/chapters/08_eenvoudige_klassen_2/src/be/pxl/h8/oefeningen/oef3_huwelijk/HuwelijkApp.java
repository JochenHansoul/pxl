package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;
import java.util.ArrayList;

public class HuwelijkApp {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        System.out.println(String.valueOf(list));
        // persoon 1
        Person Jef = new Person();
        System.out.println("persoon 1: " + Jef.toString());
        String [] voornamen = new String[] {"Sloppie", "Wim", "Tim", "Ivan"};
        Jef.addFirstName(voornamen);
        System.out.println("persoon 1 na toevoeging voornamen: " + Jef.getFirstName());
        Jef.getAddress().setStreet("Draaistraat");
        Jef.getAddress().setNumber("2020A");
        Jef.getAddress().getTownship().setPostcode(100);
        Jef.getAddress().getTownship().setName("Wachtebeke");
        System.out.println("persoon 1 adres: " + Jef.getAddress());
        System.out.println();

        // persoon 2
        Person jochenHansoul = new Person(
                "Jochen",
                "Hansoul",
                LocalDate.of(1990, 5, 11),
                new Address(
                        new Township(3830, "wellen"),
                        "Langenakker",
                        "47b"));
        System.out.println("persoon 2: " + jochenHansoul.toString());
        jochenHansoul.setBirthDate(jochenHansoul.getBirthDate().withDayOfMonth(25));
        System.out.println("Geboortedatum persoon 2: " + jochenHansoul.getBirthDate().toString());
        System.out.println("Adres persoon 2: " + jochenHansoul.getAddress().toString());
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
