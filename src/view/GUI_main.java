package view;
import controller.ButtonController;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GUI_main extends Application {

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
		loader.setLocation(GUI_main.class.getResource("GUI.fxml"));
		try {
			mainLayout = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Scene scene = new Scene(mainLayout);
		// scene.setCursor(Cursor.HAND); aendert Cursor zu einer Hand
		// Image image = new Image("Bildschirmfoto%202019-11-28%20um%2010.23.47.png");
		// // pass in the image path
		// scene.setCursor(new ImageCursor(image));

		scene.getStylesheets().add("StyleSheetMark.css"); // StyleSheet von Mark
		// 12.12.19
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	
	// Hier muss noch eine For schleife, die alle 16 objekte erstellt. Einmal 8 Objekte, die dann nochmals kopiert wird, was 16 ergibt.
	private void showButtons() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Buttons.fxml"));
		//for (i=0 )
		FlowPane buttons = loader.load();
		mainLayout.setCenter(buttons);

	}

	public static void main(String[] args) {

		launch(args);

	}
	
	public void newGame() {
		this.primaryStage.show();
		
	}
	
	

}