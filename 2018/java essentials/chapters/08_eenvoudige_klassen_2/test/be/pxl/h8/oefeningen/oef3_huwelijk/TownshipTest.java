package be.pxl.h8.oefeningen.oef3_huwelijk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TownshipTest {

    @Test
    public void testConstructor() {
        Township township = new Township(1000, "Wellen");
        assertEquals(1000, township.getPostcode());
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
    public void testIfAllLettersOfNameAreLowerExceptFirst() {
        Township township = new Township(1000, "wElLeN");
        assertEquals("Wellen", township.getName());
    }

    @Test
    public void testIfAllNumbersAreRemoved() {
        Township township = new Township(1000, "W1e2l2l3e4n4");
        assertEquals("Wellen", township.getName());
    }

    @Test
    public void testIfAllLettersAreUppercaseOfterSymbols() {
        for (char c : Township.charAfterThisNeedsToBeUpper) {
            Township township = new Township(1000, "W" + c + "l");
            assertEquals('L', township.getName().charAt(2));
        }
    }

    @Test
    public void testToString() {
        Township township = new Township(1000, "Wellen");
        assertEquals("1000 Wellen", township.toString());
    }
}
