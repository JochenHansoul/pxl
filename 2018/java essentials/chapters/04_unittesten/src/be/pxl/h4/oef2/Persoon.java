package be.pxl.h4.oef2;

import static java.lang.Character.isUpperCase;

public class Persoon {
    private String voornaam;
    private String naam;
    private double lengte;
    private double gewicht;
    private int geboortejaar;
    // constructors
    public Persoon() {
        this("onbekend", "onbekend");
    }
    public Persoon(String naam, String voornaam) {
        setVoornaam(voornaam);
        setNaam(naam);
    }
    public Persoon(Persoon persoon) { // voor een object aan te maken gebaseerd op een ander object
        this(persoon.naam, persoon.voornaam); // andere constructor oproepen steeds op eerste rij!!!
        lengte = persoon.lengte;
        gewicht = persoon.gewicht;
        geboortejaar = persoon.geboortejaar;
    }
    // setters
    public void setVoornaam (String voornaam){
        this.voornaam = voornaam;
    }
    public void setNaam (String naam) {
        this.naam = naam;
    }
    public void setLengte (double lengteSet) {
        if (lengteSet > 2.4) {
            lengteSet = 2.4;
        }
        lengte = lengteSet;
    }
    public void setGewicht (int gewicht) {
        this.gewicht = gewicht;
    }
    public  void setGeboortejaar (int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }
    // getters
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
    public int getGeboortejaar () {
        return geboortejaar;
    }
    public double getLeeftijd () {
        return  2017 - geboortejaar;
    }
    // methoden
    public void voegVoornamenToe (String [] voornaam) {
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
        lengte += 0.01;
        setLengte(lengte);
    }
    public void groei(double gegroeid) {
        lengte += gegroeid / 100;
        setLengte(lengte);
    }
    public String toString() {
        StringBuilder tekst = new StringBuilder("Deze persoon is " + voornaam.toUpperCase() + " " + naam.toUpperCase() + "\n");
        tekst.append(String.format("%-15s : %.2f%n", "gewicht", gewicht));
        tekst.append(String.format("%-15s : %.2f%n", "lengte", lengte));
        tekst.append(String.format("%-15s : %d%n", "geboortejaar", geboortejaar));
        return  tekst.toString();
    }
    public String geefNaamAfgekort() {
        StringBuilder afgekorteNaam = new StringBuilder();
        afgekorteNaam.append(Character.toUpperCase(voornaam.charAt(0)));
        afgekorteNaam.append(".");
        afgekorteNaam.append(Character.toUpperCase(naam.charAt(0)));
        afgekorteNaam.append(naam.substring(1));
        return afgekorteNaam.toString();
    }
    public String geefInitiaal() {
        if (!Character.isLetter(this.naam.charAt(0))) {
            naam = this.naam.substring(1);
            naam = naam.replace(" ", "");
        } else {
            naam = this.naam;
        }
        StringBuilder initialen = new StringBuilder();
        initialen.append(naam.substring(0, 2));
        initialen.append(voornaam.substring(0, 2));
        if (isUpperCase(naam.charAt(0))) {
            return initialen.toString().toUpperCase();
        } else {
            return initialen.toString().toLowerCase();
        }
    }
    public String encrypteerNaam(int getal) {
        naam = geefNaamAfgekort();
        StringBuilder geencrypteerdeNaam = new StringBuilder();
        for (int i = 0; i < naam.length(); i++) {
            geencrypteerdeNaam.append((char) (naam.charAt(i) + getal));
        }
        return geencrypteerdeNaam.toString();
    }
}
