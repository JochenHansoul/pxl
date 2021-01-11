package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Address address;

    // constructors
    public Person() {
        this("Aerts", "Jef", 21990, 11, 29, "Lindestraat", "23D", 3500, "Hasselt");
    }
    public Person(String naam, String voornaam, int jaar, int maand, int dag, String straat, String huisnummer, int postcode, String gemeente) {
        this.lastName = naam;
        this.firstName = voornaam;
        this.birthDate = LocalDate.of(jaar, maand, dag);
        this.address = new Address(straat, huisnummer, postcode, gemeente);
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String name) {
        this.lastName = name;
    }
    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Address getAddress() {
        return address;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // methoden
    public void addFirstName(String [] firstNames) {
        StringBuilder firstNameBuilder = new StringBuilder();
        for (String s : firstNames) {
            firstNameBuilder.append(" ").append(s);
        }
        this.firstName += firstNameBuilder.toString();
    }
    public String toString() {
        return String.format("%s %s\n%s ", firstName, lastName, address);
    }
}