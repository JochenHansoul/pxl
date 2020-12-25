package be.pxl.h6.opdrachten.opdracht11_instanceof;

import java.util.Objects;

public class Cirkel extends GrafischElement {
    private int straal;
    // constructors
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
    public double getOppervlak() { // de naam getOppervlak moet overeenkomen met het absract in Grafisch element
        return Math.PI * straal * straal;
    }
    @Override
    public double getOmtrek() {
        return Math.PI * straal * 2; // Math is een static variabele (weet dit omdat het met hoofdletter is, PI is een constante en wordt met hoofdletters geschreven)
    }
    // methoden
    @Override
    public String toString() {
        return String.format("Cirkel met straal %d op plaats (%d, %d)", straal, getX(), getY());
    }
    @Override
    public boolean equals(Object o) { // de cirkel2 is object o     de this is object cirkel ?
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cirkel cirkel = (Cirkel) o;
        return straal == cirkel.straal && getX() == cirkel.getX() && getY() == cirkel.getY();
    }
    @Override
    public int hashCode() {
        return Objects.hash(straal);
    }
}
