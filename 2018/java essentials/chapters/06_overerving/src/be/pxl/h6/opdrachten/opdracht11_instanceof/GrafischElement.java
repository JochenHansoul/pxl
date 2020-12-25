package be.pxl.h6.opdrachten.opdracht11_instanceof;

public abstract class GrafischElement {
    private int x;
    private int y;
    private static int tel = 0; // opdracht 8.3
    // constructors
    public GrafischElement(int x, int y) {
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
    public int getX() {
        return x;
    }
    public int getY() {
        return  y;
    }
    public static int getTel() {
        return tel;
    }
    // methoden
    public abstract double getOppervlak();
    public abstract double getOmtrek();
}
