package be.pxl.h2.oefeningen.oef2_tijdstip;

public class TijdstipApp {
    public static void main(String[] args) {
        Tijdstip tijdstipNu = new Tijdstip(16, 51, 20);
        System.out.printf("De tijd is: %d %d %d \n", tijdstipNu.getUren(), tijdstipNu.getMinuten(), tijdstipNu.getSeconden());
        Tijdstip tijdstip1 = new Tijdstip(60000);
        System.out.printf("60 000 seconden is: %d %d %d \n", tijdstip1.getUren(), tijdstip1.getMinuten(), tijdstip1.getSeconden());
        Tijdstip tijdstip2 = new Tijdstip(tijdstip1);
        System.out.printf("60 000 seconden is: %d %d %d \n", tijdstip2.getUren(), tijdstip2.getMinuten(), tijdstip2.getSeconden());
        System.out.println(tijdstipNu.toStringTijd(true));
        System.out.println(tijdstip2.toStringTechnisch());
        Tijdstip tijdstipDefault = new Tijdstip();
        tijdstipDefault.setUren(2);
        tijdstipDefault.setMinuten(2);
        tijdstipDefault.setSeconden(2);
        System.out.println(tijdstipDefault.toStringTijd(true));
        System.out.println();
        int [][] tijdstippen = {{1, 10, 4}, {10, 50, 14}, {0, 1, 1}, {50, 510, 33}};
        for (int i = 0; i < tijdstippen.length; i++) {
            Tijdstip meerdereTijdstippen = new Tijdstip(tijdstippen[i][0], tijdstippen[i][1], tijdstippen[i][2]);
            System.out.println(meerdereTijdstippen.toStringTechnisch());
        }
    }
}
