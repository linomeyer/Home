package tech.bison.trainee17.zebche;

import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

import tech.bison.trainee17.zebche.exceptions.EmptySquareException;
import tech.bison.trainee17.zebche.pieces.Knight;
import tech.bison.trainee17.zebche.pieces.Piece;
import tech.bison.trainee17.zebche.pieces.Piece.Color;
import tech.bison.trainee17.zebche.pieces.Rook;

public class ChessboardTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void chessboard_getPieceOfInitializedChessboard_Rook() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece piece = chessboard.getPiece(new Square("A1"));

    assertThat(piece, is(new Rook(Color.WHITE)));
  }

  @Test
  public void chessboard_square_isNotAValidSquare() throws Exception {
    Chessboard chessboard = new Chessboard();

    boolean validSquare = chessboard.isAValidSquare(new Square("Z1"));

    assertThat(validSquare, is(false));
  }

  @Test
  public void chessboard_addPiece_pieceAdded() throws Exception {
    Chessboard chessboard = new Chessboard();

    chessboard.addPiece(new Square("A4"), new Knight(Color.BLACK));

    assertThat(chessboard.getPiece(new Square("A4")), is(new Knight(Color.BLACK)));
  }

  @Test
  public void chessboard_removePiece_pieceRemoved() throws Exception {
    Chessboard chessboard = new Chessboard();

    Piece removedPiece = chessboard.removePiece(new Square("H8"));

    assertThat(removedPiece, is(new Rook(Color.BLACK)));

    thrown.expect(EmptySquareException.class);
    chessboard.getPiece(new Square("H8"));
  }

  @Test
  public void chessboard_removePiece_emptySquare() throws Exception {
    Chessboard chessboard = new Chessboard();

    thrown.expect(EmptySquareException.class);
    chessboard.removePiece(new Square("D5"));
  }

  @Test
  public void chessboard_move_wayIsNotEmpty() throws Exception {
    Chessboard chessboard = new Chessboard();

    boolean isWayEmpty = chessboard.isWayEmpty(new Movement(new Square("A1"), new Square("A4")));

    assertThat(isWayEmpty, is(false));
  }

  @Test
  public void chessboard_move_wayIsEmpty() throws Exception {
    Chessboard chessboard = new Chessboard();

    boolean wayEmpty = chessboard.isWayEmpty(new Movement(new Square("D5"), new Square("G5")));

    assertThat(wayEmpty, is(true));
  }
}
