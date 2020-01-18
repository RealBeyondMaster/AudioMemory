/**
 * 
 * Die Klasse RandomGen mi Zt derm Methode orderTonePitch gibt
 * eine List<Integer> mit 8 Zahlen zwischen 50 und 100 zurück, welche als Tonhöhe 
 * für die Klasse ButtonGame fungieren. 
 * 
 * 
 * 
 */

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGen {


	private List<Integer> orderTonePitch;

	public RandomGen() {

		orderTonePitch = new ArrayList<>();
	}



	// gibt eine zugällige Liste von 8 Zahlen zurück zwischen 50 und 100
	public List<Integer> orderTonePitch() {
		for (int i = 0; i < 8; i++) {
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(51) + 50;
			orderTonePitch.add(randomInt);

		}

		return orderTonePitch;
	}

}
