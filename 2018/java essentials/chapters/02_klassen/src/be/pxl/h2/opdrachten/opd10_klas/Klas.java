package be.pxl.h2.opdrachten.opd10_klas;

public class Klas {
    // eigenschappenn, instantievariabelen
    private  String naam;
    private int aantalStudenten;
    // klasse variabele
    public static final int MAXIMUM = 40; // voor klasse var final niet verplicht maar hier willen we wel
    // opdracht 10.8
    public  static int tel = 0;

    // constructors
    public Klas() {
     /*   naam = "1TINc";
        aantalStudenten = 0; */
     this("1TINc", 0);
    }

    public Klas (String naam, int aantalStudenten) {
        setAantalStudenten(aantalStudenten); // opdracht 10.6
        this.aantalStudenten = aantalStudenten;
        this.naam = naam;
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

    public void setAantalStudenten(int aantalStudenten) {
        if (aantalStudenten > MAXIMUM) { // opdracht 10.6
            aantalStudenten = MAXIMUM;
        }
        this.aantalStudenten = aantalStudenten;
    }
}
