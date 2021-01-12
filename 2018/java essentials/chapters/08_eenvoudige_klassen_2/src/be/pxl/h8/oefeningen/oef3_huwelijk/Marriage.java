package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;

public class Marriage {
    private Person firstPartner;
    private Person secondPartner;
    private LocalDate date;

    // constructors
    public Marriage(Person firstPartner, Person secondPartner, int jaar, int maand, int dag) {
        this.firstPartner = firstPartner;
        this.secondPartner = secondPartner;
        date = LocalDate.of(jaar, maand, dag);
        autoAddressAdjustment(firstPartner);
        System.out.println(firstPartner.getFullName() + " en " + secondPartner.getFullName() + " zijn gehuwd op " + date + ". Proficiat!");
    }

    // getters
    public Person getFirstPartner() {
        return firstPartner;
    }
    public Person getSecondPartner() {
        return secondPartner;
    }
    public LocalDate getDate() {
        return date;
    }

    // methoden
    private void autoAddressAdjustment(Person person) {
        secondPartner.setAddress(person.getAddress());
    }
    public void addressAdjustment(String street, String number, int postcode, String townshipName) {
        firstPartner.setAddress(new Address(street, number, postcode, townshipName));
        autoAddressAdjustment(firstPartner);
    }
    public void print() {
        System.out.println(firstPartner.toString());
        System.out.println("Geboren op " + firstPartner.getBirthDate().toString());
        System.out.println();
        System.out.println(secondPartner.toString());
        System.out.println("Geboren op " + secondPartner.getBirthDate());
        System.out.println();
        System.out.println("Het huwelijk vond plaats op " + date);
    }
}