package tech.bison.trainee17.zebche;

import tech.bison.trainee17.zebche.pieces.Piece;

public class MoveSave {
	int moveNumber;
	Piece piece;
	Movement movement;

	public MoveSave(Piece piece, Movement movement) {
		moveNumber = Move.moveCounter;
		this.piece = piece;
		this.movement = movement;
	}

	public int getMoveNumber() {
		return moveNumber;
	}

	public void setMoveNumber(int moveNumber) {
		this.moveNumber = moveNumber;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

}
