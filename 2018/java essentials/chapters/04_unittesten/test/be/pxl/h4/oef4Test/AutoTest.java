package be.pxl.h4.oef4Test;

import be.pxl.h4.oef4.Auto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutoTest {
	private Auto auto;

	@Before
	public void init() {
		auto = new Auto("BMW", "318", 2012, "zwart", 160);

	}

	@Test
	public void testConstructorZonderParameters() {
		Auto autoDefault = new Auto();
		assertEquals("Fout bij het merk", "VW", autoDefault.getMerk());
		assertEquals("Fout bij het model", "Polo", autoDefault.getModel());
		assertEquals("Fout bij het bouwjaar", 2018, autoDefault.getBouwjaar());
		assertEquals("Fout bij de kleur", "grijs", autoDefault.getKleur());
		assertEquals("Fout bij de maximale snelheid", 160, autoDefault.getMaxSnelheid());

	}

	@Test
	public void testConstructorMetAlleEigenschappen() {

		assertEquals("Fout bij het merk", "BMW", auto.getMerk());
		assertEquals("Fout bij het model", "318", auto.getModel());
		assertEquals("Fout bij het bouwjaar", 2012, auto.getBouwjaar());
		assertEquals("Fout bij de kleur", "zwart", auto.getKleur());
		assertEquals("Fout bij de maximale snelheid", 160, auto.getMaxSnelheid());

	}

	@Test
	public void testConstructorMetAlleEigenschappenWaardeMaxSnelheidTeGroot() {
		Auto auto = new Auto("BMW", "318", 2012, "zwart", 210);
		assertEquals("Fout bij het merk", "BMW", auto.getMerk());
		assertEquals("Fout bij het model", "318", auto.getModel());
		assertEquals("Fout bij het bouwjaar", 2012, auto.getBouwjaar());
		assertEquals("Fout bij de kleur", "zwart", auto.getKleur());
		assertEquals("Fout bij de maximale snelheid", 180, auto.getMaxSnelheid());

	}

	@Test
	public void testCopyConstructor() {

		Auto copyAuto = new Auto(auto);
		assertEquals("BMW", copyAuto.getMerk());
		assertEquals("318", copyAuto.getModel());
		assertEquals(2012, copyAuto.getBouwjaar());
		assertEquals("zwart", copyAuto.getKleur());
		assertEquals(160, copyAuto.getMaxSnelheid());

	}

	@Test
	public void testGetMerk() {
		assertEquals("BMW", auto.getMerk() );
	}

	@Test
	public void testSetMerk() {

		auto.setMerk("test");
		assertEquals( "test", auto.getMerk());

	}

	@Test
	public void testGetModel() {

		assertEquals("318", auto.getModel());

	}

	@Test
	public void testSetModel() {

		auto.setModel("model 5");
		assertEquals("model 5", auto.getModel() );

	}

	@Test
	public void testGetKleur() {

		assertEquals("zwart", auto.getKleur());

	}

	@Test
	public void testSetKleur() {

		auto.setKleur("groen");
		assertEquals( "groen", auto.getKleur());

	}

	@Test
	public void testGetBouwjaar() {

		assertEquals(auto.getBouwjaar(), 2012);

	}

	@Test
	public void testSetBouwjaar() {

		auto.setBouwjaar(2000);
		assertEquals(2000, auto.getBouwjaar());

	}

	@Test
	public void testGetMaxSnelheid() {

		assertEquals(160, auto.getMaxSnelheid());

	}

	@Test
	public void testSetMaxSnelheid() {

		auto.setMaxSnelheid(100);
		assertEquals(100, auto.getMaxSnelheid());

	}

	@Test
	public void testSetMaxSnelheidTeGroot() {

		auto.setMaxSnelheid(200);
		assertEquals(180, auto.getMaxSnelheid());

	}

	@Test
	public void testGetMaximum() {
		assertEquals(180, Auto.getMaximum());

	}

	@Test
	public void testGetAantal() {

		int beforeConstructor = Auto.getAantal();
		new Auto();
		new Auto();
		int afterConstructor = Auto.getAantal();
		assertTrue(afterConstructor - beforeConstructor == 2);

	}

}
