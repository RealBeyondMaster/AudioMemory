package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
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
		if (this.clickedButton.size() < 2)
			return isMatchingPairs(button);
		else
			return true;
	}

	// Vergleicht, ob nach 2 clicks angecklickte Buttons(Tonhöhe) dieselben sind
	// oder nicht.
	private boolean isMatchingPairs(ButtonGame button) {
		this.clickedButton.add(button);
		if (this.clickedButton.size() == 2) {

			if (clickedButton.get(0).getPitch() == clickedButton.get(1).getPitch()) {
				clickedButton.get(0).setbuttonStatus(true);
				clickedButton.get(1).setbuttonStatus(true);
				this.clickedButton.clear();

			}

			else {
			 clickedButton.get(0).setbuttonStatus(false);
			 clickedButton.get(1).setbuttonStatus(false);

				clickedButton.get(0).returnImage();
				clickedButton.get(1).returnImage();
				this.clickedButton.clear();

			}

		}

		return true;

	}

	/*
	 * public void actionPerformed(ActionEvent event) { for (int i = 0; i <
	 * this.clickedButton.size(); i++) { ButtonGame button =
	 * this.clickedButton.get(i); button.turnDown(); } this.clickedButton.clear(); }
	 */

	
/*	public void actionPerformed(ActionEvent event) {
	*	for (int i = 0; i < clickedButton.size(); i++) {
	*		ButtonGame button = clickedButton.get(i);
	*		button.turnDown();
*
*		}
*		this.clickedButton.clear();
	};*/

	// Zaehlt die Anzahl Clicks
	public void clickCounter(MouseEvent arg0) {

	}

	// Verändert die Tonlänge
	public void toneLength(int toneLength) {

	}

}
