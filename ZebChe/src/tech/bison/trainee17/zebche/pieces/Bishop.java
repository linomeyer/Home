package tech.bison.trainee17.zebche.pieces;

import tech.bison.trainee17.zebche.Movement;

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
}
