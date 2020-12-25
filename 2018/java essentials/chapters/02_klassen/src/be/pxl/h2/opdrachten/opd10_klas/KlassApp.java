package be.pxl.h2.opdrachten.opd10_klas;

public class KlassApp {
    public static void main(String[] args) {
        System.out.println("Het maximaal aantal studenten per klas is " + Klas.MAXIMUM);
        Klas TINA = new Klas("1TINA", 19);
        System.out.println("Aantal aangemaakte klassen " + Klas.tel);
        Klas TINB = new Klas("1TINB", 25);
        System.out.println("Aantal aangemaakte klassen " + Klas.tel);
        Klas TINC = new Klas("1TINC", 34);
        System.out.println("Aantal aangemaakte kla  ssen " + Klas.tel);
        Klas TIND = new Klas("1TIND", 38);
        System.out.println("Aantal aangemaakt klassen " + Klas.tel);
        Klas [] arrayKlas = {TINA, TINB, TINC, TIND};
        for (Klas klas : arrayKlas) {
            System.out.println("naam " + klas.getNaam());
            System.out.println("aantal: " + klas.getAantalStudenten());
        }
    }
}