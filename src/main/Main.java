package main;
import view.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

//StartPunkt
public class Main extends Application {


	
		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			GUI newGame = new GUI();
			newGame.startNewGame();
			
		}
		
	


	
}
