package be.pxl.h2.opdrachten.figuren;

public class Rechthoek {
    // instantievariabelen definiëren
    private int hoogte = 10; // standaard geen 0 maar default 10
    private int breedte = 5;
    private int x;
    private int y;
    // default conscructor (bestaat niet meer als je een andere constructor hebt defineerd)
    // de default waarden zijn 0
    public Rechthoek () {
    }
    // constructor met 2 parameters a en b
    public Rechthoek (int hoogte, int breedte) { // rechthoek 4 mee aangemaakt
        setHoogte(hoogte);
        setBreedte(breedte);
    }
    // opdracht8: constructie met een waarde voor alle eigenschappen
    public  Rechthoek (int x, int y, int hoogte, int breedte) { // rechthoek 5
        this.x = x;
        this.y = y;
        setHoogte(hoogte);
        setBreedte(breedte);
    }
    // copy constructor
    public Rechthoek (Rechthoek rechthoek) {
        /* x = rechthoek.x; // ge zit in de klasse waarin hij gedefinieerd is dus hoeft niet te definieeren
        y = rechthoek.y;
        hoogte = rechthoek.hoogte;
        breedte = rechthoek.breedte; */
            this(rechthoek.x, rechthoek.y, rechthoek.hoogte, rechthoek.breedte); // dit gedeelte staat in 1 lijn
    }
    // opdracht 4 - setters
    // (verder uit gebreid:) opdracht 6 negatieve waarde => absolute waarde nemen
    public void  setHoogte(int l) {
        if (l < 0) {
            l = -l;
        }
        hoogte = l;
    }
    public void setBreedte (int b) {
        this.breedte = b; //this. om de eigenschap van breedte te wijzeigen
    }
    public void setX (int x) {
        this.x = x;
    }
    public void sety (int y) {
        this.y = y;
    }
    public void setPosition (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // opdracht 5 oppervlakte + omtrek
    public int getOppervlakte() {
        return hoogte * breedte;
    }
    public  int getOmtrek() {
        return 2 * (hoogte + breedte);
    }
    public  int getBreedte() { // met eigenschap op private dit soort methode gebruiken
        return  breedte;
    }
    public  int getHoogte() {
        return  hoogte;
    }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    // methoden
    public void groei (int db, int dh) { // methode om de hoogte en breedte te laten groeien
        breedte += db;
        if (breedte < 0) {
            breedte = 0;
        }
        hoogte += dh;
        if (hoogte < 0) {
            hoogte = 0;
        }
    }
    public  void groei (int d) { // deze methode opnieuw maar met ander waarden!
        groei (d, d); // de methode hierboven wordt opgeroepen en krijgt de parameters d en d door
    }
}
