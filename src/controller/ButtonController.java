package controller;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import model.ButtonGame;

public class ButtonController {

	private ArrayList<ButtonGame> clickedButton;
	private int counter;

	public ButtonController() {

		this.counter = 0;
		this.clickedButton = new ArrayList<ButtonGame>(0);

	}

	// bei ButtonClick
	public boolean turnUp(ButtonGame button) {
		button.returnImageStop();
		button.setbuttonStatus(true);
		if (this.clickedButton.size() < 2)
			return isMatchingPairs(button);
		else
			return true;
	}

	// Vergleicht, ob nach 2 clicks angeklickte Buttons(Tonhöhe) dieselben sind
	// oder nicht.
	public boolean isMatchingPairs(ButtonGame button) {// auf public gewechselt,damit in der Testklasse sichbar(dort
														// Zeile28)
		this.clickedButton.add(button);
		if (this.clickedButton.size() == 2) {

			if (clickedButton.get(0).getPitch() == clickedButton.get(1).getPitch()) {
				clickedButton.get(0).setbuttonStatus(true);
				clickedButton.get(1).setbuttonStatus(true);
				clickedButton.get(0).setImageOk();
				clickedButton.get(1).setImageOk();
				this.clickedButton.clear();
				System.out.println("ismatchingspairs ist gleich 2");

			}

			else {
				System.out.println("ismatchingspairs ist ungleich 2");
				clickedButton.get(0).setbuttonStatus(false);
				clickedButton.get(1).setbuttonStatus(false);

				clickedButton.get(0).returnImagePlay();
				clickedButton.get(1).returnImagePlay();
				this.clickedButton.clear();

			}

		}

		return true;

	}

	// Zaehlt die Anzahl Clicks
	public void clickCounter(MouseEvent arg0) {

	}

	// Verändert die Tonlänge
	public void toneLength(int toneLength) {

	}

}
