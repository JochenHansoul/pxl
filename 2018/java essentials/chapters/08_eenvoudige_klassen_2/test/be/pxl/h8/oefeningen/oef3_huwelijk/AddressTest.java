package be.pxl.h8.oefeningen.oef3_huwelijk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    private Address address;

    @Before
    public void initializeAddress() {
        address = new Address("straat", "1a", 1000, "Wellen");
    }

    @Test
    public void testConstructorWithoutTownshipObject() {
        assertEquals("straat", address.getStreet());
        assertEquals("1a", address.getNumber());
        assertEquals(1000, address.getTownship().getPostcode());
        assertEquals("Wellen", address.getTownship().getName());
    }

    @Test
    public void testConstructorWithTownshipObject() {
        Township township = new Township(1000, "Wellen");
        Address address = new Address("straat", "1a", township);
        assertEquals("straat", address.getStreet());
        assertEquals("1a", address.getNumber());
        assertEquals(township, address.getTownship());
    }

    @Test
    public void testChangeStreet() {
        address.setStreet("new");
        assertEquals("new", address.getStreet());
    }

    @Test
    public void testChangeNumber() {
        address.setNumber("2b");
        assertEquals("2b", address.getNumber());
    }

    @Test
    public void testToString() {
        assertEquals("straat 1a\n1000 Wellen", address.toString());
    }
}
