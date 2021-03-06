package model;

import java.io.FileNotFoundException;
import java.io.InputStream;

import controller.ButtonController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonGame extends Button {

	private int tonePitch;
	private Image faceUp;
	private Image faceDown;
	private Image play2;
	private Image ok;
	private ButtonController controller;

	// button schon angeklickt oder nicht
	boolean buttonStatus = false;

	// Midiplayer
	MiniMiniMusikProg player = new MiniMiniMusikProg();

	// Konstruktor
	public ButtonGame(ButtonController controller, int tonePitch) throws FileNotFoundException {
		// ImageView b = new ImageView(input);

		// back = new
		// ImageView(String.valueOf(getClass().getResource("image_play.png")));
		this.tonePitch = tonePitch;
		InputStream play = getClass().getResourceAsStream("/image_play.png");
		InputStream stop = getClass().getResourceAsStream("/image_stop.png");
		InputStream play2 = getClass().getResourceAsStream("/image_play2.png");
		InputStream ok  = getClass().getResourceAsStream("/image_ok.png");
		// setzt Pixelgrösse fest, boolean: Ratio behalten oder nicht, boolean: Gute
		// Qualität oder nicht
		Image playButton = new Image(play, 90, 90, false, true);
		// Image stopButton = new Image(stop, 70, 70, false, true);

		// Button b = new Button("play");
		setGraphic(new ImageView(playButton));


		this.faceUp = new Image(play, 90, 90, false, true);
		this.faceDown = new Image(stop, 90, 90, false, true);
		this.play2 = new Image(play2, 90, 90, false, true);
		this.ok = new Image(ok, 90, 90, false, true);

	//	this.faceUp = new Image(play, 90, 90, false, true);
		//this.faceDown = new Image(stop, 90, 90, false, true);
		//this.play2 = new Image(play2, 90, 90, false, true);

		this.buttonStatus = false;
		this.controller = controller;

		setOnAction(new ButtonListener());
	};

	// bei Mausklick, checke ob bereits geklickt. Wenn ja, tue nichts. Wenn noch
	// nicht geklickt
	// ändere das Bild und spiele die Tonhoehe
	public void turnUp() {

		player.player(this.getPitch());
		System.out.println("turnup 1");
		// this.setImage(this.faceDown);
		// this.buttonStatus = this.controller.turnUp(this);
		this.controller.turnUp(this);
		// if (this.buttonStatus) {
		/// System.out.println("turnup 1");
		// this.setImage(this.faceDown);

		return;

	}

	public void turnDown() {
		System.out.println("turdown 1");
		this.setImage(this.faceUp);
		this.buttonStatus = false;

	}

	/*
	 * Eventhandler für Mausklicks EventHandler<MouseEvent> cardClicked = new
	 * EventHandler<MouseEvent>() {
	 * 
	 * @Override public void handle(MouseEvent event) { turnUp(); } };
	 */

	// Get tonePitch Methode
	public int getPitch() {
		return tonePitch;

	}

	class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (buttonStatus)
				return;
			else {
				turnUp();
				// buttonStatus = true;
			}
		}

	}

	// Funktion um Bild zu wechselb
	public void setImage(Image newState) {
		setGraphic(new ImageView(newState));
		System.out.println("setimage methode");
	}

	public void returnImagePlay() {
		this.setImage(this.play2);
		System.out.println("returnimagePlay");
		// this.buttonStatus = false;
	}

	public void returnImageStop() {
		this.setImage(this.faceDown);
		System.out.println("returnimageStop");
		// this.buttonStatus = false;
	}

	// buttonStatus setzten
	public void setbuttonStatus(boolean status) {
		this.buttonStatus = status;
	}
	
	//ButtonStatus ok
	public void setImageOk() {
		this.setImage(this.ok);

		
	}
}
