package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomGenTest {

	private RandomGen randomGen;

	@Before
	public void setUp() {
		randomGen = new RandomGen();
	}

	@After
	public void tearDown() {
		randomGen = null;
	}

	@Test
	public void testKeepElementsInList() {
		List<Integer> result1 = randomGen.orderTonePitch();

		assertEquals(8, result1.size());

	}

	// @Test(timeout = 1) beschränkt die Testzeit auf 1 Millisekunde, meldet Fehler,
	// falls Dauer länger (Fehlermeldung kommt aber nicht zuverlässig)
	// testet, ob ein return von orderTonePitch stattfindet
	@Test(timeout = 1)
	public void test2OrderTonePitch() {

		assertNotNull(randomGen.orderTonePitch());
	}

	@Test
	public void testTonePitchBetween50and100() {
		// Eine Liste mit 1000 Listen mit jeweils 8 Zahlen erstellen. Diese Zahlen
		// müssen
		// zwischen 60 und 120 sein.

		List<List<Integer>> listOfRandomNumbers = new ArrayList<>();

		for (int i = 0; i <= 1_000; i++) {
			listOfRandomNumbers.add(randomGen.orderTonePitch());
		}

		// dann
		for (List<Integer> randomNumbers : listOfRandomNumbers) {
			for (Integer randomNumber : randomNumbers) {
				// System.out.println(randomNumber);

				// testet den unteren Rand und oberen Rand
				assertTrue(randomNumber >= 50);
				assertTrue(randomNumber <= 100);			}

		}
	}


}
