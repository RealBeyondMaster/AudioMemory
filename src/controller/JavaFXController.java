package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JavaFXController {

	@FXML
	private Label fxCounter;

	public void initialize() {
		// fxCounter.setText("Counter: ");

	}

	public void setTextCounter(int counter) {
		// set text from another class
		fxCounter.setText("Counter: " + counter);
	}

}