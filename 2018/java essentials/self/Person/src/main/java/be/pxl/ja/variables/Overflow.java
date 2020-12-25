package be.pxl.ja.variables;

public class Overflow {
    public static void main(String[] args) {
        // int
        System.out.println("int:");
        int i = 0;
        System.out.println(i);
        i= Integer.MAX_VALUE;
        System.out.println(i);
        i++;
        System.out.println(i + "\n");

        // longs
        System.out.println("long:");
        long l = Integer.MAX_VALUE;
        System.out.println(l);
        // int is de default waarde.
        // Zolang niet overschrijft niets aan de hand (hoeft dan geen "L" achter te zetten)
        l = Integer.MAX_VALUE + 1;
        System.out.println(l);
        l = Integer.MAX_VALUE + 1L;
        System.out.println(l);
        l = i - 2L;
        System.out.println(l);
    }
}
