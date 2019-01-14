package tech.bison.trainee17.bichess.pieces;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.pieces.Queen;

import static org.hamcrest.CoreMatchers.is;

public class QueenTest {

  @Test
  public void queen_moveDiagonal_isAValidMove() {
    Queen queen = new Queen();

    boolean isAValidMove = queen.isAValidMove(new Movement(new Square("A2"), new Square("D5")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void queen_moveHorizontal_isAValidMove() {
    Queen queen = new Queen();

    boolean isAValidMove = queen.isAValidMove(new Movement(new Square("H1"), new Square("H8")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void queen_moveVertical_isAValidMove() {
    Queen queen = new Queen();

    boolean isAValidMove = queen.isAValidMove(new Movement(new Square("A8"), new Square("A1")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void queen_moveWhetherDiagonalHorizontalOrVertical_isNotAValidMove() {
    Queen queen = new Queen();

    boolean isAValidMove = queen.isAValidMove(new Movement(new Square("B3"), new Square("C1")));

    assertThat(isAValidMove, is(false));
  }

  @Test
  public void queen_dontMove_isNotAValidMove() {
    Queen queen = new Queen();

    boolean isAValidMove = queen.isAValidMove(new Movement(new Square("A2"), new Square("A2")));

    assertThat(isAValidMove, is(false));
  }

}
