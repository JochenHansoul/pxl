package be.pxl.h5.oefeningen.oef1_huwelijk;

public class Persoon {
    private String naam;
    private String voornaam;
    private Datum geboortedatum;
    private Adress adress;

    // constructors
    public Persoon() {
        this("Aerts", "Jef", 29, 11, 1990, "Lindestraat", "23D", 3500, "Hasselt");
    }
    public Persoon(String naam, String voornaam, int geboortedag, int geboortemaand, int geboortejaar, String straat, String huisnummer, int postcode, String gemeente) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboortedatum = new Datum(geboortedag, geboortemaand, geboortejaar);
        this.adress = new Adress(straat, huisnummer, postcode, gemeente);
    }

    // setters
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
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
    public Datum getGeboortedatum() {
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