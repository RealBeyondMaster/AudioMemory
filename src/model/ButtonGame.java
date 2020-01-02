package model;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import controller.ButtonController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ButtonGame extends Button {

	int tonePitch;
	Image faceUp;
	Image faceDown;
	ImageView front, back;
	Image now;

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
		InputStream input = getClass().getResourceAsStream("/image_play.png");

		// setzt Pixelgrösse fest, boolean: Ratio behalten oder nicht, boolean: Gute
		// Qualität oder nicht
		Image image = new Image(input, 70, 70, false, true);

		// Button b = new Button("play");
		setGraphic(new ImageView(image));

		// Button b = new Button("", new ImageView(image));

		// ImageView b = new
		// ImageView(getClass().getResource("/res/image_play.png").toExternalForm());
		// b.setGraphic(new ImageView(image));
		// this.faceUp = new Image("image_play.png",100, 100, false, false);
		// this.faceDown = new Image("image_stop.png",100, 100, false, false);
		// this.now = faceDown;
		this.buttonStatus = false;

		setOnAction(new ButtonListener());
	};

	private void setOnAction(ButtonListener buttonListener) {
		// TODO Auto-generated method stub

	}

	// bei Mausklick, checke ob bereits geklickt. Wenn ja, tue nichts. Wenn noch
	// nicht geklickt
	// ändere das Bild und spiele die Tonhoehe
	public void turnUp() {
		if (this.buttonStatus)
			return;
		else {
			this.setImage(this.faceUp);
			player.player(this.getPitch());
		}
	}

	public void turnDown() {
		if (!this.buttonStatus)
			return;
		else {
			this.setImage(this.faceDown);
			this.buttonStatus = false;
		}
	}

	// Eventhandler für Mausklicks
	EventHandler<MouseEvent> cardClicked = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			turnUp();
		}
	};

	// Get tonHohe Methode
	public int getPitch() {
		return tonePitch;

	}

	// zufällige Verteilung der Button-Objekte
	private List<Integer> randomizeButtons(List<Integer> tonePitch) {
		Collections.shuffle(tonePitch);

		return tonePitch;
	}

	class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			if (buttonStatus)
				return;
			else {
				setImage(faceUp);
				player.player(getPitch());
			}
		}

	}

	// Funktion um Bild zu wechselb
	public void setImage(Image newState) {
		this.now = newState;
	}

}
