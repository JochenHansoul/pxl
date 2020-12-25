package be.pxl.h5.oefeningen.oef2_pxl;

public class Leraar {
    public static final int MAXIMUM_AANTALVAKKEN = 5;
    private static int teller = 0;
    private String naam;
    private String voornaam;
    private int aanstellingsPercentage;
    private Vak [] vakken = new Vak[MAXIMUM_AANTALVAKKEN];
    private int aantalVakken = 0;

    // constructors
    public Leraar(String naam, String voornaam, int aanstellingsPercentage) {
        this.naam = naam;
        this.voornaam = voornaam;
        setAanstellingsPercentage(aanstellingsPercentage); // hier inderdaad setter gebruiken
        teller++;
    }

    //setters
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    public void setAanstellingsPercentage(int aanstellingsPercentage) {
        if (aanstellingsPercentage > 100) {
            System.out.println("Het aanstellingspercentage kan maximaal 100% zijn.");
            this.aanstellingsPercentage = 100;
        } else if (aanstellingsPercentage % 10 == 0) {
            this.aanstellingsPercentage = aanstellingsPercentage;
        } else {
            this.aanstellingsPercentage = Math.round(aanstellingsPercentage / 10.0f) * 10;
        }
    }

    // getters
    public String getNaam() {
        return naam + " " + voornaam;
    }
    public int getAanstellingsPercentage() {
        return aanstellingsPercentage;
    }
    public Vak getVak(int getal) {
        return vakken[getal];
    }
    public int getAantalVakken() {
        return aantalVakken;
    }
    public int getMaximumAantalvakken() {
        return MAXIMUM_AANTALVAKKEN;
    }
    public static int getTeller() {
        return teller;
    }

    // methoden
    public void voegVakToe(Vak vak) {
        /*int teller = aantalVakken();
        if (teller < MAXIMUM_AANTALVAKKEN) {
            vakken[teller] = vak;
        } else {
            System.out.println("Deze leraar kan geen vakken meer opnemen.");
        }*/
        if (aantalVakken < MAXIMUM_AANTALVAKKEN) { // dit moest met het aantal vakken gebeuren
            vakken[aantalVakken] = vak;
            aantalVakken++;
        } else {
            System.out.println("Deze leraar kan geen vakken meer opnemen.");
        }
    }
    public void print() {
        System.out.println("Leraar " + getNaam() + " is aangesteld voor " + getAanstellingsPercentage() + "%");
        System.out.println("Volgende vakken behoren tot het takenpaket:");
        if (getVak(0) != null) {
            for (int i = 0; i < 3; i++) {
                boolean welkJaar = false;
                for (int j = 0; j < aantalVakken; j++) {
                    if (Integer.parseInt(getVak(j).getCode().substring(1, 2)) == i + 1) {
                        welkJaar = true;
                    }
                }
                if (welkJaar) {
                    System.out.println("vakken van jaar " + (i + 1) + ":");
                }
                for (int j = 0; j < aantalVakken; j++) {
                    if (Integer.parseInt(getVak(j).getCode().substring(1, 2)) == i + 1) {
                        System.out.println(getVak(j).toString());
                    }
                }
            }
        } else {
            System.out.println("Er zijn geen vakken");
        }
    }
    //private int aantalVakken() {
        /*int getal = 0;
        int teller = 0;
        for (int i = 0; i < MAXIMUM_AANTALVAKKEN; i++){
            teller++;
            if (vakken[i] != null) {
                getal = teller; // getal = ++i doen geeft problemen met het afprinten
            }
        }
        return getal;*/

        // betere berekening
        /*for (int i = 0; i < MAXIMUM_AANTALVAKKEN; i++) {
            if (vakken[i] == null) {
                return i;
            }
        }
        return MAXIMUM_AANTALVAKKEN;
    }*/
}
