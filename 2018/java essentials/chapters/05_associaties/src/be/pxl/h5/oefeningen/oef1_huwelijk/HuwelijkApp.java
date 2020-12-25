package be.pxl.h5.oefeningen.oef1_huwelijk;

public class HuwelijkApp {
    public static void main(String[] args) {
        // persoon 1
        Persoon Jef = new Persoon();
        System.out.println("persoon 1: " + Jef.toString());
        String [] voornamen = new String[] {"Sloppie", "Wim", "Tim", "Ivan"};
        Jef.voegVoornaamToe(voornamen);
        System.out.println("persoon 1 na toevoeging voornamen: " + Jef.getVoornaam());
        Jef.getAdress().setStraat("Draaistraat");
        Jef.getAdress().setHuisNummer("2020A");
        Jef.getAdress().getGemeente().setPostcode(100);
        Jef.getAdress().getGemeente().setGemeenteNaam("Wachtebeke");
        System.out.println("persoon 1 adres: " + Jef.getAdress());
        System.out.println();
        // persoon 2
        Persoon jochenHansoul = new Persoon("Hansoul", "Jochen", 11, 5, 1990, "Langenakker", "47b", 3830, "wellen");
        System.out.println("persoon 2: " + jochenHansoul.toString());
        jochenHansoul.getGeboortedatum().setDag(25);
        System.out.println("Geboortedatum persoon 2: " + jochenHansoul.getGeboortedatum().toString());
        System.out.println("Adres persoon 2: " + jochenHansoul.getAdress().toString());
        System.out.println();
        // huwelijk
        Huwelijk huwelijk1 = new Huwelijk(Jef, jochenHansoul, 4, 6, 2015);
        System.out.println("Het huwelijksjaar is " + huwelijk1.getHuwelijksdatum());
        System.out.println("Partner 1: " + huwelijk1.getPartner1());
        huwelijk1.adresWijziging("Lentestraat", "15C", 3500, "Hasselt");
        System.out.println();
        huwelijk1.print();
    }
}
