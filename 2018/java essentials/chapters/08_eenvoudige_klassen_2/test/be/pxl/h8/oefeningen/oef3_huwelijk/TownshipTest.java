package be.pxl.h8.oefeningen.oef3_huwelijk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TownshipTest {

    private Township township;

    @Before
    public void initialize() {
        township = new Township(1000, "Wellen");
    }

    @Test
    public void testGetNumber() {
        assertEquals(1000, township.getPostcode());
    }

    @Test
    public void testGetName() {
        assertEquals("Wellen", township.getName());
    }

    @Test
    public void testPostcodeTooLong() {
        Township township = new Township(10000, "Wellen");
        assertEquals(1000, township.getPostcode());
    }

    @Test
    public void testPostcodeTooShort() {
        Township township = new Township(100, "Wellen");
        assertEquals(1000, township.getPostcode());
    }

    @Test
    public void testAllLettersAreLowercaseExceptFirst() {
        Township township = new Township(1000, "wElLeN");
        assertEquals("Wellen", township.getName());
    }

    @Test
    public void testAllNumbersAreRemoved() {
        Township township = new Township(1000, "W1e2l2l3e4n4");
        assertEquals("Wellen", township.getName());
    }

    @Test
    public void testAllLettersAreUppercaseAfterSymbols() {
        for (char c : Township.charAfterThisNeedsToBeUpper) {
            Township township = new Township(1000, "W" + c + "l");
            assertEquals('L', township.getName().charAt(2));
        }
    }

    @Test
    public void testToString() {
        assertEquals("1000 Wellen", township.toString());
    }
}
