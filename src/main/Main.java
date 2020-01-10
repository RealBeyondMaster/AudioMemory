package main;

import javafx.application.Application;
import view.GUIMain;

//StartPunkt
public class Main {

	// starte Spiel
	public static void main(String[] args) throws Exception {

		GUIMain newGame = new GUIMain();
		Application.launch(newGame.getClass(), args);

	}

}
