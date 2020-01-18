/**
 * 
 * Die Hauptklasse für die grafische Oberfläche und die wichtigste Klasse für das View Packet.
 * Ein grosser Teil wurde mit Hilfde von SceneBuilder erstellt.
 * Hier werden die ButtonGame Objekte erstellt und in eine Flowpane eingefügt.
 * 
 * Wie erwähnt sind der Slider und der Counter noch nicht funktionitüchtig, aufgrund
 * des Controllers von Scenebuilder und dessen Aufbau und unserem mangelndem Verständnis.
 * 
 * 
 * 
 * 
 */

package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import controller.ButtonController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.ButtonGame;
import model.RandomGen;

public class GUIMain extends Application {

	private Stage primaryStage;
	private BorderPane mainLayout;
	private Scene scene;
	private GUIMain mainApp;
	@FXML
	private TextField counter;
	@FXML
	private Slider slider;
	@FXML
	private MenuItem about;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Audio Memory");
		showMainView();
		showButtons();
	}

	private void showMainView() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GUIMain.class.getResource("GUIRadio.fxml"));
		try {
			mainLayout = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		mainLayout.setCenter(showButtons());

		this.scene = new Scene(mainLayout);
		
		GUIMain controller = loader.getController();
		controller.mainApp = this;

		this.scene.getStylesheets().add("styleSheetGirl.css"); 
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	// Methode, um Objekte von ButtonGame zu erstellen, und dies 8 Mal, und dann zu
	// verdoppeln
	public FlowPane showButtons() {

		int buttonsToAdd[] = new int[16];
		for (int i = 0; i < 8; i++) {
			buttonsToAdd[2 * i] = i;
			buttonsToAdd[2 * i + 1] = i;
		}

		// randomisere die Reihenfolge der Zahlen/Position der Objekte
		randomizeButtonArray(buttonsToAdd);
		FlowPane flowpaneButtons = new FlowPane();
		ButtonController controller = new ButtonController();

		// Generiere die 8 Tonhöhen zufällig, und dies zweimal
		RandomGen random = new RandomGen();
		List<Integer> row1 = random.orderTonePitch();
		List<Integer> rowTotal = new ArrayList<>();
		// Hier werden die 8 Töne zweimal in ein Array eingespiesen, damit es jeweils
		// eine Kopie gibt
		rowTotal.addAll(row1);
		rowTotal.addAll(row1);
		Collections.shuffle(rowTotal);

		// Generiere die 16 Objekte, übergebe jedesmal einen Controller und eine
		// zufällig generierte Tonhöhe (int) als Parameter
		for (int i = 0; i < buttonsToAdd.length; i++) {
			int tonePitch = rowTotal.get(i); 

			try {
				ButtonGame newButton = new ButtonGame(controller, tonePitch);

				flowpaneButtons.getChildren().addAll(newButton);

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}

		}

		return flowpaneButtons;
	}

	//Methode, um die Reihenfolge der Buttons zu randomiseren
	private void randomizeButtonArray(int[] t) {
		Random randomizer = new Random();
		for (int i = 0; i < t.length; i++) {
			int d = randomizer.nextInt(t.length);
			int s = t[d];
			t[d] = t[i];
			t[i] = s;

		}

	}

	
	//Methoden, um das CSS zu wechseln
	@FXML
	private void handleRadioGirl() {
		System.out.println("handleGirl");
		mainApp.scene.getStylesheets().clear();
		mainApp.scene.getStylesheets().add("styleSheetGirl.css");
	}

	@FXML
	private void handleRadioBoy() {
		System.out.println("handleBoy");
		mainApp.scene.getStylesheets().clear();
		// this.scene.getStylesheets().add("StyleSheetMark.css");
		mainApp.scene.getStylesheets().add("styleSheetBoy.css");
		counter.setText("1");

	}

	
	//Methoden für den Slider, nichts funktionstüchtig, resp. machen noch nichts.
	@FXML
	private void handleSlider() {
		System.out.println("slider" + slider.getValue());
	}

	@FXML
	private void getSliderValue() {
		System.out.println("slider" + slider.getValue());
	}

	@FXML
	private void openHelpAbout() {
		System.out.println("openHelpAbout");

	}

	
	//Start Methode
	public static void main(String[] args) {

		launch(args);

	}

	public void newGame() {
		this.primaryStage.show();

	}

}