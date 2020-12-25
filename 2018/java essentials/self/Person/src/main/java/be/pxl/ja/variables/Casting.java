package be.pxl.ja.variables;

public class Casting {
    public static void main(String[] args) {
        long l = Long.MAX_VALUE;
        int i = (int) l;
        System.out.println(i); //-1
    }
}
