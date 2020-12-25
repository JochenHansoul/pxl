package be.pxl.h6.oefeningen.oef2;

public class VliegtuigReis extends Reis {
    private String vluchtnummer;
    private static final int MINIMUMPRIJS = 25;
    // constructors
    public VliegtuigReis(String bestemming) {
        super(bestemming);
        vluchtnummer = bestemming.charAt(0) + "9990";
    }
    public VliegtuigReis(String bestemming, int prijs, String vluchtnummer) {
        super(bestemming, prijs);
        setPrijs(controleMinimumPrijs(prijs));// correct controle op prijs?
        setVluchtnummer(vluchtnummer);
    }
    // setters
    public void setVluchtnummer(String vluchtnummer) {
        if (vluchtnummer.charAt(0) == getBestemming().charAt(0)) {
            this.vluchtnummer = vluchtnummer;
        } else {
            this.vluchtnummer = getBestemming().charAt(0) + vluchtnummer;
        }
    }
    // getters
    public String getVluchtnummer() {
        return vluchtnummer;
    }
    // methoden
    private int controleMinimumPrijs(int prijs) {
        if (prijs < MINIMUMPRIJS) {
            prijs = MINIMUMPRIJS;
        }
        return prijs;
    }
    @Override
    public String toString() {
        return String.format("%s%nVliegtuigreis (vluchtnr %s)", super.toString(), getVluchtnummer());
    }
}
