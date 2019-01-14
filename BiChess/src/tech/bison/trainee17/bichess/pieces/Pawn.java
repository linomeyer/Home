
package tech.bison.trainee17.bichess.pieces;

import tech.bison.trainee17.bichess.Movement;

public class Pawn extends Piece {
  public Pawn(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (color == Color.BLACK) {
      return isAValidBlackPawnMove(movement);
    } else if (color == Color.WHITE) {
      return isAValidWhitePawnMove(movement);
    }
    return false;
  }

  private boolean isAValidBlackPawnMove(Movement movement) {
    if (!super.isAMove(movement)) {
      return false;
    }
    if (moveCounter == 0) {
      if (movement.getXMovement() == 0 && movement.getYMovement() == -2) {
        incrementMoveCounter();
        return true;
      }
    }
    if (movement.getXMovement() == 0 && movement.getYMovement() == -1) {
      incrementMoveCounter();
      return true;
    }
    return false;
  }

  private boolean isAValidWhitePawnMove(Movement movement) {
    if (!super.isAMove(movement)) {
      return false;
    }
    if (moveCounter == 0) {
      if (movement.getXMovement() == 0 && movement.getYMovement() == 2) {
        incrementMoveCounter();
        return true;
      }
    }
    if (movement.getXMovement() == 0 && movement.getYMovement() == 1) {
      incrementMoveCounter();
      return true;
    }
    return false;
  }
  
  @Override
	public String toString() {
	  if (color == Color.WHITE) {
		return "Wp";
	} else {
		return "Bp";
	}
	}
}
