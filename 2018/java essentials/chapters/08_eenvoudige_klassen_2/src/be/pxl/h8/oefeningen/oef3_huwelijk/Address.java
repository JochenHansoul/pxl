package be.pxl.h8.oefeningen.oef3_huwelijk;

public class Address {
    private Township township;
    private String street;
    private String number;

    // constructors
    public Address(String street, String number, int postcode, String townshipName) {
        this.street = street;
        this.number = number;
        this.township = new Township(postcode, townshipName);
    }

    public Address(Township township, String street, String number) {
        this.township = township;
        this.street = street;
        this.number = number;
    }

    // setters
    public void setStreet(String street) {
        this.street = street;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    // getters
    public String getStreet() {
        return street;
    }
    public String getNumber() {
        return number;
    }
    public Township getTownship() {
        return township;
    }

    // methode
    public String toString() {
        return String.format("%s %s%n%s", street, number, township);
    }
}
