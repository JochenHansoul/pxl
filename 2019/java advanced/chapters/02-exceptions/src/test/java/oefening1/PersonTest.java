package oefening1;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.DateTimeException;

public class PersonTest {
    private static Person person;

    @Before
    public void createPerson() throws Exception {
        person = new Person("name", 2000, 1, 1);
    }

    @Test
    public void dateExceptionTest() {
        Assertions.assertThrows(DateTimeException.class, ()-> {
            new Person("name", 2000, 0, 1);
        });
    }

    @Test
    public void person_getNameTest() {
        Assertions.assertEquals("name", person.getName());
    }
}