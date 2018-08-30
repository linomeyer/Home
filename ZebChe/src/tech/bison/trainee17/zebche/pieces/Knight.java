package tech.bison.trainee17.zebche.pieces;

import tech.bison.trainee17.zebche.Movement;

public class Knight extends Piece {

  public Knight() {
    super(Color.WHITE);
  }

  public Knight(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement)) {
      return false;
    } else {
      if ((Math.abs(movement.getXMovement()) == 2 && Math.abs(movement.getYMovement()) == 1)
          || (Math.abs(movement.getXMovement()) == 1 && Math.abs(movement.getYMovement()) == 2)) {
        return true;
      }
    }
    return false;
  }
}
