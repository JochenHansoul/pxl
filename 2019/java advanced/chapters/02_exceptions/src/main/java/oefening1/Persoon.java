package oefening1;

import java.time.LocalDate;

public class Persoon {
    private String naam;
    private LocalDate geboorteDatum;

    public Persoon(String naam, int dag, int maand, int jaar) throws Exception {
        this.naam = naam;
        if (maand < 1 || maand > 12)  {
            throw new Exception("Month is incorrect");
        }
        geboorteDatum = LocalDate.of(jaar, maand, dag);
    }

    public int aantalDagenTotVerjaardag() {
        int dayOfYear = LocalDate.now().getDayOfYear();
        int birthDay = geboorteDatum.getDayOfYear();
        if (dayOfYear > birthDay) {
            return geboorteDatum.getYear();
        } else {
            return birthDay - dayOfYear;
        }
    }

    public String getNaam() {
        return naam;
    }
}