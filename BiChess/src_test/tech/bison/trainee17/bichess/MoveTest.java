package tech.bison.trainee17.bichess;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tech.bison.trainee17.bichess.Chessboard;
import tech.bison.trainee17.bichess.Move;
import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.Move.MoveState;
import tech.bison.trainee17.bichess.exceptions.EmptySquareException;
import tech.bison.trainee17.bichess.pieces.King;
import tech.bison.trainee17.bichess.pieces.Pawn;
import tech.bison.trainee17.bichess.pieces.Rook;
import tech.bison.trainee17.bichess.pieces.Piece.Color;

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
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_movePiece_InvalidMove() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);
		chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));

		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("B8")));

		assertThat(moveState, is(MoveState.INVALID_MOVE));
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_movePiece_emptySquare() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);
		chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));

		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A8")));

		assertThat(moveState, is(MoveState.SQUARE_EMPTY));
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_movePiece_invalidSquare() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);
		chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));

		Move.whiteOnTurn = true;
		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("Z1")));

		assertThat(moveState, is(MoveState.INVALID_SQUARE));
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_moveWhitePawn_canMoveTwo() throws Exception {
		Chessboard chessboard = new Chessboard();

		Move.whiteOnTurn = true;
		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A4")));

		assertThat(moveState, is(MoveState.OK));
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_moveTwiceWithBlackPawn_cantMoveTwoInSecondMove() throws Exception {
		Chessboard chessboard = new Chessboard();

		Move.whiteOnTurn = false;
		Move.movePiece(chessboard, new Movement(new Square("A7"), new Square("A5")));
		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A5"), new Square("A3")));

		assertThat(moveState, is(MoveState.INVALID_MOVE));
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_wayOfMoveIsNotEmpty_InvalidMove() throws Exception {
		Chessboard chessboard = new Chessboard();

		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("A4")));

		assertThat(moveState, is(MoveState.CANT_JUMP));
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_move_pieceCaptured() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);
		chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));
		chessboard.addPiece(new Square("A2"), new Rook(Color.BLACK));

		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("A2")));

		assertThat(moveState, is(MoveState.PIECE_CAPTURED));
		Move.whiteOnTurn = true;
	}

	@Test
	public void chessboard_moveTwice_moveCounterEqualsTwo() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);
		chessboard.addPiece(new Square("A1"), new Rook(Color.WHITE));
		chessboard.addPiece(new Square("A2"), new Rook(Color.BLACK));
		chessboard.addPiece(new Square("A3"), new Rook(Color.BLACK));

		Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("A2")));
		Move.movePiece(chessboard, new Movement(new Square("A3"), new Square("A7")));

		assertThat(chessboard.getMoveSaves().size(), is(1));
	}

	@Test
	public void chessboard_capturePiece_pieceCaptured() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("A1"), new King(Color.BLACK));
		chessboard.addPiece(new Square("A2"), new Rook(Color.WHITE));

		Move.capturePiece(chessboard, new Square("A1"), new Square("A2"));

		assertThat(chessboard.getPiece(new Square("A2")), is(new King(Color.BLACK)));
		thrown.expect(EmptySquareException.class);
		assertNull(chessboard.getPiece(new Square("A1")));
	}

	@Test
	public void chessboard_capturePiece_pieceNotCaptured() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("A1"), new King(Color.BLACK));
		chessboard.addPiece(new Square("A2"), new Rook(Color.BLACK));

		Move.capturePiece(chessboard, new Square("A1"), new Square("A2"));

		assertThat(chessboard.getPiece(new Square("A2")), is(new Rook(Color.BLACK)));
		assertThat(chessboard.getPiece(new Square("A1")), is(new King(Color.BLACK)));
	}

	@Test
	public void chessboard_pawn_capturePieceDiagonally() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("A1"), new Pawn(Color.WHITE));
		chessboard.addPiece(new Square("B2"), new Rook(Color.BLACK));

		Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("B2")));

		assertThat(chessboard.getPiece(new Square("B2")), is(new Pawn(Color.WHITE)));
	}

	@Test
	public void chessboard_pawn_cantCapturePieceVertically() throws Exception {
		Chessboard chessboard = new Chessboard(8, 8);

		chessboard.addPiece(new Square("A1"), new Pawn(Color.WHITE));
		chessboard.addPiece(new Square("A2"), new Rook(Color.BLACK));

		MoveState moveState = Move.movePiece(chessboard, new Movement(new Square("A1"), new Square("A2")));

		assertThat(moveState, is(MoveState.INVALID_MOVE));
		Move.whiteOnTurn = true;
	}
}
