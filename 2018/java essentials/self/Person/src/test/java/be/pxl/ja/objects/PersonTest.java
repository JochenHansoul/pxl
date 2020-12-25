package be.pxl.ja.objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Person person;

    @Before
    public void init() {
        this.person = new Person("first", "last", 0);
    }
    @Test
    public void testCreatePerson() {
        Person person = new Person();
    }

    @Test
    public void testCreatePersonWithoutArguments() {
        person = new Person();
        assertEquals("unknown", person.getFirstName()); // niet: assertEquels();
        assertEquals("unknown", person.getLastName());
    }

    @Test
    public void testCreatePersonFirstAndLastName() {
        person = new Person("first", "last");
        assertEquals("first", person.getFirstName());
        assertEquals("last", person.getLastName());
    }

    @Test
    public void testCreatePersonFirstNameLastNameAge() {
        assertEquals("first", person.getFirstName());
        assertEquals("last", person.getLastName());
        assertEquals(0, person.getAge());
    }

    @Test
    public void testCreatePersonWrongAge() {
        person = new Person("first", "last", -1);
        assertEquals(0, person.getAge());
    }
}
