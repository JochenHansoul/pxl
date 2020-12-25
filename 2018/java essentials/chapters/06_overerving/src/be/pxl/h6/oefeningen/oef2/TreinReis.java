package be.pxl.h6.oefeningen.oef2;

public class TreinReis extends Reis {
    private boolean nationaal; // true: binnenland, false: internationaal
    private String specificatie;
    private static String[] arraySpecificaties = {"IC", "IR", "L", "P"};
    // constructors
    public TreinReis(String bestemming) {
        super(bestemming);
        nationaal = true;
        setSpecificatie("IC");
    }
    public TreinReis(String bestemming, int prijs, boolean nationaal, String specificatie) {
        super(bestemming, prijs);
        this.nationaal = nationaal;
        setSpecificatie(specificatie);
    }
    // setters
    public void setSpecificatie(String specificatie) {
        boolean klopt = false;
        if (nationaal) {
            for (int i = 0; i < arraySpecificaties.length; i++) { // geen for each lus hier, alleen als zeker weet dat heel de lus moet doorlopen
                if (specificatie.equals(arraySpecificaties[i])) {
                    klopt = true;
                    break;
                }
            }
        }
        if (klopt) {
            this.specificatie = specificatie;
        } else {
            this.specificatie = "IC";
        }
    }
    // getters
    public String getSpecificatie() {
        return specificatie;
    }
    // methoden
    @Override
    public String toString() {
        String isNationaal;
        if (nationaal) {
            isNationaal = "Nationale";
        } else {
            isNationaal = "Internationale";
        }
        return String.format("%s%n%s treinreis (%s)", super.toString(), isNationaal, getSpecificatie());
    }
}
