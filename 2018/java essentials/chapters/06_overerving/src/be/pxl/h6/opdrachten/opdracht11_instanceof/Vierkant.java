package be.pxl.h6.opdrachten.opdracht11_instanceof;

public class Vierkant extends Rechthoek {
    public Vierkant(int x, int y, int h) {
        super(x, y, h, h);
    }

    public Vierkant(int h) {
        super();
        setHoogte(h);
        setBreedte(h);
    }
}
