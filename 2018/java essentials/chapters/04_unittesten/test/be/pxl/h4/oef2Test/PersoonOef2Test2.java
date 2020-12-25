package be.pxl.h4.oef2Test;



import be.pxl.h4.oef2.Persoon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersoonOef2Test2 {
	@Test
	public void testGeefNaamAfgekort(){
	    Persoon persoon =  new Persoon("langkous", "pipi");
		assertEquals("P.Langkous", persoon.geefNaamAfgekort());
	}

	@Test
    public void testInitiaalAchternaamHoofdletters(){
        Persoon persoon =  new Persoon("Heren", "Paul");
        assertEquals("HEPA", persoon.geefInitiaal());
    }

    @Test
    public void testInitiaalAchternaamKleineletters(){
        Persoon persoon =  new Persoon("heren", "Paul");
        assertEquals("hepa", persoon.geefInitiaal());
    }

    @Test
    public void testInitaalAchternaamAndertekenGevolgdDoorHoofdletter(){
        Persoon persoon =  new Persoon("'S Heren", "Paul");
        assertEquals("SHPA", persoon.geefInitiaal());
    }
    @Test
    public void testInitaalAchternaamAndertekenGevolgdDoorKleineLetter(){
        Persoon persoon =  new Persoon("'s Heren", "Paul");
        assertEquals("shpa", persoon.geefInitiaal());
    }
    @Test
    public void testEncrypteerNaam(){
        Persoon persoon =  new Persoon("Heren", "Paul");
        assertEquals("R0Jgtgp", persoon.encrypteerNaam(2));

    }
}
