package tech.bison.trainee17.bichess.pieces;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.pieces.Pawn;
import tech.bison.trainee17.bichess.pieces.Piece.Color;

public class PawnTest {
  @Test
  public void whitePawn_move_isAValidMove() throws Exception {
    Pawn whitePawn = new Pawn(Color.WHITE);

    boolean isAValidMove = whitePawn.isAValidMove(new Movement(new Square("H6"), new Square("H5")));

    assertThat(isAValidMove, is(false));
  }

  @Test
  public void whitePawn_move_isNotAValidMove() throws Exception {
    Pawn whitePawn = new Pawn(Color.WHITE);

    boolean isAValidMove = whitePawn.isAValidMove(new Movement(new Square("A1"), new Square("A2")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void whitePawn_firstMove_canMoveTwoSquares() throws Exception {
    Pawn blackPawn = new Pawn(Color.BLACK);

    boolean isAValidMove = blackPawn.isAValidMove(new Movement(new Square("A7"), new Square("A5")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void whitePawn_secondMoveCantMoveTwoSquares() throws Exception {
    Pawn blackPawn = new Pawn(Color.BLACK);

    blackPawn.isAValidMove(new Movement(new Square("B8"), new Square("B6")));
    boolean aValidMove = blackPawn.isAValidMove(new Movement(new Square("B6"), new Square("B4")));

    assertThat(aValidMove, is(false));
  }

  @Test
  public void blackPawn_move_isAValidMove() throws Exception {
    Pawn blackPawn = new Pawn(Color.BLACK);

    boolean isAValidMove = blackPawn.isAValidMove(new Movement(new Square("H6"), new Square("H5")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void blackPawn_move_isNotAValidMove() throws Exception {
    Pawn blackPawn = new Pawn(Color.BLACK);

    boolean isAValidMove = blackPawn.isAValidMove(new Movement(new Square("A1"), new Square("A2")));

    assertThat(isAValidMove, is(false));
  }

  @Test
  public void blackpawn_firstMove_canMoveTwoSquares() throws Exception {
    Pawn blackPawn = new Pawn(Color.BLACK);

    boolean isAValidMove = blackPawn.isAValidMove(new Movement(new Square("A7"), new Square("A5")));

    assertThat(isAValidMove, is(true));
  }

  @Test
  public void blackpawn_secondMoveCantMoveTwoSquares() throws Exception {
    Pawn blackPawn = new Pawn(Color.BLACK);

    blackPawn.isAValidMove(new Movement(new Square("B8"), new Square("B6")));
    boolean aValidMove = blackPawn.isAValidMove(new Movement(new Square("B6"), new Square("B4")));

    assertThat(aValidMove, is(false));
  }
}
