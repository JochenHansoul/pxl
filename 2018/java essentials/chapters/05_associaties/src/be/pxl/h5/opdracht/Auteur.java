package be.pxl.h5.opdracht;

public class Auteur {
    private String naam;
    private String voornaam;
    // setters
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    // getters
    public String getNaam() {
        return naam;
    }
    public String getVoornaam() {
        return voornaam;
    }
    // methodes
    public String toString() {
        return voornaam + " " + naam;
    }
}
