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
		// scene.setCursor(Cursor.HAND); aendert Cursor zu einer Hand
		// Image image = new Image("Bildschirmfoto%202019-11-28%20um%2010.23.47.png");
		// // pass in the image path
		// scene.setCursor(new ImageCursor(image));
		GUIMain controller = loader.getController();
		controller.mainApp = this;

		this.scene.getStylesheets().add("StyleSheetMark2.css"); // StyleSheet von Mark
		// 12.12.19
		primaryStage.setScene(scene);
		primaryStage.show();

	}
// mark 30.12.19
//	private Parent createContent() {
//		Pane root = new Pane();
//		root.setPrefSize(600, 600);
//		return root;
//	}	

	// Hier muss noch eine For schleife, die alle 16 objekte erstellt. Einmal 8
	// Objekte, die dann nochmals kopiert wird, was 16 ergibt.

	// mark 30.12.19, mit einer Schleife 2x8 buttons (pro button ein anderer
	// tonepitch), ergibt 16 buttons
	public FlowPane showButtons() {

		int buttonsToAdd[] = new int[16];
		for (int i = 0; i < 8; i++) {
			buttonsToAdd[2 * i] = i;
			buttonsToAdd[2 * i + 1] = i;
		}
		randomizeButtonArray(buttonsToAdd);
		FlowPane flowpaneButtons = new FlowPane();
		ButtonController controller = new ButtonController();

		// Generiere die 8 Tonhöhen zufällig, und dies zweimal
		RandomGen random = new RandomGen();
		List<Integer> row1 = random.orderTonePitch();
		List<Integer> rowTotal = new ArrayList<>();
		rowTotal.addAll(row1);
		rowTotal.addAll(row1);
		Collections.shuffle(rowTotal);

		for (int i = 0; i < buttonsToAdd.length; i++) {
			int tonePitch = rowTotal.get(i); // Ausdruck tonhoehe zu tonepitch ändern

			try {
				ButtonGame newButton = new ButtonGame(controller, tonePitch);

				flowpaneButtons.getChildren().addAll(newButton); // Snene ist falsch, muss das Buttonfeld
																	// darstellen/generieren
				// int btnCount = flowpaneButtons.getChildren().size();
				// flowpaneButtons.getChildren().bind(flowpaneButtons.widthProperty().divide(btnCount));

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flowpaneButtons;
	}

	private void randomizeButtonArray(int[] t) {
		Random randomizer = new Random();
		for (int i = 0; i < t.length; i++) {
			int d = randomizer.nextInt(t.length);
			int s = t[d];
			t[d] = t[i];
			t[i] = s;

		}

	}

	@FXML
	private void handleRadioGirl() {
		System.out.println("handleGirl");
		mainApp.scene.getStylesheets().clear();
		mainApp.scene.getStylesheets().add("StyleSheetMark3.css");
	}

	@FXML
	private void handleRadioBoy() {
		System.out.println("handleBoy");
		mainApp.scene.getStylesheets().clear();
		// this.scene.getStylesheets().add("StyleSheetMark.css");
		mainApp.scene.getStylesheets().add("StyleSheetMark.css");
		counter.setText("1");

	}

	@FXML
	private void handleSlider() {
		System.out.println("slider" + slider.getValue());
	}

//	private void showButtons() throws IOException {
//
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("Buttons.fxml"));
//		// for (i=0 )
//		FlowPane buttons = loader.load();
//		mainLayout.setCenter(buttons);

	public static void main(String[] args) {

		launch(args);

	}

	public void newGame() {
		this.primaryStage.show();

	}

}