package tech.bison.trainee17.bichess.pieces;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.pieces.Rook;

import static org.hamcrest.CoreMatchers.is;

public class RookTest {
  @Test
  public void rook_moveHorizontal_isNotAValidMove() {
    Rook rook = new Rook();

    boolean isAValidMove = rook.isAValidMove(new Movement(new Square("H1"), new Square("H8")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void rook_moveVertical_isNotAValidMove() {
    Rook rook = new Rook();

    boolean isAValidMove = rook.isAValidMove(new Movement(new Square("H8"), new Square("A1")));

    assertThat(isAValidMove, is(false));
  }
}
