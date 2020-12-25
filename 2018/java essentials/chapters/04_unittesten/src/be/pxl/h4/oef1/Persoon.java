package be.pxl.h4.oef1;

public class Persoon {
    private String voornaam;
    private String naam;
    private double lengte;
    private int gewicht;
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
        this(persoon.naam, persoon.voornaam);
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

    public void setLengte (double lengte) {
        if (lengte > 2.4) {
            lengte = 2.4;
        }
        this.lengte = lengte;
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

    public int getLeeftijd () {
        return  2018 - geboortejaar;
    }

    // methoden
    public String toString () {
        StringBuilder tekst = new StringBuilder("Deze persoon is " + getVoornaam() + " " + getNaam() + "\n");
        tekst.append(String.format("%-15s : %.2f%n", "gewicht", getGewicht()));
        tekst.append(String.format("%-15s : %.2f%n", "lengte", getLengte()));
        tekst.append(String.format("%-15s : %d%n", "geboortejaar", getGeboortejaar()));
        return tekst.toString();
    }

    public void voegVoornamenToe (String [] voornaam) {
        for (int i = 0; i < voornaam.length; i++) {
            this.voornaam += " " + voornaam[i];
        }
    }

    public double berekenBmi () {
        return gewicht / (lengte * lengte); // Math.bov(x,2) kwadraat berekenen
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