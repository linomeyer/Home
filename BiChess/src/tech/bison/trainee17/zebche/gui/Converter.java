package tech.bison.trainee17.zebche.gui;

import java.util.ArrayList;

import tech.bison.trainee17.zebche.Square;
import tech.bison.trainee17.zebche.pieces.Bishop;
import tech.bison.trainee17.zebche.pieces.King;
import tech.bison.trainee17.zebche.pieces.Knight;
import tech.bison.trainee17.zebche.pieces.Pawn;
import tech.bison.trainee17.zebche.pieces.Piece;
import tech.bison.trainee17.zebche.pieces.Piece.Color;
import tech.bison.trainee17.zebche.pieces.Queen;
import tech.bison.trainee17.zebche.pieces.Rook;

public class Converter {

	public static Square convertCoordinatesToSquare(double xPos, double yPos) {
		int xSquarePos = (int) (xPos / 75 + 1);
		int ySquarePos = (int) (yPos / 75);
		ySquarePos = 8 - ySquarePos;
		return new Square(xSquarePos, ySquarePos);
	}

	public static Piece convertIdToPiece(String id) {
		switch (id) {
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

}
