package tech.bison.trainee17.zebche.pieces;

import tech.bison.trainee17.zebche.Movement;

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

}
