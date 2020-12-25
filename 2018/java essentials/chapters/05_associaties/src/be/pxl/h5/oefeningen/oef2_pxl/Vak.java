package be.pxl.h5.oefeningen.oef2_pxl;

public class Vak {
    private String code;
    private String naam;
    private int aantalStudiepunten;

    // constructors
    public Vak (String code, String naam, int aantalStudiepunten) {
        this.code = controleCode(code);
        this.naam = naam;
        //this.aantalStudiepunten = aantalStudiepunten; moet gezet worden, anders verkeerd!
        setAantalStudiepunten(aantalStudiepunten);
    }

    // setters
    public void setCode(String code) {
        this.code = code;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setAantalStudiepunten(int aantalStudiepunten) {
        if (aantalStudiepunten > 18) {
            this.aantalStudiepunten = 18;
        } else if (aantalStudiepunten % 3 == 1) {
            this.aantalStudiepunten = aantalStudiepunten - 1 ; // is het niet beter dat ik gewoon else en dan de de regel hieronder gebruik?
        } else if (aantalStudiepunten % 3 == 2) {
            this.aantalStudiepunten = aantalStudiepunten + 1;
        }
    }

    // getters
    public String getCode() {
        return code;
    }
    public String getNaam() {
        return naam;
    }
    public int getAantalStudiepunten() {
        return aantalStudiepunten;
    }

    // methoden
    public String toString() {
        return String.format("\t%s\t\t%-33S%d", code, naam, aantalStudiepunten);
    }
    private String controleCode(String code) {
        if (code.length() == 9) {
            if (Character.isDigit(code.charAt(0)) && Character.isDigit(code.charAt(1))
                    && Character.isLetter(code.charAt(2)) && Character.isLetter(code.charAt(3)) && Character.isLetter(code.charAt(4))
                    && Character.isDigit(code.charAt(5)) && Character.isDigit(code.charAt(6)) && Character.isDigit(code.charAt(7)) && Character.isDigit(code.charAt(8)))  {
                if (Integer.parseInt(code.substring(1, 2)) > 0 && Integer.parseInt(code.substring(1, 2)) < 4) { // char kar = code.charAt(x)
                    return code;
                } else {
                    return code.substring(0, 1) + "1" + code.substring(2);
                }
            }
        }
        return "00TIN9999";
    }
}