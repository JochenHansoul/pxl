package be.pxl.h8.oefeningen.oef03_huwelijk;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private LocalDate date = LocalDate.now();
    private Address address = new Address("straat", "1a", 1000, "gemeente");
    private Person person;

    @Before
    public void initialize() {
        person = new Person("voornaam", "achternaam", date, address);
    }

    @Test
    public void testGetFirstNameTest() {
        assertEquals("voornaam", person.getFirstName());
    }

    @Test
    public void testGetLastNameTest() {
        assertEquals("achternaam", person.getLastName());
    }

    @Test
    public void testGetBirthDate() {
        assertEquals(date, person.getBirthDate());
    }

    @Test
    public void testGetAddress() {
        assertEquals(address, person.getAddress());
    }

    @Test
    public void testGetFullName() {
        assertEquals("voornaam achternaam", person.getFullName());
    }

    @Test
    public void testSetFirstName() {
        person.setFirstName("new");
        assertEquals("new", person.getFirstName());
    }

    @Test
    public void testSetLastName() {
        person.setLastName("new");
        assertEquals("new", person.getLastName());
    }

    @Test
    public void testAddFirstNames() {
        person.addFirstName(new String[]{"first", "second"});
        assertEquals("voornaam first second", person.getFirstName());
    }

    @Test
    public void testToString() {
        assertEquals("voornaam achternaam\nstraat 1a\n1000 Gemeente", person.toString());
    }
}
