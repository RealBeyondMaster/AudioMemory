package controller;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SliderListener extends Application {

	@Override
	public void start(Stage stage) {

		Label label = new Label("Lautstärke:");

		Label infoLabel = new Label("-");
		Label infoLabel2 = new Label("-");// 2tes InfoLabel
		infoLabel.setTextFill(Color.BLUE);

		Slider slider = new Slider();

		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(80);

		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);

		slider.setBlockIncrement(20);

		// Adding Listener to value property.
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, //
					Number oldValue, Number newValue) {

				infoLabel.setText("Lautstärke: " + (int) slider.getValue());

				infoLabel2.setText("length: " + (int) slider.getValue());
			}
		});

		VBox root = new VBox();
		root.setPadding(new Insets(20));
		root.setSpacing(10);
		root.getChildren().addAll(label, slider, infoLabel, infoLabel2);

		stage.setTitle("JavaFX Slider (o7planning.org)");
		Scene scene = new Scene(root, 350, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}