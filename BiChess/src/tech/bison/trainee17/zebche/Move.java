package tech.bison.trainee17.zebche;

import tech.bison.trainee17.zebche.exceptions.EmptySquareException;
import tech.bison.trainee17.zebche.exceptions.InvalidSquareException;
import tech.bison.trainee17.zebche.exceptions.SquareOccupiedException;
import tech.bison.trainee17.zebche.pieces.Pawn;
import tech.bison.trainee17.zebche.pieces.Piece;
import tech.bison.trainee17.zebche.pieces.Piece.Color;

public class Move {
	public static boolean whiteOnTurn = true;
	public static int moveCounter = 0;

	public enum MoveState {
		SQUARE_EMPTY, WRONG_COLOR, INVALID_MOVE, INVALID_SQUARE, OCCUPIED_SQUARE, CANT_JUMP, OK, PIECE_CAPTURED,
		CHECKMATE, CHECK
	}

	public static MoveState movePiece(Chessboard chessboard, Movement movement) {
		try {
			if (chessboard.isAValidMoveOfPiece(movement)) {
				if (chessboard.isWayEmpty(movement)) {
					Color colorOfMove = whiteOnTurn == true ? Color.WHITE : Color.BLACK;
					return turn(chessboard, movement, colorOfMove);
				} else {
					return MoveState.CANT_JUMP;
				}
			} else {
				if (chessboard.getPiece(movement.getStart()).equals(new Pawn(Color.WHITE))
						|| chessboard.getPiece(movement.getStart()).equals(new Pawn(Color.BLACK))) {
					return capturePieceWithPawn(chessboard, movement);
				} else {
					return MoveState.INVALID_MOVE;
				}
			}
		} catch (SquareOccupiedException e) {
			try {
				if (chessboard.getPiece(movement.getStart()).equals(new Pawn(Color.WHITE))
						|| chessboard.getPiece(movement.getStart()).equals(new Pawn(Color.BLACK))) {
					return MoveState.INVALID_MOVE;
				}
				capturePiece(chessboard, movement.getStart(), movement.getEnd());
				whiteOnTurn = whiteOnTurn == true ? false : true;
				moveCounter++;
				return MoveState.PIECE_CAPTURED;
			} catch (InvalidSquareException e1) {
				return MoveState.INVALID_SQUARE;
			} catch (EmptySquareException e1) {
				return MoveState.SQUARE_EMPTY;
			} catch (SquareOccupiedException e1) {
				return MoveState.OCCUPIED_SQUARE;
			}
		} catch (InvalidSquareException e) {
			return MoveState.INVALID_SQUARE;
		} catch (EmptySquareException e) {
			return MoveState.SQUARE_EMPTY;
		}
	}

	private static MoveState capturePieceWithPawn(Chessboard chessboard, Movement movement)
			throws InvalidSquareException, EmptySquareException, SquareOccupiedException {
		if (chessboard.getPiece(movement.getStart()).color == Color.WHITE) {
			if (movement.getYMovement() == 1 && Math.abs(movement.getXMovement()) == 1) {
				capturePiece(chessboard, movement.getStart(), movement.getEnd());
				whiteOnTurn = whiteOnTurn == true ? false : true;
				moveCounter++;
				return MoveState.PIECE_CAPTURED;
			}
		} else if (movement.getYMovement() == -1 && Math.abs(movement.getXMovement()) == 1) {
			capturePiece(chessboard, movement.getStart(), movement.getEnd());
			whiteOnTurn = whiteOnTurn == true ? false : true;
			moveCounter++;
			return MoveState.PIECE_CAPTURED;
		}
		return MoveState.INVALID_MOVE;
	}

	public static MoveState turn(Chessboard chessboard, Movement movement, Color colorOfMove)
			throws InvalidSquareException, EmptySquareException, SquareOccupiedException {
		if (whiteOnTurn) {
			return whiteTurn(chessboard, movement);
		} else {
			return blackTurn(chessboard, movement);
		}
	}

	private static MoveState blackTurn(Chessboard chessboard, Movement movement)
			throws InvalidSquareException, EmptySquareException, SquareOccupiedException {
		if (chessboard.getPiece(movement.getStart()).color == Color.BLACK) {
			whiteOnTurn = true;
			moveCounter++;
			moveAction(chessboard, movement);
			if (chessboard.isKingInCheckMate(Color.WHITE)) {
				return MoveState.CHECKMATE;
			}
			if (chessboard.isKingInCheck(Color.WHITE)) {
				return MoveState.CHECK;
			}
			return MoveState.OK;
		} else {
			return MoveState.WRONG_COLOR;
		}
	}

	private static MoveState whiteTurn(Chessboard chessboard, Movement movement)
			throws InvalidSquareException, EmptySquareException, SquareOccupiedException {
		if (chessboard.getPiece(movement.getStart()).color == Color.WHITE) {
			whiteOnTurn = false;
			moveCounter++;
			moveAction(chessboard, movement);
			if (chessboard.isKingInCheckMate(Color.BLACK)) {
				return MoveState.CHECKMATE;
			}
			if (chessboard.isKingInCheck(Color.BLACK)) {
				return MoveState.CHECK;
			}
			return MoveState.OK;
		} else {
			return MoveState.WRONG_COLOR;
		}
	}

	private static void moveAction(Chessboard chessboard, Movement movement)
			throws SquareOccupiedException, InvalidSquareException, EmptySquareException {
		chessboard.addPiece(movement.getEnd(), chessboard.getPiece(movement.getStart()));
		chessboard.removePiece(movement.getStart());
		chessboard.getPiece(movement.getEnd()).incrementMoveCounter();
		chessboard.safeMove(chessboard.getPiece(movement.getEnd()), movement);
	}

	public static MoveState movePieceVirtually(Chessboard chessboard, Movement movement) {
		try {
			if (chessboard.isAValidMoveOfPiece(movement)) {
				if (chessboard.isWayEmpty(movement)) {
					moveAction(chessboard, movement);
					return MoveState.OK;
				} else {
					return MoveState.CANT_JUMP;
				}
			} else {
				return MoveState.INVALID_MOVE;
			}
		} catch (

		SquareOccupiedException e) {
			return MoveState.OCCUPIED_SQUARE;
		} catch (InvalidSquareException e) {
			return MoveState.INVALID_SQUARE;
		} catch (EmptySquareException e) {
			return MoveState.SQUARE_EMPTY;
		}
	}

	public static void capturePiece(Chessboard chessboard, Square squareOfpiece, Square squareOfpieceToCapture)
			throws InvalidSquareException, EmptySquareException, SquareOccupiedException {
		Piece piece = chessboard.getPiece(squareOfpiece);
		Piece piecetoCapture = chessboard.getPiece(squareOfpieceToCapture);

		if (!piece.color.equals(piecetoCapture.color)) {
			chessboard.removePiece(squareOfpiece);
			chessboard.removePiece(squareOfpieceToCapture);
			chessboard.addPiece(squareOfpieceToCapture, piece);
			chessboard.safeMove(piece, new Movement(squareOfpiece, squareOfpieceToCapture));
		}
	}

}
