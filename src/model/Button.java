package model;



import java.util.Collections;
import java.util.List;
import java.util.Random;

import controller.ButtonController;
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Button extends Application  {

	List<Integer> tonhoehe;
	
	//button schon angeklickt oder nicht
	boolean buttonStatus = false;
	
	//Konstruktor
	public Button(ButtonController controller, List<Integer> tonhoehe)
	{
		this.tonhoehe = tonhoehe;
					      };  
		
	   
	      
	      
	
	public void mousePressed(MouseEvent arg0) {
		this.playMidiPlayer();
		
	}
	
	//Eventhandler für Mausklicks
	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent event) { 
           //System.out.println("Hello World"); 
           //circle.setFill(Color.DARKSLATEBLUE);
        }}; 
	
	
	   public List<Integer> getTonhoehe() {
	    	  return tonhoehe;
	    	  
	      }
	   
		//zufällige Verteilung der Button-Objekte
		private List<Integer> randomizeButtons(List<Integer> tonhoehe) {
			Collections.shuffle(tonhoehe);
			
			return tonhoehe;
			}
			
		
}
