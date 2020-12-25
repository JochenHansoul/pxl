package be.pxl.h6.oefeningen.oef2;

public abstract class Reis {
    public static final int MINIMUMPRIJS = 5;
    private String bestemming;
    private int prijs;

    // constructors
    public Reis(String bestemming) {
        this(bestemming, MINIMUMPRIJS);
    }
    public Reis(String bestemming, int prijs) {
        setBestemming(bestemming);
        setPrijs(prijs);
    }

    // setters
    public void setBestemming(String bestemming) {
        while (Character.isDigit(bestemming.charAt(0))) {
            bestemming = bestemming.substring(1);
        }
        this.bestemming = bestemming;
    }
    public void setPrijs(int prijs) {
        if (prijs < MINIMUMPRIJS) {
            prijs = MINIMUMPRIJS;
        }
        this.prijs = prijs;
    }

    // getters
    public String getBestemming() {
        return bestemming;
    }
    public int getPrijs() {
        return prijs;
    }

    // methoden
    public String toString() {
        return String.format("Reis met bestemming %s kost %.2f euro", getBestemming(), getPrijs() * 1.0);
    }
}