package be.pxl.h6.oefeningen.oef3;

import be.pxl.h6.voorbeeldPersoon.Persoon;

public class Sporter extends Persoon {
    private String omschrijving;
    private static int teller;
    // constructors
    public Sporter(String naam, String voornaam) {
        this(naam, voornaam, "onbepaald");

    }
    public Sporter(String naam, String voornaam, String omschrijving) {
        setNaam(naam);
        setVoornaam(voornaam);
        this.omschrijving = omschrijving;
        teller++;
    }
    // setter
    public void setSport(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    // getters
    public static int getTeller() {
        return teller;
    }
    // methoden
    public void print() {
        System.out.println(getVoornaam() + " " + getNaam());
        System.out.println(omschrijving);
    }
}
