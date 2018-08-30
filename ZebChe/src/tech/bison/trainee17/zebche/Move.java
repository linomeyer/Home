package tech.bison.trainee17.zebche;

import tech.bison.trainee17.zebche.exceptions.EmptySquareException;
import tech.bison.trainee17.zebche.exceptions.InvalidSquareException;
import tech.bison.trainee17.zebche.exceptions.SquareOccupiedException;

public class Move {

  public enum MoveState {
    SQUARE_EMPTY, INVALID_MOVE, INVALID_SQUARE, OCCUPIED_SQUARE, CANT_JUMP, OK
  }

  public static MoveState movePiece(Chessboard chessboard, Movement movement) {
    try {
      if (chessboard.isAValidMoveOfPiece(movement)) {
    	  if (chessboard.isWayEmpty(movement)) {
    		  chessboard.addPiece(movement.getEnd(), chessboard.getPiece(movement.getStart()));
    		  chessboard.removePiece(movement.getStart());
    		  chessboard.getPiece(movement.getEnd()).incrementMoveCounter();
    		  return MoveState.OK;
		} else {
			return MoveState.CANT_JUMP;
		}
      } else {
        return MoveState.INVALID_MOVE;
      }
    } catch (SquareOccupiedException e) {
      return MoveState.OCCUPIED_SQUARE;
    } catch (InvalidSquareException e) {
      return MoveState.INVALID_SQUARE;
    } catch (EmptySquareException e) {
      return MoveState.SQUARE_EMPTY;
    }
  }
}
