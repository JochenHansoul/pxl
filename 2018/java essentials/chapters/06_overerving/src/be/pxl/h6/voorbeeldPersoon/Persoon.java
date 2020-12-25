package be.pxl.h6.voorbeeldPersoon;

public class Persoon {
    private static int aantal = 0; // opdracht 7
    private String naam;
    private String voornaam;

    // constructors
    public Persoon() {
        aantal++;
    }
    public Persoon(String naam, String voornaam) {
        this.naam = naam;
        this.voornaam = voornaam;
        aantal++;
    }

    // setters
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    // getters
    public static int getAantal() {
        return aantal;
    }
    public String getNaam() {
        return naam;
    }
    public String getVoornaam() {
        return voornaam;
    }

    // methoden
    public void print() {
        System.out.println("naam " + getNaam());
        System.out.println("voornaam " + getVoornaam());
    }
}