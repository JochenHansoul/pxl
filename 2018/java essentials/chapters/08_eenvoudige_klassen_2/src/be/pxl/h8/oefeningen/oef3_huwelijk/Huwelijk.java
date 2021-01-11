package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;

public class Huwelijk {
    private Persoon partner1;
    private Persoon partner2;
    private LocalDate huwelijksdatum;

    // constructors
    public Huwelijk(Persoon partner1, Persoon partner2, int jaar, int maand, int dag) {
        this.partner1 = partner1;
        this.partner2 = partner2;
        huwelijksdatum = LocalDate.of(jaar, maand, dag);
        autoAdresAanpassing(partner1);
        System.out.println(partner1.getVoornaam() + " " + partner1.getNaam() + " en " + partner2.getVoornaam() + " " + partner2.getNaam() + " zijn gehuwd op " + huwelijksdatum + ". Proficiat!");
    }

    // getters
    public Persoon getPartner1() {
        return partner1;
    }
    public Persoon getPartner2() {
        return partner2;
    }
    public LocalDate getHuwelijksdatum() {
        return huwelijksdatum;
    }

    // methoden
    private void autoAdresAanpassing(Persoon persoon) {
        partner2.setAdress(persoon.getAdress());
    }
    public void adresWijziging(String straat, String huisnummer, int postcode, String gemeente) {
        partner1.setAdress(new Adress(straat, huisnummer, postcode, gemeente));
        autoAdresAanpassing(partner1);
    }
    public void print() {
        System.out.println(partner1.toString());
        System.out.println("Geboren op " + partner1.getGeboortedatum().toString());
        System.out.println();
        System.out.println(partner2.toString());
        System.out.println("Geboren op " + partner2.getGeboortedatum());
        System.out.println();
        System.out.println("Het huwelijk vond plaats op " + huwelijksdatum);
    }
}