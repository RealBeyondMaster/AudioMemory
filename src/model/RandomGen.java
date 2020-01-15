package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGen {

	private List<Integer> orderOfButtons;// das hier ist geändert, neu auch private
	private List<Integer> orderTonePitch;// das hier ist geändert, neu auch private

	public RandomGen() {
		orderOfButtons = new ArrayList<>();// das hier ist neu
		orderTonePitch = new ArrayList<>();// das hier ist neu
	}

	// gibt eine zufällige Reihenfolge von den Zahlen 0-16 wieder
	public List<Integer> orderOfButtons() {

		for (int i = 0; i < 8; i++) {
			orderOfButtons.add(i);

		}

		Collections.shuffle(orderOfButtons);
		return orderOfButtons;
	}

	// gibt eine zugällige Liste von 8 Zahlen zurück zwischen 60 und 120
	public List<Integer> orderTonePitch() {
		for (int i = 0; i < 8; i++) {
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(61) + 60;
			orderTonePitch.add(randomInt);

		}

		return orderTonePitch;
	}

}
