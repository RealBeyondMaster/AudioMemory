package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGen {

	List<Integer> orderOfButtons = new ArrayList<>();
	ArrayList<Integer> orderTonePitch = new ArrayList<>();

	public RandomGen() {

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
	public ArrayList<Integer> orderTonePitch() {
		for (int i = 0; i < 8; i++) {
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(60) + 60;
			orderTonePitch.add(randomInt);

		}

		return orderTonePitch;
	}

}
