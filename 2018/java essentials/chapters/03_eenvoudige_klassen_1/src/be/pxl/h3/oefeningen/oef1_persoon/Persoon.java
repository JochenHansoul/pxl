package be.pxl.h3.oefeningen.oef1_persoon;

import java.util.Scanner;

import static java.lang.Character.isUpperCase;

public class Persoon {
    private String voornaam;
    private String naam;
    private double lengte;
    private int gewicht;
    private int geboortejaar;

    // constructors
    public Persoon () {
        /*voornaam = "onbekend";
        naam = "onbekend";*/
        this("onbekend", "onbekend");
    }
    public Persoon (String voornaam, String naam) {
        setVoornaam(voornaam);
        setNaam(naam);
    }
    public Persoon (Persoon persoon) { // voor een object aan te maken gebaseerd op een ander object
        this(persoon.voornaam, persoon.naam); // andere constructor oproepen steeds op eerste rij!!!
        lengte = persoon.lengte;
        gewicht = persoon.gewicht;
        geboortejaar = persoon.geboortejaar;
    }
    // setters
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
    public String getGeboortejaar () {
        return String.valueOf(geboortejaar);
    }
    public double getLeeftijd () {
        return  2018 - geboortejaar;
    }
    // methoden
    public void voegVoornaamToe (String [] voornaam) {
        StringBuilder meerdereVoornamen = new StringBuilder();
        for (int i = 0; i < voornaam.length; i++) {
            meerdereVoornamen.append(" " + voornaam[i]);
        }
        this.voornaam = this.voornaam + meerdereVoornamen;
    }
    public double berekenbmi () { // berekenbmi met kleine letters, codeconventies
        return Math.round(gewicht / Math.pow(lengte,2) * 10) / 10.0; // Math.pow(x,2) kwadraat berekenen
    }
    public String geefOmschrijving () {
        double BMI = berekenbmi();
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
    public String toString() {
        StringBuilder volledigeNaam = new StringBuilder();
        volledigeNaam.append(Character.toUpperCase(voornaam.charAt(0)));
        volledigeNaam.append(voornaam.substring(1));
        volledigeNaam.append(" ");
        volledigeNaam.append(Character.toUpperCase(naam.charAt(0)));
        volledigeNaam.append(naam.substring(1));
        return String.format("Deze persoon is %s%nGewicht\t\t\t:%d%nLengte\t\t\t:%s%nGeboortejaar\t:%s%n", volledigeNaam.toString(), gewicht, lengte, geboortejaar);
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
    public String encrypteerNaam(int getal, Scanner keyboard) {
        while (getal < 1 || getal > 20) {
            System.out.println("Geef een getal groter of gelijk aan 1 en kleiner of gelijk aan 20 in");
            getal = keyboard.nextInt();
        }
        naam = geefNaamAfgekort();
        StringBuilder geencrypteerdeNaam = new StringBuilder();
        for (int i = 0; i < naam.length(); i++) {
            geencrypteerdeNaam.append((char) (naam.charAt(i) + getal));
        }
        return geencrypteerdeNaam.toString();
    }
}
