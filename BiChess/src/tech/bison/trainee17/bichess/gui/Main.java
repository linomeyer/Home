package tech.bison.trainee17.bichess.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// ruft start() auf
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// öffnet GUI-Fenster
			GUIController.openMainWindow(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
