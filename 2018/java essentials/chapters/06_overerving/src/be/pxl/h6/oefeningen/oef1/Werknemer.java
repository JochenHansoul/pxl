package be.pxl.h6.oefeningen.oef1;

import be.pxl.h6.voorbeeldPersoon.Persoon;

public class Werknemer extends Persoon {
    public static final int MINIMUMSALARIS = 1000;
    private static int aantal = 0;
    private String functie;
    private int salaris;

    // constructors
    public Werknemer(String naam, String voornaam) {
        this(naam, voornaam, "algemeen werknemer", 1800);
    }
    public Werknemer(String naam, String voornaam, String functie, int salaris) {
        super(naam, voornaam);
        this.functie = functie;
        setSalaris(salaris);
        aantal++;
    }

    // setters
    public void setFunctie(String functie) {
        this.functie = functie;
    }
    public void setSalaris(int salaris) {
        if (salaris < MINIMUMSALARIS) {
            salaris = MINIMUMSALARIS;
        }
        this.salaris = salaris;
    }

    // getters
    public static int getAantal() {
        return aantal;
    }
    public String getFunctie() {
        return functie;
    }
    public int getSalaris() {
        return salaris;
    }

    // methoden
    public void print() {
        super.print();
        System.out.println("functie " + getFunctie()); // mag gewoon functie zijn
        System.out.println("salaris " + getSalaris());
    }
}