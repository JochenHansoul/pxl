package be.pxl.h6.voorbeeldPersoon;

public class Lector extends Persoon {
    private String personeelsnummer;
    private double salaris;
    private double aanstellingspercentage;
    // opage 6.3
    public Lector(String naam, String voornaam, String personeelsnummer, double salaris, double aanstellingspercentage) {
        super(naam, voornaam);
        this.personeelsnummer = personeelsnummer;
        this.salaris = salaris;
        this.aanstellingspercentage = aanstellingspercentage;
    }
    public Lector(String naam, String voornaam, double salaris, double aanstellingspercentage) {
        this(naam, voornaam, "20009999", salaris, aanstellingspercentage);
    }
    public Lector() {
        this("onbekend", "onbekend", 2000, 100); // degene net hierboven oproepen
    }
    // setters
    public void setPersoneelsnummer(String personeelsnummer) {
        this.personeelsnummer = personeelsnummer;
    }
    public void setSalaris(double salaris) {
        this.salaris = salaris;
    }
    public void setAanstellingspercentage(double aanstellingspercentage) {
        double oudPercentage = this.aanstellingspercentage; // vorige aanstellingspercentage
        if (aanstellingspercentage > 100) {
            aanstellingspercentage = 100;
        } else if (aanstellingspercentage < 0) {
            aanstellingspercentage = 0;
        }
        this.aanstellingspercentage = aanstellingspercentage;
        if (oudPercentage != 0 && salaris != 0) {
            salaris = salaris / oudPercentage * aanstellingspercentage;
        }
    }
    // getters
    public String getPersoneelsnummer() {
        return personeelsnummer;
    }
    public double getSalaris() {
        return salaris;
    }
    public double getAanstellingspercentage() {
        return aanstellingspercentage;
    }
    // methoden
    @Override // opdracht 5b.3
    public void print() {
        System.out.println("Personeelsnummer " + personeelsnummer);
        super.print();
        System.out.println("salaris " + salaris);
        System.out.println("aanstellingspercentage " + aanstellingspercentage);
    }
}
