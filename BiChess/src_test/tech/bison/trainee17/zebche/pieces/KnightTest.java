package tech.bison.trainee17.zebche.pieces;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import tech.bison.trainee17.zebche.Movement;
import tech.bison.trainee17.zebche.Square;

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
