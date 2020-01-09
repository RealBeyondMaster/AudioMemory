package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomGenTester {

	private RandomGen RandomGen;

	@Before
	public void setUp() throws Exception {
		RandomGen = new RandomGen();
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	// @Test
	// public void test2() {
	// assertEquals(expected, actual);
	// }

	@Test
	public void testKeepElementsInList() {
		List<Integer> result1 = RandomGen.orderOfButtons();
		List<Integer> result2 = RandomGen.orderOfButtons();

		assertEquals(16, result1.size());
		// assertEquals(8, result1.size());
	}

	// testet, ob kein return von orderTonePitch stattfindet, gibt dadurch auch die
	// Werte des Arrays aus (gut zur Kontrolle, ob zw. 60 und 120)
	// @Test(timeout = 1) beschränkt die Testzeit auf 1 Millisekunde, meldet Fehler,
	// falls Dauer länger (Fehlermeldung kommt aber nicht zuverlässig)
	@Test(timeout = 1)
	public void testOrderTonePitch() {

		assertNull(RandomGen.orderTonePitch());
	}

	// testet, ob ein return von orderTonePitch stattfindet
	@Test
	public void test2OrderTonePitch() {

		assertNotNull(RandomGen.orderTonePitch());
	}

	// testet, ob ein return von orderOfButtons stattfindet
	@Test(timeout = 1)
	public void testTonePitchBetween60and120() {

		assertNotNull(RandomGen.orderOfButtons());
	}
//	@Test
//	public void testTonePitchBetween60and120() {
//
//		assertNotNull(RandomGen.orderTonePitch());
//	}
}
