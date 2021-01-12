package be.pxl.h8.oefeningen.oef3_huwelijk;

public class Address {
    private String street;
    private String number;
    private Township township;

    // constructors
    public Address(String street, String number, int postcode, String townshipName) {
        this(street, number, new Township(postcode, townshipName));
    }
    public Address(String street, String number, Township township) {
        this.street = street;
        this.number = number;
        this.township = township;
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
