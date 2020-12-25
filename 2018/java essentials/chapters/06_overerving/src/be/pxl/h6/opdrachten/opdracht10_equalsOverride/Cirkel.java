package be.pxl.h6.opdrachten.opdracht10_equalsOverride;

import java.util.Objects;

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
    @Override // dit is een override voor circels te vergelijken, niet van GrafischElement
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; // als objecten niet tot dezelfde klasse horen returnt false
        Cirkel cirkel = (Cirkel) o; // expliciete casting, maakt er een cirkel van
        return straal == cirkel.straal && getX() == cirkel.getX() && getY() == cirkel.getY();
    }
    @Override
    public int hashCode() {
        return Objects.hash(straal);
    }
}
