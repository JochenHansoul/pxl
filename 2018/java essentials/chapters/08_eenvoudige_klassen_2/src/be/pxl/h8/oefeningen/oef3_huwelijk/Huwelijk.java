package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;

public class Huwelijk {
    private Person partner1;
    private Person partner2;
    private LocalDate huwelijksdatum;

    // constructors
    public Huwelijk(Person partner1, Person partner2, int jaar, int maand, int dag) {
        this.partner1 = partner1;
        this.partner2 = partner2;
        huwelijksdatum = LocalDate.of(jaar, maand, dag);
        autoAdresAanpassing(partner1);
        System.out.println(partner1.getFirstName() + " " + partner1.getLastName() + " en " + partner2.getFirstName() + " " + partner2.getLastName() + " zijn gehuwd op " + huwelijksdatum + ". Proficiat!");
    }

    // getters
    public Person getPartner1() {
        return partner1;
    }
    public Person getPartner2() {
        return partner2;
    }
    public LocalDate getHuwelijksdatum() {
        return huwelijksdatum;
    }

    // methoden
    private void autoAdresAanpassing(Person persoon) {
        partner2.setAddress(persoon.getAddress());
    }
    public void adresWijziging(String straat, String huisnummer, int postcode, String gemeente) {
        partner1.setAddress(new Address(straat, huisnummer, postcode, gemeente));
        autoAdresAanpassing(partner1);
    }
    public void print() {
        System.out.println(partner1.toString());
        System.out.println("Geboren op " + partner1.getBirthDate().toString());
        System.out.println();
        System.out.println(partner2.toString());
        System.out.println("Geboren op " + partner2.getBirthDate());
        System.out.println();
        System.out.println("Het huwelijk vond plaats op " + huwelijksdatum);
    }
}