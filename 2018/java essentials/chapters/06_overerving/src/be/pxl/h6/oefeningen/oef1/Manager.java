package be.pxl.h6.oefeningen.oef1;

public class Manager extends Werknemer {
    private static int aantal = 0;
    private int bonus;

    // constructors
    public Manager(String naam, String voornaam, String functie, int salaris) {
        this(naam, voornaam, functie, salaris, 50);
    }
    public Manager(String naam, String voornaam, String functie, int salaris, int bonus) {
        super(naam, voornaam, functie, salaris);
        this.bonus = bonus;
        aantal++;
    }

    //setters
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    // getters
    public static int getAantal() {
        return aantal;
    }
    public static double getProcAandeelManagers() { // beter returnen als double
        if (Werknemer.getAantal() > 0) {
            return Math.round(getAantal() * 10000 / Werknemer.getAantal()) / 100.0;
        } else {
            return 0; // double van maken en 0 returnen
        }
    }
    public int getBonus() {
        return bonus;
    }

    @Override
    public int getSalaris() {
        return super.getSalaris() + bonus;
    }
}