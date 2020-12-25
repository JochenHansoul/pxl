/*package bp.pxl.h4.oef5Test;

import static org.junit.Assert.*;

import be.pxl.h4.oef5.Datum;
import org.junit.Before;
import org.junit.Test;

public class DatumTest {
	private Datum datum;

	@Before
	public void init() {
		datum = new Datum(2, 3, 2017);
	}

	@Test
	public void testDefaultConstructor() {
		Datum datumDefault = new Datum();
		assertEquals("Fout bij de dag", 1, datumDefault.getDag());
		assertEquals("Fout bij de maand", 1, datumDefault.getMaandNr());
		assertEquals("Fout bij het jaar", 2018, datumDefault.getJaar());

	}

	@Test
	public void testConstructor() {
		assertEquals("Fout bij de dag", 2, datum.getDag());
		assertEquals("Fout bij de maand",3,  datum.getMaandNr());
		assertEquals("fout bij het jaar", 2017, datum.getJaar());

	}

	@Test
	public void testCopyConstructor() {
		Datum ander = new Datum(datum);
		assertEquals(2, ander.getDag());
		assertEquals(3, ander.getMaandNr());
		assertEquals(2017, ander.getJaar());
	}

	@Test
	public void testSetDag() {
		datum.setDag(5);
		assertEquals(5, datum.getDag());
	}

	@Test
	public void testSetMaandTussen1en12() {
		datum.setMaand(5);
		assertEquals(5, datum.getMaandNr());
	}

	@Test
	public void testSetMaandKleinerdan1() {
		datum.setMaand(-6);
		assertEquals(1, datum.getMaandNr());
	}

	@Test
	public void testSetMaandGroterdan12() {
		datum.setMaand(16);
		assertEquals(12, datum.getMaandNr());
	}

	@Test
	public void testGetDag() {
		assertEquals(2, datum.getDag());
	}

	@Test
	public void testGetMaandNr() {
		assertEquals(3, datum.getMaandNr());
	}

	@Test
	public void testGetMaandNaam() {
		assertEquals("maart", datum.getMaandNaam());
	}

	@Test
	public void testGetJaar() {
		assertEquals(2017, datum.getJaar());
	}

	@Test
	public void testToString() {
		assertEquals("2 maart 2017", datum.toString());
	}
}
*/