package tech.bison.trainee17.bichess.pieces;

import tech.bison.trainee17.bichess.Movement;

public class Bishop extends Piece {

  public Bishop() {
    super(Color.WHITE);
  }

  public Bishop(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement)) {
      return false;
    } else if (movement.getXMovement() != 0 && movement.getYMovement() != 0) {
      return Math.abs(movement.getXMovement()) == Math.abs(movement.getYMovement());
    }
    return false;
  }
  
  @Override
	public String toString() {
	  if (color == Color.WHITE) {
		return "Wb";
	} else {
		return "Bb";
	}
	}
}
