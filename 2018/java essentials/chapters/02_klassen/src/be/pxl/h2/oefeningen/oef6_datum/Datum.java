package be.pxl.h2.oefeningen.oef6_datum;

public class Datum {
    private int dag;
    private int maand;
    private int jaar;
    private static String[] maandNamen = new String[] {"januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december"};
    //constructors
    public Datum() {
        this(1, 1, 2018);
    }
    public Datum(int dag, int maand, int jaar) {
        this.dag = dag;
        setMaand(maand);
        this.jaar = jaar;
    }
    public Datum(String datum) {
        String[] arrayDatum = datum.split("/");
        dag = Integer.parseInt(arrayDatum[0]);
        setMaand(Integer.parseInt(arrayDatum[1]));
        jaar = Integer.parseInt(arrayDatum[2]);
    }
    // setters
    public void setDag(int dag) {
        this.dag = dag;
    }
    public void setMaand(int maand) {
        if (maand > maandNamen.length) {
            this.maand = 12;
        } else if (maand < 1) {
            this.maand = 1;
        } else {
            this.maand = maand;
        }
    }
    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
    // getters
    public int getDag() {
        return dag;
    }
    public int getMaandNr() {
        return maand;
    }
    public String getMaandNaam() {
        return maandNamen[maand - 1];
    }
    public int getJaar() {
        return jaar;
    }
    // methoden
    public String toString() {
        return dag + " " + maandNamen[maand - 1] + " " + jaar;
    }
}
