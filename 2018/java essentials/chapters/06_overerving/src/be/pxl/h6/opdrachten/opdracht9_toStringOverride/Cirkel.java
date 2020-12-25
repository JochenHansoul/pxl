package be.pxl.h6.opdrachten.opdracht9_toStringOverride;

public class Cirkel extends GrafischElement {
    private int straal;
    public Cirkel(int x, int y, int straal) {
        super(x, y);
        setStraal(straal);
    }
    // setters
    public void setStraal(int straal) {
        this.straal = straal;
    }
    // getters
    public int getStraal() {
        return straal;
    }
    @Override
    public double getOppervlak() {
        return Math.PI * straal * straal;
    }
    @Override
    public double getOmtrek() {
        return Math.PI * straal * 2; // Math is een static variabele (weet dit omdat het met hoofdletter is)
    }
    // methoden
    @Override
    public String toString() {
        return String.format("Cirkel met straal %d op plaats (%d, %d)", straal, getX(), getY());
    }
}
