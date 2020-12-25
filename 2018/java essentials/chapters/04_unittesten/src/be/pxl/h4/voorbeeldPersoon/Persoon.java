package be.pxl.h4.voorbeeldPersoon;

public class Persoon {
    private String voornaam;
    private String naam;
    private double lengte;
    private int gewicht;
    private int geboortejaar;
    // constructors
    public Persoon() {
        voornaam = "onbeken";
        naam = "onbekend";
    }
    public Persoon(String naam, String voornaam) {
        setVoornaam(voornaam);
        setNaam(naam);
    }
    public Persoon(Persoon persoon) { // voor een object aan te maken gebaseerd op een ander object
        this(persoon.voornaam, persoon.naam); // andere constructor oproepen steeds op eerste rij!!!
        lengte = persoon.lengte;
        gewicht = persoon.gewicht;
        geboortejaar = persoon.geboortejaar;
    }
    // setter - methoden
    public void setVoornaam (String voornaamSet){
        voornaam = voornaamSet;
    }
    public void setNaam (String naamSet) {
        naam = naamSet;
    }
    public void setLengte (double lengteSet) {
        if (lengteSet > 2.4) {
            lengteSet = 2.4;
        }
        lengte = lengteSet;
    }
    public void setGewicht (int gewichtSet) {
        gewicht = gewichtSet;
    }
    public  void setGeboortejaar (int geboortejaarSet) {
        geboortejaar = geboortejaarSet;
    }
    // methoden
    public void voegVoornaamToe (String [] voornaam) {
        StringBuilder meerdereVoornamen = new StringBuilder();
        for (int i = 0; i < voornaam.length; i++) {
            meerdereVoornamen.append(" ");
            meerdereVoornamen.append(voornaam[i]);
        }
        this.voornaam = this.voornaam + meerdereVoornamen;
    }
    public double berekenBmi () {
        return Math.round(gewicht / Math.pow(lengte,2) * 10) / 10.0; // Math.pow(x,2) kwadraat berekenen
    }
    public String geefOmschrijving () {
        double BMI = berekenBmi();
        if (BMI < 18) {
            return "ondergewicht";
        } else if (BMI < 25) {
            return  "normaal";
        } else  if (BMI < 30) {
            return  "overgewicht";
        } else if (BMI < 40) {
            return "obesitas";
        } else {
            return "morbide obesitas";
        }
    }
    public void groei() {
        lengte += 0.1;
        setLengte(lengte);
    }
    public void groei(double gegroeid) {
        lengte += gegroeid / 10;
        setLengte(lengte);
    }
    public String geefNaamAfgekort() {
        StringBuilder afgekorteNaam = new StringBuilder();
        afgekorteNaam.append(Character.toUpperCase(voornaam.charAt(0)));
        afgekorteNaam.append(".");
        afgekorteNaam.append(Character.toUpperCase(naam.charAt(0)));
        afgekorteNaam.append(naam.substring(1));
        return afgekorteNaam.toString();
    }
    // getter - methoden
    public String getVoornaam () {
        return voornaam;
    }
    public String getNaam () {
        return naam;
    }
    public double getLengte () {
        return lengte;
    }
    public double getGewicht () {
        return gewicht;
    }
    public String getGeboortejaar () {
        return String.valueOf(geboortejaar);
    }
    public String toString () {
        StringBuilder volledigeNaam = new StringBuilder();
        volledigeNaam.append(Character.toUpperCase(voornaam.charAt(0)));
        volledigeNaam.append(voornaam.substring(1));
        volledigeNaam.append(" ");
        volledigeNaam.append(Character.toUpperCase(naam.charAt(0)));
        volledigeNaam.append(naam.substring(1));
        return volledigeNaam.toString() + "\nGewicht\t\t\t:" + gewicht + "\nLengte\t\t\t:" + lengte + "\nGeboortejaar\t:" + getGeboortejaar();
    }
    public String getVolledigeNaam() {
        StringBuilder volledigeNaam = new StringBuilder();
        volledigeNaam.append(vraagtekenIndienNull(voornaam));
        volledigeNaam.append(" ");
        volledigeNaam.append(vraagtekenIndienNull(naam));
        return volledigeNaam.toString();
    }
    private String vraagtekenIndienNull(String naam) {
        if (naam == null) {
            return "?";
        }
        return naam;
    }
    public double getLeeftijd () {
        return  2018 - geboortejaar;
    }
}
