package be.pxl.h7.oefeningen.exoef;

public class Tshirt {
    private TShirtSize maat;
    private Kleur kleur;
    private int hoeveelheid;
    // constructors
    public Tshirt(TShirtSize maat, Kleur kleur) {
        this(maat, kleur, 0);
    }
    public Tshirt(TShirtSize maat, Kleur kleur, int hoeveelheid) {
        this.maat = maat;
        this.kleur = kleur;
        this.hoeveelheid = hoeveelheid;
    }
    //setters
    public void setMaat(TShirtSize maat) {
        this.maat = maat;
    }
    public void setKleur(Kleur kleur) {
        this.kleur = kleur;
    }
    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }
    // getters
    public TShirtSize getMaat() {
        return maat;
    }
    public Kleur getKleur() {
        return kleur;
    }
    public int getHoeveelheid() {
        return hoeveelheid;
    }
    // methoden
    public void voegTShirtsToe(int aantal) {
        hoeveelheid += aantal;
    }
    public String toString() {
        return "T-shirt " + maat + " met kleur " + kleur + ": " + hoeveelheid;
    }
}
