package tech.bison.trainee17.zebche.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Schach");

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("main.fxml"));
		Pane root = (Pane) loader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
