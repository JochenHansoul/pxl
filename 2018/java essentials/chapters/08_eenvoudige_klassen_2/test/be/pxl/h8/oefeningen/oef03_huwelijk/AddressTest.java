package be.pxl.h8.oefeningen.oef03_huwelijk;

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
    public void testGetStreet() {
        assertEquals("straat", address.getStreet());
    }

    @Test
    public void testGetAddress() {
        assertEquals("1a", address.getNumber());
    }

    @Test
    public void testGetPostcode() {
        assertEquals(1000, address.getTownship().getPostcode());
    }

    @Test
    public void testGetTownshipName() {
        assertEquals("Wellen", address.getTownship().getName());
    }

    @Test
    public void testGetTownship() {
        Township township = new Township(1000, "Wellen");
        Address address = new Address("straat", "1a", township);
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
