package be.pxl.h6.oefeningen.oef2;

public class GeboekteReis {
    private String naam;
    private Reis[] reizen;
    // constructors
    public GeboekteReis(String naam, int aantalReizen) {
        this.naam = naam;
        reizen = new Reis[aantalReizen];
    }
    // methoden
    public void voegReisToe(Reis reis) {
        int openPlaats = bepaalVrijePlaats();
        if (openPlaats == -1) {
            System.out.println("Er zijn geen plaatsen meer vrij");
        } else {
            this.reizen[openPlaats] = reis;
        }
    }
    private int bepaalVrijePlaats() { // methode voor vrije plaats in array te bepalen
        int openPlace = -1;
        for (int i = 0; i < reizen.length; i++) {
            if (reizen[i] == null) {
                openPlace = i;
                break; // ipv break gewoon return i
            }
        }
        return openPlace;
    }
    public void print() { // op examn soms rekening hpouden met open plaatsen!
        System.out.println("reis van " + naam);
        for (Reis r : reizen) {
            System.out.println(r.toString());
        }
    }
}
