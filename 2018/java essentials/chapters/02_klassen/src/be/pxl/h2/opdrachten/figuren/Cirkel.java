package be.pxl.h2.opdrachten.figuren;

public class Cirkel {
    // eigenschappen
    private double straal;
    private String kleur;
    //constructors
    public Cirkel (double straal) {
        this.straal = straal;
    }
    public Cirkel(double straal, String kleur) {
        this.straal = straal;
        this.kleur = kleur;
    }
    // setter
    public void setStraal (double straal) {
        this.straal = straal;
    }
    // getter
    public double getStraal () { // nooit extra informatie meegeven!
        return straal;
    }
}
