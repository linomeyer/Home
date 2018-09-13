package tech.bison.trainee17.zebche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import tech.bison.trainee17.zebche.console.ChessboardPrinter;
import tech.bison.trainee17.zebche.exceptions.EmptySquareException;
import tech.bison.trainee17.zebche.exceptions.InvalidSquareException;
import tech.bison.trainee17.zebche.exceptions.SquareOccupiedException;
import tech.bison.trainee17.zebche.pieces.Bishop;
import tech.bison.trainee17.zebche.pieces.King;
import tech.bison.trainee17.zebche.pieces.Knight;
import tech.bison.trainee17.zebche.pieces.Pawn;
import tech.bison.trainee17.zebche.pieces.Piece;
import tech.bison.trainee17.zebche.pieces.Piece.Color;
import tech.bison.trainee17.zebche.pieces.Queen;
import tech.bison.trainee17.zebche.pieces.Rook;

public class Chessboard {

	public enum StateOfKing {
		OK, CHECK, CHECKMATE
	}

	public final int height;
	public final int length;
	private HashMap<Square, Piece> chessboard;

	/**
	 * Standard Chessboard 8x8 with 16 black and 16 white pieces
	 **/
	public Chessboard() {
		height = 8;
		length = 8;
		chessboard = initializeChessboard();
	}

	public Chessboard(int height, int length) {
		this.height = height;
		this.length = length;
		chessboard = new HashMap<>();
	}

	public HashMap<Square, Piece> initializeChessboard() {
		HashMap<Square, Piece> board = new HashMap<Square, Piece>();

		board.put(new Square("H8"), new Rook(Color.BLACK));
		board.put(new Square("A8"), new Rook(Color.BLACK));

		board.put(new Square("B8"), new Knight(Color.BLACK));
		board.put(new Square("G8"), new Knight(Color.BLACK));

		board.put(new Square("C8"), new Bishop(Color.BLACK));
		board.put(new Square("F8"), new Bishop(Color.BLACK));

		board.put(new Square("D8"), new Queen(Color.BLACK));

		board.put(new Square("E8"), new King(Color.BLACK));

		board.put(new Square("A7"), new Pawn(Color.BLACK));
		board.put(new Square("B7"), new Pawn(Color.BLACK));
		board.put(new Square("C7"), new Pawn(Color.BLACK));
		board.put(new Square("D7"), new Pawn(Color.BLACK));
		board.put(new Square("E7"), new Pawn(Color.BLACK));
		board.put(new Square("F7"), new Pawn(Color.BLACK));
		board.put(new Square("G7"), new Pawn(Color.BLACK));
		board.put(new Square("H7"), new Pawn(Color.BLACK));

		board.put(new Square("A1"), new Rook(Color.WHITE));
		board.put(new Square("H1"), new Rook(Color.WHITE));

		board.put(new Square("B1"), new Knight(Color.WHITE));
		board.put(new Square("G1"), new Knight(Color.WHITE));

		board.put(new Square("C1"), new Bishop(Color.WHITE));
		board.put(new Square("F1"), new Bishop(Color.WHITE));

		board.put(new Square("D1"), new Queen(Color.WHITE));

		board.put(new Square("E1"), new King(Color.WHITE));

		board.put(new Square("A2"), new Pawn(Color.WHITE));
		board.put(new Square("B2"), new Pawn(Color.WHITE));
		board.put(new Square("C2"), new Pawn(Color.WHITE));
		board.put(new Square("D2"), new Pawn(Color.WHITE));
		board.put(new Square("E2"), new Pawn(Color.WHITE));
		board.put(new Square("F2"), new Pawn(Color.WHITE));
		board.put(new Square("G2"), new Pawn(Color.WHITE));
		board.put(new Square("H2"), new Pawn(Color.WHITE));
		return board;
	}

