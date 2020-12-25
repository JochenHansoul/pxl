package be.pxl.h6.opdrachten.opdracht9_toStringOverride;

public class FiguurApp {
    public static void main(String[] args) {
        Cirkel cirkel = new Cirkel(5, 10, 15);
        System.out.printf("De omtrek van de cirkel met middelpunt (%d, %d) is %.2f%n", cirkel.getX(), cirkel.getY(), cirkel.getOmtrek());
        System.out.printf("De oppervlake van cirkel emt middelpunt (%d, %d) is %.2f%n", cirkel.getX(), cirkel.getY(), cirkel.getOppervlak());
        System.out.println(cirkel);
        System.out.println(cirkel.toString());
    }
}
