package model;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;


import controller.ButtonController;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonGame extends Button {

	int tonhoehe;
	Image faceUp;
	Image faceDown;
	ImageView front, back;
	Image now;
		//button schon angeklickt oder nicht
	boolean buttonStatus = false;
	
	
	
	//Konstruktor
	public ButtonGame(ButtonController controller, int tonhoehe) throws FileNotFoundException
								{
		
		this.tonhoehe = tonhoehe;
		InputStream input = getClass().getResourceAsStream("/image_ok.png");
		
		Image image = new Image(input);
		//ImageView b = new ImageView(input);
		
		//back = new ImageView(String.valueOf(getClass().getResource("image_play.png")));
        
		
		
		Button b = new Button("play",new ImageView(image));
		//b.setGraphic(b);
		
		//Button b = new Button("", new ImageView(image));
		
		//ImageView b = new ImageView(getClass().getResource("/res/image_play.png").toExternalForm());
		//b.setGraphic(new ImageView(image));
		//this.faceUp = new Image("image_play.png",100, 100, false, false);
		//this.faceDown = new Image("image_stop.png",100, 100, false, false);
		//this.now = faceDown;
		this.buttonStatus = false;
		//b.setPrefSize(400,400);
		
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
				//this.playMidiPlayer();
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
            turnUp();
           									}						
																			}; 
	
       //Get tonHohe Methode																		
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
					//	playMidiPlayer();
						}	
													}


		}
				//Funktion um Bild zu wechselb
				public void setImage(Image newState) {
						this.now = newState;
											}

		
}
