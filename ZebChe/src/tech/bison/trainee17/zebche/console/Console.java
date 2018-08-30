package tech.bison.trainee17.zebche.console;

import tech.bison.trainee17.zebche.Chessboard;

public class Console {
public static void main(String[] args) {
	Chessboard chessboard = new Chessboard();
	System.out.println(ChessboardPrinter.print(chessboard));
}
}
