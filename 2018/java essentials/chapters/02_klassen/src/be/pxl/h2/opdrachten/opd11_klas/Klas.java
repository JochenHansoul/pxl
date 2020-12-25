package be.pxl.h2.opdrachten.opd11_klas;

public class Klas {
    // eigenschappenn - instantievariabelen
    private  String naam;
    private int aantalStudenten;
    // eigenschappen - klassevariabele
    public static final int MAXIMUM = 40; // voor klassevar final niet verplicht maar hier willen we wel
    private  static int tel = 0; // opdracht 10.8 - we gaan deze op private zetten want we hebben een teller voor getAantalKlassen
    private static int totaalStudenten = 0; // opdracht 11.2
    // constructors
    public Klas() {
        /*naam = "1TINc";
        aantalStudenten = 0;*/
        this("1TINc", 0); // andere constructor opgeroepen, geen teller nodig.
    }
    public Klas (String naam, int aantalStudenten) {
        setAantalStudenten(aantalStudenten); // opdracht 10.6
        this.naam = naam;
        /*this.aantalStudenten = aantalStudenten;*/
        /*totaalStudenten += aantalStudenten; deze mag weg omdat dit in getTotaalStudenten wordt aangepast*/
        tel++;
    }
    // getters en setters
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public int getAantalStudenten() {
        return aantalStudenten;
    }
    public void setAantalStudenten(int aantalStudenten) { // set het aantal studenten
        totaalStudenten -= this.aantalStudenten; // trek eerst het aantal studenten in de klas van van het totaal aantal studenten
        if (aantalStudenten > MAXIMUM) { // opdracht 10.6 - controle niet meer dan 40 studenten
            aantalStudenten = MAXIMUM;
        }
        totaalStudenten += aantalStudenten; // tel het nieuwe aantal studenten op aan het totaal aantal studenten
        this.aantalStudenten = aantalStudenten;
    }
    // getter voor het aantal KlasObjecten opdracht 11.1
    public static int getAantalKlassen(){
        return tel;
    }
    public static int getTotaalStudenten(){
        return totaalStudenten;
    }
}
