package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;

public class Persoon {
    private String naam;
    private String voornaam;
    private LocalDate geboortedatum;
    private Adress adress;

    // constructors
    public Persoon() {
        this("Aerts", "Jef", 21990, 11, 29, "Lindestraat", "23D", 3500, "Hasselt");
    }
    public Persoon(String naam, String voornaam, int jaar, int maand, int dag, String straat, String huisnummer, int postcode, String gemeente) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboortedatum = LocalDate.of(jaar, maand, dag);
        this.adress = new Adress(straat, huisnummer, postcode, gemeente);
    }

    // setters
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    public void setGeboortedatum(LocalDate date) {
        this.geboortedatum = date;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    // getters
    public String getNaam() {
        return naam;
    }
    public String getVoornaam() {
        return voornaam;
    }
    public Adress getAdress() {
        return adress;
    }
    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    // methoden
    public void voegVoornaamToe (String [] voornaam) {
        StringBuilder voornamen = new StringBuilder(); // moet met stringbuilder
        for (int i = 0; i < voornaam.length; i++) {
            voornamen.append(" " + voornaam[i]);
        }
        this.voornaam += voornamen;
    }
    public String toString() {
        return String.format("%s %s\n%s ", voornaam, naam, adress);
    }
}