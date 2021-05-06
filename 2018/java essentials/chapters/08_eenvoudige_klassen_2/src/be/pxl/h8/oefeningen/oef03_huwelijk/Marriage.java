package be.pxl.h8.oefeningen.oef03_huwelijk;

import java.time.LocalDate;

public class Marriage {
    private Person firstPartner;
    private Person secondPartner;
    private LocalDate date;

    // constructors
    public Marriage(Person firstPartner, Person secondPartner, LocalDate date) {
        this.firstPartner = firstPartner;
        this.secondPartner = secondPartner;
        this.date = date;
        autoAddressAdjustment(firstPartner);
        System.out.println(this.getNames() + " zijn gehuwd op " + date + ". Proficiat!");
    }

    // getters
    public Person getFirstPartner() {
        return firstPartner;
    }
    public Person getSecondPartner() {
        return secondPartner;
    }
    public String getNames() { return firstPartner.getFullName() + " en " + secondPartner.getFullName(); }
    public LocalDate getDate() {
        return date;
    }

    // methoden
    private void autoAddressAdjustment(Person person) {
        secondPartner.setAddress(person.getAddress());
    }
    public void addressAdjustment(Address address) {
        firstPartner.setAddress(address);
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
