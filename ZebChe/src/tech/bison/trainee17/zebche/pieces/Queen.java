package tech.bison.trainee17.zebche.pieces;

import tech.bison.trainee17.zebche.Movement;

public class Queen extends Piece {

  public Queen() {
    super(Color.WHITE);
  }

  public Queen(Color color) {
    super(color);
  }

  @Override
  public boolean isAValidMove(Movement movement) {
    if (!super.isAMove(movement)) {
      return false;
    } else if (movement.getXMovement() != 0 && movement.getYMovement() != 0) {
      return Math.abs(movement.getXMovement()) == Math.abs(movement.getYMovement());
    }
    return true;
  }

}
