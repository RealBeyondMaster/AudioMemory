package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import controller.ButtonController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.ButtonGame;
import model.RandomGen;

public class GUIMain extends Application {

	private Stage primaryStage;
	private BorderPane mainLayout;

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
		Scene scene = new Scene(mainLayout);

		scene.getStylesheets().add("StyleSheetMark2.css"); // StyleSheet von Mark
		// 12.12.19
		primaryStage.setScene(scene);
		primaryStage.show();

	}

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
		ArrayList<Integer> row1 = random.orderTonePitch();
		ArrayList<Integer> rowTotal = new ArrayList<>();
		rowTotal.addAll(row1);
		rowTotal.addAll(row1);
		Collections.shuffle(rowTotal);

		for (int i = 0; i < buttonsToAdd.length; i++) {
			int tonePitch = rowTotal.get(i); // Ausdruck tonhoehe zu tonepitch ändern

			try {
				ButtonGame newButton = new ButtonGame(controller, tonePitch);

				flowpaneButtons.getChildren().addAll(newButton);

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