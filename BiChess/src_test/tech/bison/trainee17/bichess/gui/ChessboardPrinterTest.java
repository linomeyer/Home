package tech.bison.trainee17.bichess.gui;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import tech.bison.trainee17.bichess.Chessboard;
import tech.bison.trainee17.bichess.Move;
import tech.bison.trainee17.bichess.Movement;
import tech.bison.trainee17.bichess.Square;
import tech.bison.trainee17.bichess.gui.ChessboardPrinter;

public class ChessboardPrinterTest {
	@Test
	public void chessboard_printChessboard_printedChessboard() throws Exception {
		String printedChessboard = ChessboardPrinter.print(new Chessboard());
		
		assertThat(printedChessboard, is(
		"8 |Br|Bk|Bb|Bq|BK|Bb|Bk|Br|\n" + 
		"7 |Bp|Bp|Bp|Bp|Bp|Bp|Bp|Bp|\n" +
		"6 |  |  |  |  |  |  |  |  |\n" +
		"5 |  |  |  |  |  |  |  |  |\n" + 
		"4 |  |  |  |  |  |  |  |  |\n" + 
		"3 |  |  |  |  |  |  |  |  |\n" +
		"2 |Wp|Wp|Wp|Wp|Wp|Wp|Wp|Wp|\n" + 
		"1 |Wr|Wk|Wb|Wq|WK|Wb|Wk|Wr|\n" +
		"   A  B  C  D  E  F  G  H"
		));
	}
	
	@Test
	public void move_printChessboard_printedChessboard() throws Exception {
		Chessboard chessboard = new Chessboard();
		Move.movePiece(chessboard, new Movement(new Square("A2"), new Square("A4")));
		
		String printedChessboard = ChessboardPrinter.print(chessboard);
		
		assertThat(printedChessboard, is(
		"8 |Br|Bk|Bb|Bq|BK|Bb|Bk|Br|\n" + 
		"7 |Bp|Bp|Bp|Bp|Bp|Bp|Bp|Bp|\n" +
		"6 |  |  |  |  |  |  |  |  |\n" +
		"5 |  |  |  |  |  |  |  |  |\n" + 
		"4 |Wp|  |  |  |  |  |  |  |\n" + 
		"3 |  |  |  |  |  |  |  |  |\n" +
		"2 |  |Wp|Wp|Wp|Wp|Wp|Wp|Wp|\n" + 
		"1 |Wr|Wk|Wb|Wq|WK|Wb|Wk|Wr|\n" +
		"   A  B  C  D  E  F  G  H"
		));
	}
}
