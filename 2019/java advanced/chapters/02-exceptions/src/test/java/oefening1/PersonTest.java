package oefening1;

import org.junit.Before;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DateTimeException;

public class PersonTest {
    private static Person person;

    @Before
    public void createPerson() throws Exception {
        person = new Person("name", 2000, 1, 1);
    }

    @Test
    public void dateExceptionTest() {
        assertThrows(DateTimeException.class, ()-> {
            new Person("name", 2000, 0, 1);
        });
    }

    @Test
    public void person_getNameTest() {
        if (person != null) {
            assertEquals("name", person.getName());
        }
    }
}