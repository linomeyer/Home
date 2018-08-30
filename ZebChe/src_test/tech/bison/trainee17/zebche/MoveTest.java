package tech.bison.trainee17.zebche;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

import tech.bison.trainee17.zebche.Move.MoveState;
import tech.bison.trainee17.zebche.pieces.Piece.Color;
import tech.bison.trainee17.zebche.pieces.Rook;

public class MoveTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void chessboard_movePiece_pieceMoved() throws Exception {
    Chessboard chessboard = new Chessboard(8, 8);
    chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));

    MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("A8")));

    assertThat(chessboard.getPiece(new Square("A8")), is(new Rook(Color.WHITE)));
    assertThat(moveState, is(MoveState.OK));
  }

  @Test
  public void chessboard_movePiece_InvalidMove() throws Exception {
    Chessboard chessboard = new Chessboard(8, 8);
    chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));

    MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("B8")));

    assertThat(moveState, is(MoveState.INVALID_MOVE));
  }

  @Test
  public void chessboard_movePiece_emptySquare() throws Exception {
    Chessboard chessboard = new Chessboard(8, 8);
    chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));

    MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A8")));

    assertThat(moveState, is(MoveState.SQUARE_EMPTY));
  }

  @Test
  public void chessboard_movePiece_invalidSquare() throws Exception {
    Chessboard chessboard = new Chessboard(8, 8);
    chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));

    MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("Z1")));

    assertThat(moveState, is(MoveState.INVALID_SQUARE));
  }

  @Test
  public void chessboard_moveWhitePawn_canMoveTwo() throws Exception {
    Chessboard chessboard = new Chessboard();

    MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A4")));

    assertThat(moveState, is(MoveState.OK));
  }

  @Test
  public void chessboard_moveTwiceWithBlackPawn_cantMoveTwoInSecondMove() throws Exception {
    Chessboard chessboard = new Chessboard();

    Move.movePiece(chessboard, new Movement(new Square("A7"), new Square("A5")));
    MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A5"), new Square("A3")));

    assertThat(moveState, is(MoveState.INVALID_MOVE));
  }
  
  @Test
public void chessboard_wayOfMoveIsNotEmpty_InvalidMove() throws Exception {
	Chessboard chessboard = new Chessboard();
	
	MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("A4")));
	
	assertThat(moveState, is(MoveState.CANT_JUMP));
}

}
