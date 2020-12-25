package be.pxl.h6.opdrachten.opdracht10_equalsOverride;

public class FiguurApp {
    public static void main(String[] args) {
        Cirkel cirkel = new Cirkel(5, 10, 15);
        Cirkel cirkel2 = new Cirkel(5, 10, 15);
        System.out.printf("De omtrek van de cirkel met middelpunt (%d, %d) is %.2f%n", cirkel.getX(), cirkel.getY(), cirkel.getOmtrek());
        System.out.printf("De oppervlake van cirkel emt middelpunt (%d, %d) is %.2f%n", cirkel.getX(), cirkel.getY(), cirkel.getOppervlak());
        System.out.println(cirkel);
        System.out.println(cirkel.toString());
        System.out.println("de cirkel is gelijk: " + cirkel.equals(cirkel2)); // vergelijkt cirkel 1 met cirkel 2
        System.out.println("hash circel1: " + cirkel.hashCode());
    }
}
