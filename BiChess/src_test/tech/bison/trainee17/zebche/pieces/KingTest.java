package tech.bison.trainee17.zebche.pieces;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tech.bison.trainee17.zebche.Movement;
import tech.bison.trainee17.zebche.Square;

public class KingTest {
	@Test
	public void queen_moveOneDiagonal_isAValidMove() {
		King king = new King();

		boolean isAValidMove = king.isAValidMove(new Movement(new Square("A2"), new Square("B3")));

		assertThat(isAValidMove, is(true));
	}

	@Test
	public void king_moveOneHorizontal_isAValidMove() {
		King king = new King();

		boolean isAValidMove = king.isAValidMove(new Movement(new Square("A1"), new Square("B1")));

		assertThat(isAValidMove, is(true));
	}

	@Test
	public void queen_moveTwoHorizontal_isNotAValidMove() {
		King king = new King();

		boolean isAValidMove = king.isAValidMove(new Movement(new Square("A2"), new Square("C2")));

		assertThat(isAValidMove, is(false));
	}
}
