package tech.bison.trainee17.bichess.gui;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.pieces.Bishop;
import tech.bison.trainee17.bichess.pieces.King;
import tech.bison.trainee17.bichess.pieces.Knight;
import tech.bison.trainee17.bichess.pieces.Pawn;
import tech.bison.trainee17.bichess.pieces.Piece;
import tech.bison.trainee17.bichess.pieces.Piece.Color;
import tech.bison.trainee17.bichess.pieces.Queen;
import tech.bison.trainee17.bichess.pieces.Rook;

public class Converter {

	public static Square convertCoordinatesToSquare(double xPos, double yPos) {
		int xSquarePos = (int) (xPos / 75 + 1);
		int ySquarePos = (int) (yPos / 75);
		ySquarePos = 8 - ySquarePos;
		return new Square(xSquarePos, ySquarePos);
	}

	public static Piece convertIdToPiece(String id) {
		switch (id.substring(0, 2)) {
		case "WK":
			return new King(Color.WHITE);
		case "BK":
			return new King(Color.BLACK);
		case "WQ":
			return new Queen(Color.WHITE);
		case "BQ":
			return new Queen(Color.BLACK);
		case "WB":
			return new Bishop(Color.WHITE);
		case "BB":
			return new Bishop(Color.BLACK);
		case "WN":
			return new Knight(Color.WHITE);
		case "BN":
			return new Knight(Color.BLACK);
		case "WR":
			return new Rook(Color.WHITE);
		case "BR":
			return new Rook(Color.BLACK);
		case "WP":
			return new Pawn(Color.WHITE);
		case "BP":
			return new Pawn(Color.BLACK);
		}
		return null;
	}

	public static ArrayList<double[]> convertSquaresToCoordinates(ArrayList<Square> possibleMoveSquaresOfPiece) {
		ArrayList<double[]> coordinatesOfSquares = new ArrayList<>();
		for (Square square : possibleMoveSquaresOfPiece) {
			double xPos = square.getXCoordinate() * 75;
			double yPos = 600 - (square.getYCoordinate() * 75);
			double[] coordinatesOfSquare = { xPos, yPos };
			coordinatesOfSquares.add(coordinatesOfSquare);
		}
		return coordinatesOfSquares;
	}

	public static ArrayList<Rectangle> convertSquaresToRectangles(ArrayList<Square> possibleMoveSquaresOfPiece) {
		ArrayList<Rectangle> rectangles = new ArrayList<>();
		for (Square possibleMoveSquareOfPiece : possibleMoveSquaresOfPiece) {
			Rectangle rectangle = (Rectangle) GUIController.scene.lookup("#" + possibleMoveSquareOfPiece.toString());
			rectangles.add(rectangle);
		}
		return rectangles;
	}

}
