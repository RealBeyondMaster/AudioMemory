package model;



import java.util.Collections;
import java.util.List;
import java.util.Random;

import controller.ButtonController;
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonGame {

	int tonhoehe;
	Image faceUp;
	Image faceDown;
	Image now;
		//button schon angeklickt oder nicht
	boolean buttonStatus = false;
	
	
	
	//Konstruktor
	public ButtonGame(ButtonController controller, int tonhoehe, Image faceUp, Image faceDown)
								{
		Button b = new Button();
		this.tonhoehe = tonhoehe;
		this.faceUp = faceUp;
		this.faceDown = faceDown;
		this.now = faceDown;
		setOnAction(new ButtonListener());
							      };  
		
	   
	      
	      
	private void setOnAction(ButtonListener buttonListener) {
		// TODO Auto-generated method stub
		
	}




	//bei Mausklick, checke ob bereits geklickt. Wenn ja, tue nichts. Wenn noch nicht geklickt
	// ändere das Bild und spiele die Tonhoehe				      
	public void turnUp() 	{
		if (this.buttonStatus) return;
		else  {
				this.setImage(this.faceUp);
				this.playMidiPlayer();
									}
							}
	
	
	public void turnDown() 	{
		if (!this.buttonStatus) return;
		else  {
				this.setImage(this.faceDown);
				this.buttonStatus = false;
									}
							}
	
	//Eventhandler für Mausklicks
	EventHandler<MouseEvent> cardClicked = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent event) { 
            this.turnUp();
           									}						
																			}; 
	
	
	   public int  getTonhoehe() {
	    	  return tonhoehe;
	    	  
	      									}
	   
		//zufällige Verteilung der Button-Objekte
		private List<Integer> randomizeButtons(List<Integer> tonhoehe) {
			Collections.shuffle(tonhoehe);
			
			return tonhoehe;											}
			
		class ButtonListener implements EventHandler<ActionEvent>
		{

			@Override
			public void handle(ActionEvent event) {
		
				if (buttonStatus) return;
				else  {
						setImage(faceUp);
						playMidiPlayer();
						}	
													}

			private void setImage(Image faceUp) {
				// TODO Auto-generated method stub
				this.
			}
		}
		
}
