package controller;

import java.util.ArrayList;

import model.ButtonGame;

/**
 * @author Ali und Mark: ButtonController
 * 
 *         Der ButtonCtontroller hat einen Button Array, welche benötigt wird,
 *         um auf 2 zu zählen. Jedesmal, wenn ein Button angeklickt wird, wird
 *         der Controller aufgerufen und der Button wird übergeben. Dieser kommt
 *         in den Array. Ist nur ein Button im Array, wird passiert noch nichts.
 *         Falls es dann zwei Buttons im Array sind, werden diese miteinander
 *         verlglichen. Sind die Tonhöhen der Buttons nicht identisch, werden
 *         Sie zurückgesetz, und der Array wird geleert.
 * 
 *         Sind die Tonhöhen identisch, wird das Bild auf "OK" gesetzt, und der
 *         Status des Button bleibt auf "aufgedeckt" (boolean). Der Array wird
 *         geleert.
 */
public class ButtonController {

	private ArrayList<ButtonGame> clickedButton;

	public ButtonController() {

		this.clickedButton = new ArrayList<ButtonGame>(0);

	}

	/**
	 * @param button bei ButtonClick wird der Button entgegen genommen und in das
	 *               Array gesetzt. Sind es zwei Buttons im Array, werden die die
	 *               Buttons weitergegeben an die nächste Methode, isMatchingParis.
	 * 
	 */
	public boolean turnUp(ButtonGame button) {
		button.returnImageStop();
		button.setbuttonStatus(true);
		if (this.clickedButton.size() < 2)
			return isMatchingPairs(button);
		else
			return true;
	}

	/**
	 * @param button Vergleicht, ob nach 2 clicks angeklickte Buttons(Tonhöhe)
	 *               dieselben sind oder nicht. Passt entsprechend die Bilder und
	 *               den Status der Buttons nochmals an.
	 */
	public boolean isMatchingPairs(ButtonGame button) {
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

}
