package be.pxl.h4.oef3Test;

import be.pxl.h4.oef3.Tijdstip;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TijdstipGetterSetterTest {

	private Tijdstip tijd;

	@Before
	public void init() {
		tijd = new Tijdstip(20, 30, 40);
	}

	public void testSetUurOk() {
		tijd.setUren(2);
		assertEquals(2, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testSetUurTeGroot() {
		tijd.setUren(25);
		assertEquals(1, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testSetMinutenOk() {
		tijd.setMinuten(2);
		assertEquals(20, tijd.getUren());
		assertEquals(2, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testSetMinutenTeGroot() {
		tijd.setMinuten(120);
		assertEquals(22, tijd.getUren());
		assertEquals(0, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testSetSecondenOk() {
		tijd.setSeconden(12);
		assertEquals(20, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(12, tijd.getSeconden());

	}

	@Test
	public void testSetSecondenTeGroot() {
		tijd.setSeconden(120);
		assertEquals(20, tijd.getUren());
		assertEquals(32, tijd.getMinuten());
		assertEquals(0, tijd.getSeconden());

	}

	@Test
	public void testVoegUrenToeMetParameterUrenOk() {
		tijd.voegUrenToe(2);
		assertEquals(22, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testVoegUrenToeMetParameterUrenTeGroot() {
		tijd.voegUrenToe(10);
		assertEquals(6, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testVoegUrenToeZonderParameterUren() {
		tijd.voegUrenToe();
		assertEquals(21, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testVoegMinutenToeOk() {
		tijd.voegMinutenToe(10);
		assertEquals(20, tijd.getUren());
		assertEquals(40, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testVoegMinutenToeTeGroot() {
		tijd.voegMinutenToe(60);
		assertEquals(21, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

	@Test
	public void testVoegSecondenToeOk() {
		tijd.voegSecondenToe(6);
		assertEquals(20, tijd.getUren());
		assertEquals(30, tijd.getMinuten());
		assertEquals(46, tijd.getSeconden());
	}

	@Test
	public void testVoegSecondenToeTeGroot() {
		tijd.voegSecondenToe(60);
		assertEquals(20, tijd.getUren());
		assertEquals(31, tijd.getMinuten());
		assertEquals(40, tijd.getSeconden());
	}

}
