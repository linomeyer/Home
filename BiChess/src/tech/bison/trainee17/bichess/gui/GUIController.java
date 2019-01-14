package tech.bison.trainee17.bichess.gui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tech.bison.trainee17.bichess.Chessboard;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.pieces.Piece;

public class GUIController {
	@FXML
	Rectangle E1;
	@FXML
	Rectangle H1;
	@FXML
	Rectangle A1;
	@FXML
	Rectangle B1;
	@FXML
	Rectangle C1;
	@FXML
	Rectangle D1;
	@FXML
	Rectangle H2;
	@FXML
	Rectangle F1;
	@FXML
	Rectangle F2;
	@FXML
	Rectangle G2;
	@FXML
	Rectangle D2;
	@FXML
	Rectangle E2;
	@FXML
	Rectangle B2;
	@FXML
	Rectangle A2;
	@FXML
	Rectangle A3;
	@FXML
	Rectangle C2;
	@FXML
	Rectangle G3;
	@FXML
	Rectangle H3;
	@FXML
	Rectangle E3;
	@FXML
	Rectangle B3;
	@FXML
	Rectangle C3;
	@FXML
	Rectangle D3;
	@FXML
	Rectangle H4;
	@FXML
	Rectangle F3;
	@FXML
	Rectangle F4;
	@FXML
	Rectangle G4;
	@FXML
	Rectangle D4;
	@FXML
	Rectangle E4;
	@FXML
	Rectangle B4;
	@FXML
	Rectangle C4;
	@FXML
	Rectangle A4;
	@FXML
	Rectangle G5;
	@FXML
	Rectangle H5;
	@FXML
	Rectangle E5;
	@FXML
	Rectangle F5;
	@FXML
	Rectangle D5;
	@FXML
	Rectangle C5;
	@FXML
	Rectangle H6;
	@FXML
	Rectangle B5;
	@FXML
	Rectangle G6;
	@FXML
	Rectangle A5;
	@FXML
	Rectangle F6;
	@FXML
	Rectangle E6;
	@FXML
	Rectangle D6;
	@FXML
	Rectangle C6;
	@FXML
	Rectangle A6;
	@FXML
	Rectangle G7;
	@FXML
	Rectangle F7;
	@FXML
	Rectangle E7;
	@FXML
	Rectangle D7;
	@FXML
	Rectangle B6;
	@FXML
	Rectangle C7;
	@FXML
	Rectangle H8;
	@FXML
	Rectangle H7;
	@FXML
	Rectangle G8;
	@FXML
	Rectangle A7;
	@FXML
	Rectangle F8;
	@FXML
	Rectangle E8;
	@FXML
	Rectangle D8;
	@FXML
	Rectangle C8;
	@FXML
	Rectangle B8;
	@FXML
	Rectangle B7;
	@FXML
	Rectangle A8;
	@FXML
	Rectangle G1;
	@FXML
	Button btnStart;
	@FXML
	Label lblColorOnTurn;
	@FXML
	Label lblGameState;
	@FXML
	Label lblLastTurn;
	@FXML
	ImageView WK;
	@FXML
	ImageView BP1;
	@FXML
	ImageView BR1;
	@FXML
	ImageView BP2;
	@FXML
	ImageView BN1;
	@FXML
	ImageView BP3;
	@FXML
	ImageView BB1;
	@FXML
	ImageView BP4;
	@FXML
	ImageView BQ;
	@FXML
	ImageView BP5;
	@FXML
	ImageView BK;
	@FXML
	ImageView BP6;
	@FXML
	ImageView BB2;
	@FXML
	ImageView BP7;
	@FXML
	ImageView BP8;
	@FXML
	ImageView BN2;
	@FXML
	ImageView BR2;
	@FXML
	ImageView WP1;
	@FXML
	ImageView WP2;
	@FXML
	ImageView WP3;
	@FXML
	ImageView WP4;
	@FXML
	ImageView WP5;
	@FXML
	ImageView WP6;
	@FXML
	ImageView WP7;
	@FXML
	ImageView WP8;
	@FXML
	ImageView WR1;
	@FXML
	ImageView WN1;
	@FXML
	ImageView WB1;
	@FXML
	ImageView WQ;
	@FXML
	ImageView WR2;
	@FXML
	ImageView WN2;
	@FXML
	ImageView WB2;

	public Chessboard chessboard;
	public static Scene scene;

	public static void openMainWindow(Stage primaryStage) throws IOException {
		// Titel des Fensters setzen
		primaryStage.setTitle("Schach");
		// Klasse die FXML-Dateien lädt
		FXMLLoader loader = new FXMLLoader();
		// Pfad der FXML-GUI
		loader.setLocation(Main.class.getResource("main.fxml"));
		// erstellt ein neues controller-Objekt
		GUIController controller = loader.<GUIController>getController();
		// Lädt FXML-Datei in ein Layout
		Pane root = (Pane) loader.load();
		// Macht aus Layout ein Scene
		scene = new Scene(root);
		primaryStage.setScene(scene);
		// Zeigt das GUI an
		primaryStage.show();
	}

	@FXML
	public void OnMouseClickedPiece(MouseEvent mouseEvent) {
		ArrayList<Rectangle> rectangles = new ArrayList<>();
		try {
			ImageView pieceImg = (ImageView) mouseEvent.getSource();
			double xPos = pieceImg.getLayoutX();
			double yPos = pieceImg.getLayoutY();
			Square square = Converter.convertCoordinatesToSquare(xPos, yPos);
			Piece piece = Converter.convertIdToPiece(pieceImg.getId());
			lblColorOnTurn.setText(square.toString() + " " + piece.toString());
			ArrayList<Square> possibleMoveSquaresOfPiece = chessboard.getPossibleMoveSquaresOfPiece(piece, square);
			rectangles = Converter.convertSquaresToRectangles(possibleMoveSquaresOfPiece);
			colorizeRectangles(rectangles);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void colorizeRectangles(ArrayList<Rectangle> rectangles) {
		for (Rectangle rectangle : rectangles) {
			rectangle.setFill(javafx.scene.paint.Color.YELLOW);
		}
	}

	@FXML
	public void startNewGame() {
		start();
	}

	private void start() {
		// TODO Auto-generated method stub

	}
}
