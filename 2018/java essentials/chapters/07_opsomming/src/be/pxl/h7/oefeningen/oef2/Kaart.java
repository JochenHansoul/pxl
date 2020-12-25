package be.pxl.h7.oefeningen.oef2;

public class Kaart {
    private Ranking ranking;
    private Soort soort;
    //private int waarde; is niet nodig
    // constructor
    public Kaart(Ranking ranking, Soort soort) {
        this.ranking = ranking;
        this.soort = soort;
    }
    // getters
    public Ranking getranking() {
        return ranking;
    }
    public Soort getSoort() {
        return soort;
    }
    // methoden
    public String getKaart() {
        return soort + " " + ranking;
    }
}
