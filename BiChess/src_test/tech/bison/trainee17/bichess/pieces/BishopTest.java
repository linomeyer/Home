package tech.bison.trainee17.bichess.pieces;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.pieces.Bishop;

import static org.hamcrest.CoreMatchers.is;

public class BishopTest {
  @Test
  public void bishop_moveHorizontal_isAValidMove() {
    Bishop bishop = new Bishop();

    boolean isAValidMove = bishop.isAValidMove(new Movement(new Square("H1"), new Square("H8")));

    assertThat(isAValidMove, is(false));
  }

  @Test
  public void bishop_moveVertical_isAValidMove() {
    Bishop bishop = new Bishop();

    boolean isAValidMove = bishop.isAValidMove(new Movement(new Square("H8"), new Square("A1")));

    assertThat(isAValidMove, is(true));
  }
}
