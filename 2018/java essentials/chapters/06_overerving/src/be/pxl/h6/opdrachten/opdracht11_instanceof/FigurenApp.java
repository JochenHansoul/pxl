package be.pxl.h6.opdrachten.opdracht11_instanceof;

public class FigurenApp {
    public static void main(String[] args) {
        // array aanmaken met grafische elementen
        GrafischElement[] arrayGrafischeElementen = new GrafischElement[5];
        arrayGrafischeElementen[0] = new Cirkel(10, 20, 50);
        arrayGrafischeElementen[1] = new Cirkel(1, 52, 20);
        arrayGrafischeElementen[2] = new Rechthoek(10, 20, 5, 9);
        arrayGrafischeElementen[3] = new Vierkant(100, 20, 15);
        arrayGrafischeElementen[4] = new Driehoek(5, 20, 10, 30, 10);
        Object object1 = new Object();
        // arrayGrafischeElementen afdrukken
        for (GrafischElement vorm: arrayGrafischeElementen) {
            print(vorm);
        }
    }
    public static void print(GrafischElement vorm) {
        System.out.printf("Omtrek: %10.0f Oppervlakte: %10.0f", vorm.getOmtrek(), vorm.getOppervlak());
        if (vorm instanceof Cirkel){
            System.out.println("Cirkel");
        } else if (vorm instanceof Vierkant) { // het vierkant moet voor de rechthoek staan anders klopt volgorde niet
            System.out.println("Vierkant");
        } else if (vorm instanceof Rechthoek) {
            System.out.println("Rechthoek");
        } else {
            System.out.println("Driehoek");
        }
    }
}
