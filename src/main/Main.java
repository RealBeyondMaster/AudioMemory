package main;
import javafx.application.Application;
import view.GUI_main;



//StartPunkt
public class Main {


	
		//starte Spiel
		public void main(String[] args) throws Exception {
			
			GUI_main newGame = new GUI_main();
			Application.launch(newGame.getClass(), args);
			
			

			
		}
		
	


	
}
