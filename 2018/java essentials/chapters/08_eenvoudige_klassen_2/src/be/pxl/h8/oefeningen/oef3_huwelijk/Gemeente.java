package be.pxl.h8.oefeningen.oef3_huwelijk;

public class Gemeente {
    private int postcode;
    private String gemeenteNaam;

    // constructors
    public Gemeente(int postcode, String gemeenteNaam) {
        setPostcode(postcode);
        setGemeenteNaam(gemeenteNaam);
    }

    // setters
    public void setPostcode(int postcode) {
        while (postcode > 9999) {
            postcode /= 10;
        }
        while (postcode < 1000) {
            postcode *= 10;
        }
        this.postcode = postcode;
    }
    public void setGemeenteNaam(String gemeenteNaam) {
        StringBuilder nieuweNaam = new StringBuilder();
        String teken = " ";
        for (int i = 0; i < gemeenteNaam.length(); i++) {
            if (!Character.isDigit(gemeenteNaam.charAt(i))) {
                if ((teken.equals(" ") || teken.equals("*") || teken.equals("'") || teken.equals("-")) && Character.isLetter(gemeenteNaam.charAt(i))) {
                    nieuweNaam.append(Character.toUpperCase(gemeenteNaam.charAt(i)));
                } else if (Character.isLetter(gemeenteNaam.charAt(i))) {
                    nieuweNaam.append(Character.toLowerCase(gemeenteNaam.charAt(i)));
                } else {
                    nieuweNaam.append(gemeenteNaam.charAt(i));
                }
                teken = gemeenteNaam.charAt(i) + "";
            }
        }
        this.gemeenteNaam = nieuweNaam.toString();
    }

    // getters
    public int getPostcode() {
        return postcode;
    }
    public String getGemeenteNaam() {
        return gemeenteNaam;
    }

    // methoden
    public String toString() {
        return postcode + " " + gemeenteNaam;
    }
}