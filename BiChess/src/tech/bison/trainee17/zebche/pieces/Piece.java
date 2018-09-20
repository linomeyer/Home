package tech.bison.trainee17.zebche.pieces;

import tech.bison.trainee17.zebche.Movement;
import tech.bison.trainee17.zebche.Square;

public abstract class Piece {
	public final Color color;
	public int moveCounter;

	public enum Color {
		BLACK, WHITE
	}

	public Piece(Color color) {
		this.color = color;
		moveCounter = 0;
	}

	public boolean isAMove(Movement movement) {
		if (movement.getXMovement() == 0 && movement.getYMovement() == 0) {
			return false;
		}
		return true;
	}

	public boolean isAValidMove(String startPos, String endPos) {
		return isAValidMove(new Square(startPos), new Square(endPos));
	}

	public boolean isAValidMove(Square startPos, Square endPos) {
		Movement movement = new Movement(startPos, endPos);
		return isAValidMove(movement);
	}

	public abstract boolean isAValidMove(Movement movement);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		return true;
	}

	public void incrementMoveCounter() {
		moveCounter++;
	}

}
