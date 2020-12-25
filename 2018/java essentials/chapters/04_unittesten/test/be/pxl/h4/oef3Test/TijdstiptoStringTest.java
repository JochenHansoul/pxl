package be.pxl.h4.oef3Test;

import be.pxl.h4.oef3.Tijdstip;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TijdstiptoStringTest {

	@Test
	public void testToStringEngelseNotatie() {
		Tijdstip tijd = new Tijdstip(8, 4, 4);
		assertEquals("8:04 u", tijd.toStringTijd(false));
	}

	@Test
	public void testToStringEngelseNotatieMiddernacht() {
		Tijdstip tijd = new Tijdstip(0, 0, 0);
		assertEquals("0:00 u", tijd.toStringTijd(false));
	}

	@Test
	public void testToStringGeenEngelseNotatieVoorMiddag() {
		Tijdstip tijd = new Tijdstip(8, 5, 0);
		assertEquals("08:05 AM", tijd.toStringTijd(true));
	}

	@Test
	public void testToStringGeenEngelseNotatieNaMiddag() {
		Tijdstip tijd = new Tijdstip(18, 5, 5);
		assertEquals("06:05 PM", tijd.toStringTijd(true));
	}

	@Test
	public void testToStringGeenEngelseNotatieMiddag() {
		Tijdstip tijd = new Tijdstip(12, 0, 5);
		assertEquals("12:00 PM (noon)", tijd.toStringTijd(true));
	}

	@Test
	public void testToStringGeenEngelseNotatieMiddernacht() {
		Tijdstip tijd = new Tijdstip(24, 0, 5);
		assertEquals("12:00 AM (midnight)", tijd.toStringTijd(true));
	}

	@Test
	public void testToStringTechnischZonderVoorloopNullen() {
		Tijdstip tijd = new Tijdstip(15, 10, 20);
		assertEquals("15:10:20", tijd.toStringTechnisch());
	}

	@Test
	public void testToStringTechnischMetVoorloopNullen() {
		Tijdstip tijd = new Tijdstip(5, 1, 2);
		assertEquals("05:01:02", tijd.toStringTechnisch());
	}
}
