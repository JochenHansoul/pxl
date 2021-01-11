package be.pxl.h8.oefeningen.oef3_huwelijk;

public class Adress {
    private String straat;
    private String huisNummer;
    private Township gemeente;

    // constructors
    public Adress(String straat, String huisNummer,int postcode, String gemeenteNaam) {
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.gemeente = new Township(postcode, gemeenteNaam);
    }

    // setters
    public void setStraat(String straat) {
        this.straat = straat;
    }
    public void setHuisNummer(String huisNummer) {
        this.huisNummer = huisNummer;
    }

    // getters
    public String getStraat() {
        return straat;
    }
    public String getHuisNummer() {
        return huisNummer;
    }
    public Township getGemeente() {
        return gemeente;
    }

    // methode
    public String toString() {
        return String.format("%s %s\n %s", straat, huisNummer, gemeente);
    }
}
