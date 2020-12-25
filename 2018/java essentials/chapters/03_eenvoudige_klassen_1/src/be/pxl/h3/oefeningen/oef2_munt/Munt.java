package be.pxl.h3.oefeningen.oef2_munt;

public class Munt {
    public static final int AFRONDING = 3;
    private static int aantal;
    private String naam;
    private double koers;

    // constructors
    public Munt() {
        this("euro", 1);
    }

    public Munt(String naam, double koers) {
        this.naam = naam;
        this.koers = koers;
        aantal++;
    }

    // setters
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setKoers(double koers) {
        this.koers = koers;
    } // alternatief double in getter

    // getters
    public String getNaam() {
        return naam.toUpperCase();
    }

    public double getKoers() {
        return koers;
    }

    public static int getAantal() {
        return aantal;
    }
}