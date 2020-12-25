package be.pxl.h4.oef4;

public class Auto {
    private String merk;
    private String model;
    private int bouwjaar;
    private String kleur;
    private int maximumSnelheid;
    public static final int MAXIMUMSNEILHEID = 180;
    private static int maximum;
    private static int teller;
    // constructors
    public Auto() {
        this("VW", "Polo", 2018, "grijs", 160);
    }
    public Auto(String merk, String model, int bouwjaar, String kleur, int maximumSnelheid) {
        this.merk = merk;
        this.model = model;
        this.bouwjaar = bouwjaar;
        this.kleur = kleur;
        controleMaximumsnelheid(maximumSnelheid);
    }
    public Auto(Auto auto) {
        this(auto.merk, auto.model, auto.bouwjaar, auto.kleur, auto.maximumSnelheid);
    } // voor een object te copiëren
    // setters
    public void setMerk(String merk) {
        this.merk = merk;
    }
    public void setModel(String merk) {
        this.model = merk;
    }
    public void setBouwjaar(int bouwjaar) {
        this.bouwjaar = bouwjaar;
    }
    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
    public void setMaxSnelheid(int maximumSnelheid) {
        controleMaximumsnelheid(maximumSnelheid);
    }
    // getters
    public String getMerk() {
        return merk;
    }
    public String getModel() {
        return model;
    }
    public int getBouwjaar() {
        return bouwjaar;
    }
    public String getKleur() {
        return kleur;
    }
    public int getMaxSnelheid() {
        return maximumSnelheid;
    }
    public static int getAantal() {return teller;}
    public static int getMaximum() {
        return maximum;
    }
    // methoden
    public String print() {
        return merk + " " + model + " " + bouwjaar + " " + kleur + " " + maximumSnelheid;
    }
    private void controleMaximumsnelheid(int maximumSnelheid) {
        if (maximumSnelheid > MAXIMUMSNEILHEID) {
            maximumSnelheid = MAXIMUMSNEILHEID;
            maximum++;
        }
        this.maximumSnelheid = maximumSnelheid;
        teller++;
    }
}
