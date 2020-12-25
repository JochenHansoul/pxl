package be.pxl.h6.oefeningen.oef3;

public final class Voetballer extends Sporter {
    private String club;
    private String obstelling;
    private static String[] arrayObestellingen = {"aanvaller", "middenvelder", "verdediger", "onbepaald"};
    // constructors
    public Voetballer(String naam, String voornaam) {
        this(naam, voornaam, "onbekend", "onbekend");
    }
    public Voetballer(String naam, String voornaam, String club, String obstelling) {
        super(naam, voornaam, "voetbal");
        this.club = club;
        setObstelling(obstelling);
    }
    //setters
    public void setClub(String club) {
        this.club = club;
    }
    public void setObstelling(String obstelling) { // invoercontrole obstelling
        if (obstelling.toLowerCase().equals(arrayObestellingen[0]) || obstelling.toLowerCase().equals(arrayObestellingen[1]) || obstelling.toLowerCase().equals(arrayObestellingen[2])) {
            this.obstelling = obstelling.toLowerCase();
        } else {
            this.obstelling = "onbekend";
        }
    }
    // getters
    public String getClub() {
        return club;
    }
    public String getObstelling() {
        return obstelling;
    }
    public static String[] getArrayObestellingen() {
        return arrayObestellingen;
    }
    // methoden
    public void print() {
        super.print();
        System.out.println("club: " + club + " obstelling: " + obstelling);
    }
}
