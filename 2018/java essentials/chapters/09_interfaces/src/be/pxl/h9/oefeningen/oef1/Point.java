package be.pxl.h9.oefeningen.oef1;

public class Point {
    public static int MAXIMUM_SIZE = 99;
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = Math.abs(x);
        this.y = Math.abs(y);
    }

    public void setX(int x) {
        this.x = Math.abs(x);
    }

    public void setY(int y) {
        this.y = Math.abs(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistanceOf(Point point) {
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }

    public String toString() {
        return String.format("x:%d y:%d", this.x, this.y);
    }
}
