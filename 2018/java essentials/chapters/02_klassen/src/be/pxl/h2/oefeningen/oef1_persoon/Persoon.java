package be.pxl.h2.oefeningen.oef1_persoon;

public class Persoon {
    private String voornaam;
    private String naam;
    private double lengte;
    private int gewicht;
    private int geboortejaar;

    // constructors
    public Persoon () { // default constructor
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
    public String toString () {
        return String.format("Deze persoon is %s %s%nGewicht\t\t\t:%d%nLengte\t\t\t:%s%nGeboortejaar\t:%s%n", voornaam, naam, gewicht, lengte, getGeboortejaar());
    }

    public void voegVoornaamToe (String [] voornaam) {
        for (int i = 0; i < voornaam.length; i++) {
            this.voornaam += " " + voornaam[i];
        }
    }

    public double berekenBmi () {
        return Math.round(gewicht / Math.pow(lengte,2) * 100) / 100.0; // Math.bov(x,2) kwadraat berekenen
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
}