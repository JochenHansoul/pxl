package be.pxl.h8.oefeningen.oef3_huwelijk;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Address address;

    // constructors
    public Person() {
        this(
                "Jef",
                "Aerts",
                LocalDate.of(2019, 11, 29),
                new Address(
                        "Lindestraat",
                        "23D",
                        new Township(3500, "Hasselt")));
    }

    public Person(String firstName, String lastName, LocalDate date, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = date;
        this.address = address;
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
    public String getFullName() {return firstName + " " + lastName; }
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
        return String.format("%s %s\n%s", firstName, lastName, address);
    }
}