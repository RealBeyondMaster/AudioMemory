package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGen {

	private List<Integer> orderOfButtons;
	private List<Integer> orderTonePitch;

	public RandomGen() {
		orderOfButtons = new ArrayList<>();
		orderTonePitch = new ArrayList<>();
	}

	// gibt eine zufällige Reihenfolge von den Zahlen 0-7 wieder
	public List<Integer> orderOfButtons() {

		for (int i = 0; i < 8; i++) {
			orderOfButtons.add(i);

		}

		Collections.shuffle(orderOfButtons);
		return orderOfButtons;
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
