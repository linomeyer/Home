package tech.bison.trainee17.zebche.pieces;

import tech.bison.trainee17.zebche.Movement;

public class King extends Piece {

	public King() {
		super(Color.WHITE);
	}

	public King(Color color) {
		super(color);
	}

	@Override
	public boolean isAValidMove(Movement movement) {
		if (!super.isAMove(movement)) {
			return false;
		}
		if (movement.getXMovement() <= 1 && movement.getXMovement() >= -1 && movement.getYMovement() <= 1
				&& movement.getYMovement() >= -1) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (color == Color.WHITE) {
			return "WK";
		} else {
			return "BK";
		}
	}
}
