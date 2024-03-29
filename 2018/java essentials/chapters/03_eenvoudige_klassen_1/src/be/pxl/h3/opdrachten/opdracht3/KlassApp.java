package be.pxl.h3.opdrachten.opdracht3;

public class KlassApp {
    public static void main(String[] args) {
        System.out.println("Het maximaal aantal studenten per klas is " + Klas.MAXIMUM);
        Klas tina = new Klas("1TINA", 19);
        Klas tinb = new Klas("1TINB", 25);
        Klas tinc = new Klas("1TINC", 34);
        Klas tind = new Klas("1TIND", 38);
        System.out.println("Aantal aangemaakte klasen " + Klas.getAantalKlassen());
        System.out.println("Totaal aantal studenten " + Klas.getTotaalStudenten());
        // in tinc een student toevoegen
        tinc.setAantalStudenten(tinc.getAantalStudenten() + 1);
        System.out.println("Totaal aantal studenten na toevoeging van 1 student " + Klas.getTotaalStudenten());
        System.out.println();
        Klas [] arrayKlas = {tina, tinb, tinc, tind};
        drukaf(arrayKlas);
        double gemiddelde = (double)Klas.getTotaalStudenten() / Klas.getAantalKlassen();
        System.out.println("Het gemiddelde is " + gemiddelde);
        double gemiddeldeAfgerond = Math.round(gemiddelde * 10) / 10.0;
        System.out.println("Het gemiddelde afgerond is " + gemiddeldeAfgerond);
    }
    public static void drukaf(Klas [] array) {
        for (Klas klas:array) {
            System.out.println("naam " + klas.getNaam());
            System.out.println("aantal: " + klas.getAantalStudenten());
        }
    }
}
