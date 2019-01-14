package tech.bison.trainee17.bichess.gui;

import tech.bison.trainee17.bichess.Chessboard;

public class ChessboardPrinter {
	public final static String SPACE = "  ";

	public static String print(Chessboard chessboard) {
		return chessboard.toString();
	}
}
