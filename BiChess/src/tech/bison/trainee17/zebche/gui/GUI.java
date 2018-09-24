package tech.bison.trainee17.zebche.gui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import tech.bison.trainee17.zebche.Square;
import tech.bison.trainee17.zebche.pieces.Piece;

public class GUI {
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
	public void OnMouseClickedPiece(MouseEvent mouseEvent) {
		try {
			ImageView pieceImg = (ImageView) mouseEvent.getSource();
			double xPos = pieceImg.getLayoutX();
			double yPos = pieceImg.getLayoutY();
			Square square = Converter.convertCoordinatesToSquare(xPos, yPos);
			Piece piece = Converter.convertIdToPiece(pieceImg.getId());
			ArrayList<Square> possibleMoveSquaresOfPiece = Main.chessboard.getPossibleMoveSquaresOfPiece(piece, square);

			Converter.convertSquaresToCoordinates(possibleMoveSquaresOfPiece);
			lblColorOnTurn.setText(square.toString() + " " + piece.toString());
		} catch (Exception e) {
		}
	}

	@FXML
	public void startNewGame() {
	}

}
