package tech.bison.trainee17.zebche;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tech.bison.trainee17.zebche.exceptions.EmptySquareException;
import tech.bison.trainee17.zebche.pieces.Bishop;
import tech.bison.trainee17.zebche.pieces.King;
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

	@Test
	public void chessboard_isKingInCheck_true() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("C3"), new King(Color.WHITE));
		chessboard.addPiece(new Square("C6"), new Rook(Color.BLACK));

		boolean kingInCheck = chessboard.isKingInCheck(Color.WHITE);

		assertThat(kingInCheck, is(true));
	}

	@Test
	public void chessboard_isKingInCheck_false() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("D2"), new King(Color.BLACK));
		chessboard.addPiece(new Square("A8"), new King(Color.WHITE));
		chessboard.addPiece(new Square("D3"), new Bishop(Color.WHITE));

		boolean kingInCheck = chessboard.isKingInCheck(Color.BLACK);

		assertThat(kingInCheck, is(false));
	}

	@Test
	public void chessboard_isKingInCheck_falseBecauseOfDifferentColor() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("C3"), new King(Color.BLACK));
		chessboard.addPiece(new Square("C6"), new Rook(Color.BLACK));

		boolean kingInCheck = chessboard.isKingInCheck(Color.BLACK);

		assertThat(kingInCheck, is(false));
	}

	@Test
	public void chessboard_getSquaresOfKings_squaresOfKings() throws Exception {
		Chessboard chessboard = new Chessboard();

		Square squaresOfKings = chessboard.getSquareOfKing(Color.WHITE);

		assertThat(squaresOfKings, is(new Square("E1")));
	}

	@Test
	public void chessboard_isKingInCheckmate_true() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("A1"), new King(Color.WHITE));
		chessboard.addPiece(new Square("A8"), new Rook(Color.BLACK));
		chessboard.addPiece(new Square("B8"), new Rook(Color.BLACK));

		assertThat(chessboard.isKingInCheckMate(Color.WHITE), is(true));
	}

	@Test
	public void chessboard_isKingInCheckmate_alliedPieceSafesKing() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("A1"), new King(Color.WHITE));
		chessboard.addPiece(new Square("A8"), new Rook(Color.BLACK));
		chessboard.addPiece(new Square("B8"), new Rook(Color.BLACK));
		chessboard.addPiece(new Square("H2"), new Rook(Color.WHITE));

		assertThat(chessboard.isKingInCheckMate(Color.WHITE), is(false));
	}

	@Test
	public void chessboard_isKingInCheckmate_kingSafesHimself() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("A1"), new King(Color.BLACK));
		chessboard.addPiece(new Square("A8"), new Rook(Color.WHITE));

		assertThat(chessboard.isKingInCheckMate(Color.BLACK), is(false));
	}

}
