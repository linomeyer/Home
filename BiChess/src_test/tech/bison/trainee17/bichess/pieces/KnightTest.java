package tech.bison.trainee17.bichess.pieces;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.pieces.Knight;

import static org.hamcrest.CoreMatchers.is;

public class KnightTest {
  @Test
  public void knight_move_isAValidMove() {
    Knight knight = new Knight();

    boolean isAValidMove = knight.isAValidMove(new Movement(new Square("H8"), new Square("F7")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void knight_move_isNotAValidMove() {
    Knight knight = new Knight();

    boolean isAValidMove = knight.isAValidMove(new Movement(new Square("C3"), new Square("A5")));

    assertThat(isAValidMove, is(false));
  }
}
