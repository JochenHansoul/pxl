package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;

public class MarriageApp {
    public static void main(String[] args) {
        // person 1
        Person Jef = new Person();
        System.out.println("persoon 1: " + Jef.toString());
        Jef.addFirstName(new String[] {"Sloppie", "Wim", "Tim", "Ivan"});
        System.out.println("persoon 1 na toevoeging voornamen: " + Jef.getFirstName());
        Jef.getAddress().setStreet("Draaistraat");
        Jef.getAddress().setNumber("2020A");
        Jef.getAddress().getTownship().setPostcode(100);
        Jef.getAddress().getTownship().setName("Wachtebeke");
        System.out.println("persoon 1 adres: " + Jef.getAddress());
        System.out.println();

        // person 2
        Person jochenHansoul = new Person(
                "Jochen",
                "Hansoul",
                LocalDate.of(1990, 5, 11),
                new Address("Langenakker", "47b",  3830, "wellen"));
        System.out.println("persoon 2: " + jochenHansoul.toString());
        jochenHansoul.setBirthDate(jochenHansoul.getBirthDate().withDayOfMonth(25));
        System.out.println("Geboortedatum persoon 2: " + jochenHansoul.getBirthDate().toString());
        System.out.println("Adres persoon 2: " + jochenHansoul.getAddress().toString());
        System.out.println();

        // marriage
        Marriage marriage = new Marriage(Jef, jochenHansoul, LocalDate.of(2015, 6, 4));
        System.out.println("Het huwelijksjaar is " + marriage.getDate());
        System.out.println("Partner 1: " + marriage.getFirstPartner());
        marriage.addressAdjustment(new Address("Lentestraat", "15C", 3500, "Hasselt"));
        System.out.println();
        marriage.print();
    }
}
