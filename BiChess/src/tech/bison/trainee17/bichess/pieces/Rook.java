package tech.bison.trainee17.bichess.pieces;

import tech.bison.trainee17.bichess.Movement;

public class Rook extends Piece {

  public Rook() {
    super(Color.WHITE);
  }

  public Rook(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement)) {
      return false;
    }
    if (movement.getXMovement() != 0 && movement.getYMovement() == 0
        || movement.getYMovement() != 0 && movement.getXMovement() == 0) {
      return true;
    }
    return false;
  }

  @Override
	public String toString() {
	  if (color == Color.WHITE) {
		return "Wr";
	} else {
		return "Br";
	}
	}
}
