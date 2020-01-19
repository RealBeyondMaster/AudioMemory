package model;

import java.io.FileNotFoundException;
import java.io.InputStream;

import controller.ButtonController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Bright ButtonGame ist als Model die wichtigste Klasse. ButtonGame,
 *         kurz BG, vererbt von Button von JavaFX. Wir haben zusätzliche
 *         Methoden eingebaut, um Bilder zu setzten. Zudem gibt es einen Status
 *         (boolean) ButtonStatus. Ist dieser false, ist die Karte "verborgen".
 *         Ist die Karte aufgedeckt, wird der Status true und das Bild ändert
 *         sich. Wurden zwei gleiche Klänge gefunden, bleibt der Status true und
 *         das Bild verändert sich zu "ok" und verändert sich auch nicht mehr.
 *         Die Bilder werden importiert.
 * 
 *         Die Klasse ButtonController wird importiert und übergeben als
 *         Parameter. Zusätlzlich wird noch die Klasse MiniMiniMusikProg
 *         importiert, um die Tonhöhe zu übergeben und den Klang zu erzeugen.
 *
 *         Es gibt die Methode turnUp, welche durch den EventHandler aufgeruden
 *         wird, sobald ein BG angeklickt wurde. Dann wird auch der Button an
 *         den Controller übergeben. Die Methode playTone ist vom
 *         MiniMiniMusikProg und spielt dann den Ton ab.
 */
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

		this.tonePitch = tonePitch;
		InputStream play = getClass().getResourceAsStream("/image_play.png");
		InputStream stop = getClass().getResourceAsStream("/image_stop.png");
		InputStream play2 = getClass().getResourceAsStream("/image_play2.png");
		InputStream ok = getClass().getResourceAsStream("/image_ok.png");

		Image playButton = new Image(play, 90, 90, false, true);

		setGraphic(new ImageView(playButton));

		this.faceUp = new Image(play, 90, 90, false, true);
		this.faceDown = new Image(stop, 90, 90, false, true);
		this.play2 = new Image(play2, 90, 90, false, true);
		this.ok = new Image(ok, 90, 90, false, true);

		this.buttonStatus = false;
		this.controller = controller;

		setOnAction(new ButtonListener());
	};

	/**
	 * bei Mausklick, checke ob bereits geklickt. Wenn ja, tue nichts. Wenn noch
	 * nicht geklickt ändere das Bild und spiele die Tonhoehe
	 */
	public void turnUp() {

		player.playTone(this.getPitch());
		System.out.println("turnup 1");

		this.controller.turnUp(this);

		return;

	}

	/**
	 * Kartenstatus wieder "abdecken" und Bild entsprechend wechseln
	 */
	public void turnDown() {
		System.out.println("turdown 1");
		this.setImage(this.faceUp);
		this.buttonStatus = false;

	}

	/**
	 * Get tonePitch Methode
	 * 
	 * @return
	 */
	public int getPitch() {
		return tonePitch;

	}

	/**
	 * Eventhandler für den Klick des Objektes von BG
	 * 
	 * @author
	 */
	class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (buttonStatus)
				return; // buttonStatus = true;
			else {
				turnUp();

			}
		}

	}

	/**
	 * Methode um Bild zu wechseln
	 * 
	 * @param newState (Bild)
	 */
	public void setImage(Image newState) {
		setGraphic(new ImageView(newState));
		System.out.println("setimage methode");
	}

	/**
	 * Methode um Bild zu wechseln
	 */
	public void returnImagePlay() {
		this.setImage(this.play2);
		System.out.println("returnimagePlay");
	}

	/**
	 * Methode um Bild zu wechseln
	 */
	public void returnImageStop() {
		this.setImage(this.faceDown);
		System.out.println("returnimageStop");
	}

	/**
	 * buttonStatus wechseln, boolean
	 * 
	 * @param status
	 */
	public void setbuttonStatus(boolean status) {
		this.buttonStatus = status;
	}

	/**
	 * Bild zu "ok" wechseln
	 */
	public void setImageOk() {
		this.setImage(this.ok);

	}
}
