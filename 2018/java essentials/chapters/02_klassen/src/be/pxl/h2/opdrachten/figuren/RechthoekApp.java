package be.pxl.h2.opdrachten.figuren;

public class RechthoekApp {
    public static void main(String[] args) {
        Rechthoek rechthoek = new Rechthoek();
        // opdracht 3: alle eigenschappen afdrukken
        System.out.println("de hoogte van de rechthoek " + rechthoek.getHoogte());
        System.out.println("de breedte van de rechthoek " + rechthoek.getBreedte());
        System.out.printf("positie (%d, %d)%n", rechthoek.getX(), rechthoek.getY());
        // belangrijke opmerking => referentie wordt afgedrukt
        System.out.println(rechthoek);
        System.out.println();
        // toekennen van een waarde aan de eigenschappen
        rechthoek.setHoogte(10);
        rechthoek.setBreedte(4);
        rechthoek.setX(5);
        rechthoek.sety(15);
        System.out.println("de hoogte van de rechthoek " + rechthoek.getHoogte());
        System.out.println("de breedte van de rechthoek " + rechthoek.getBreedte());
        System.out.printf("positie (%d, %d)%n", rechthoek.getX(), rechthoek.getY());
        // omdracht 5 oppervlakte en omterk afdrukken
        System.out.println("De oppervlakte is " + rechthoek.getOppervlakte());
        System.out.println("De omtrek is " + rechthoek.getOmtrek());
        System.out.println();
        // 2de rechthoek aanmaken, waarden aan eigenschappen geven en afdrukken
        Rechthoek rechthoek2 = new Rechthoek();
        rechthoek2.setHoogte(3);
        rechthoek2.setBreedte(10);
        rechthoek2.setX(15);
        rechthoek2.sety(16);
        System.out.println("de hoogte van de rechthoek 2: " + rechthoek.getHoogte());
        System.out.println("de breedte van de rechthoek 2: " + rechthoek.getBreedte());
        System.out.printf("positie (%d, %d)%n", rechthoek2.getX(), rechthoek2.getY());
        // opdracht 5
        System.out.println("De oppervlakte is " + rechthoek2.getOppervlakte());
        System.out.println("De omtrek is " + rechthoek2.getOmtrek());
        System.out.println();
        // 3e rechthoek aangemaakt
        Rechthoek rechthoek3 = new Rechthoek();
        rechthoek3.setHoogte(-5);
        rechthoek3.setBreedte(-6);
        rechthoek3.groei(10);
        System.out.println("de hoogte van rechthoek 3: " + rechthoek3.getHoogte());
        System.out.println("de breedte van de rechthoek 3: " + rechthoek3.getBreedte());
        System.out.println();
        // 4e rechthoek aangemaakt - constructor
        Rechthoek rechthoek4 = new Rechthoek(10, 15);
        System.out.println("de hoogte van rechthoek 4: " + rechthoek4.getHoogte());
        System.out.println("de breedte van de rechthoek 4: " + rechthoek4.getBreedte());
        System.out.println();
        // 5e rechthoek aangemaakt - constructor
        Rechthoek rechthoek5 = new Rechthoek(-10, 7, 6, 10);
        System.out.println("de hoogte van de rechthoek 5: " + rechthoek5.getHoogte());
        System.out.println("de breedte van de rechthoek 5: " + rechthoek5.getBreedte());
        System.out.printf("positie (%d, %d)%n", rechthoek5.getX(), rechthoek5.getY());
        System.out.println();
        // 6e rechthoek aangemaakt
        Rechthoek rechthoek6 = new Rechthoek(rechthoek5);
        Rechthoek [] arrayRechthoek = {rechthoek, rechthoek2, rechthoek3, rechthoek4, rechthoek5, rechthoek6};
        for (Rechthoek recht : arrayRechthoek) {
            System.out.println("de hoogte van de rechthoek: " + recht.getHoogte());
            System.out.println("de breedte van de rechthoek: " + recht.getBreedte());
            System.out.printf("positie (%d, %d)%n", recht.getX(), recht.getY());
            System.out.println("De oppervlakte is " + recht.getOppervlakte());
            System.out.println("de omtrek is " + recht.getOmtrek());
        }
    }
}
