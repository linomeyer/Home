package tech.bison.trainee17.zebche.gui;

import tech.bison.trainee17.zebche.Chessboard;

public class ChessboardPrinter {
	public final static String SPACE = "  ";
	
	public static String print(Chessboard chessboard) {
		return chessboard.toString();
	}
}
