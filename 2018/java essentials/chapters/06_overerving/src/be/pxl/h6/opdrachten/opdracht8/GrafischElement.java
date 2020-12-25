package be.pxl.h6.opdrachten.opdracht8;

public abstract class GrafischElement {
    private static int tel = 0; // opdracht 8.3
    private int x;
    private int y;

    // constructors
    public GrafischElement( int x, int y) {
        this.x = x;
        this.y = y;
        tel++;
    }

    // setters
    public void setPositie(int x, int y)  {
        this.x = x;
        this.y = y;
    }

    // getters
    public static int getTel() {
        return tel;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return  y;
    }

    // methoden
    public abstract double getOppervlak();
    public abstract double getOmtrek();
}