	public boolean isAValidSquare(Square square) {
		if (square.getXCoordinate() >= 0 && square.getXCoordinate() <= height && square.getYCoordinate() >= 0
				&& square.getYCoordinate() <= length) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAValidMoveOfPiece(Movement movement) throws InvalidSquareException, EmptySquareException {
		boolean validMoveOfPiece = getPiece(movement.getStart()).isAValidMove(movement);
		return validMoveOfPiece;
	}

	public HashMap<Square, Piece> getChessboard() {
		return chessboard;
	}

	public Piece getPiece(Square square) throws InvalidSquareException, EmptySquareException {
		try {
			if (isAValidSquare(square)) {
				if (chessboard.get(square) == null) {
					throw new EmptySquareException();
				}
				return chessboard.get(square);
			} else {
				throw new InvalidSquareException();
			}
		} catch (NullPointerException e) {
			throw new EmptySquareException();
		}
	}

	public Piece removePiece(Square square) throws InvalidSquareException, EmptySquareException {
		if (isAValidSquare(square)) {
			if (chessboard.get(square) == null) {
				throw new EmptySquareException();
			}
			return chessboard.remove(square);
		} else {
			throw new InvalidSquareException();
		}
	}

	public void addPiece(Square square, Piece piece) throws SquareOccupiedException, InvalidSquareException {
		if (chessboard.get(square) == null) {
			if (isAValidSquare(square)) {
				chessboard.put(square, piece);
			} else {
				throw new InvalidSquareException();
			}
		} else {
			throw new SquareOccupiedException();
		}
	}

	public boolean isWayEmpty(Movement movement) {
		ArrayList<Square> squaresOnWay = movement.getWay();

		for (Square square : squaresOnWay) {
			try {
				if (getPiece(square) != null) {
					return false;
				}
			} catch (Exception e) {
			}
		}
		return true;
	}

	public boolean isKingInCheck(Color color) {
		Square squareOfKing = getSquareOfKing(color);
		Set<Square> squaresOfAllPieces = chessboard.keySet();

		for (Square squareOfPiece : squaresOfAllPieces) {
			Movement movement = new Movement(squareOfPiece, squareOfKing);
			try {
				if (isAValidMoveOfPiece(movement) && isWayEmpty(movement)
						&& getPiece(squareOfPiece).color != getPiece(squareOfKing).color) {
					return true;
				} else {
				}
			} catch (Exception e) {
			}
		}
		return false;
	}

	public Square getSquareOfKing(Color color) {
		Set<Square> squares = chessboard.keySet();
		Square squareOfKing = null;

		for (Square square : squares) {
			try {
				if (getPiece(square).equals(new King(color))) {
					squareOfKing = square;
				}
			} catch (Exception e) {
			}
		}
		return squareOfKing;
	}

	public boolean isKingInCheckMate(Color color) {
		if (!isKingInCheck(color)) {
			return false;
		}
		HashMap<Square, Piece> copyOfChessboardMap = new HashMap<>(chessboard);
		Set<Square> squaresOfPieces = copyOfChessboardMap.keySet();
		for (Square squareOfPiece : squaresOfPieces) {
			try {
				if (getPiece(squareOfPiece).color.equals(color)) {
					for (int x = 1; x <= length; x++) {
						for (int y = 1; y <= height; y++) {
							Square squareToMove = new Square(x, y);
							Move.movePiece(this, new Movement(squareOfPiece, squareToMove));
							if (!isKingInCheck(color)) {
								return false;
							}
							Move.movePiece(this, new Movement(squareToMove, squareOfPiece));
						}
					}
				}
			} catch (Exception e) {
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chessboard other = (Chessboard) obj;
		if (chessboard == null) {
			if (other.chessboard != null)
				return false;
		} else if (!chessboard.equals(other.chessboard))
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String chessboardAsString = "";
		for (int i = height; i > 0; i--) {
			chessboardAsString += i + " |";
			for (int j = 1; j <= length; j++) {
				try {
					chessboardAsString += this.getPiece(new Square(j, i)).toString();
				} catch (Exception e) {
					chessboardAsString += ChessboardPrinter.SPACE;
				}
				chessboardAsString += "|";
			}
			chessboardAsString += "\n";
		}
		chessboardAsString += "   A  B  C  D  E  F  G  H";
		return chessboardAsString;
	}
}
