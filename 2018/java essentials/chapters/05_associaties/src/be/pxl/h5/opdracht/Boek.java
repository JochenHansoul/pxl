package be.pxl.h5.opdracht;

public class Boek {
    private String isbnnummer;
    private String titel;
    private int bladzijden;
    private Auteur auteur;
    // constructors
    public Boek() {
        this("onbekend", "onbekend", 0, new Auteur());
        /*isbnnummer = "onbekend";
        titel = "onbekend";
        auteur = new Auteur(); // de auteur is zelf een object met eigenschappen naam en voornaam*/
    }
    public Boek(String isbnnummer, String titel, int bladzijden, Auteur auteur) {
        this.isbnnummer = isbnnummer;
        this.titel = titel;
        this.bladzijden = bladzijden;
        this.auteur = auteur;
    }
    // setters
    public void setIsbnnummer(String isbnnummer) {
        this.isbnnummer = isbnnummer;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public void setBladzijden(int bladzijden) {
        this.bladzijden = bladzijden;
    }
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
    // getters
    public String getIsbnnummer() {
        return isbnnummer;
    }
    public String getTitel() {
        return titel;
    }
    public int getBladzijden() {
        return bladzijden;
    }
    public Auteur getAuteur() {
        return auteur;
    }
    // methoden
    public void toonBoekGegevens() {
        System.out.println("Isbnnummer: " + isbnnummer);
        System.out.println("auteur: " + auteur.toString());
        System.out.println("titel: " + titel);
        System.out.println("aantal pagina's: " + bladzijden);
    }
}
