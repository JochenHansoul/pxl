package be.pxl.h4.voorbeeldPersoonTest;


import org.junit.Test;
import be.pxl.h4.voorbeeldPersoon.Persoon;

import static org.junit.Assert.assertEquals;

public class PersoonTest {

    @Test
    public void testGetVolledigeNaam( ) {
        Persoon p = new Persoon("Flater", "Guust");
        assertEquals("Guust Flater", p.getVolledigeNaam( ));
    }

    @Test
    public void testGetVolledigeNaamIndienNaamNull() {
        Persoon p = new Persoon(null, "Guust");
        assertEquals("Guust ?", p.getVolledigeNaam( ));
    }

    @Test
    public void testGetVolledigeNaamIndienVoornaamNull() {
        Persoon p = new Persoon("Flater", null);
        assertEquals("? Flater", p.getVolledigeNaam( ));
    }

}