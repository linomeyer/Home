package home.trainee17;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleMain {
	public static void main(String[] args) {

		// TODO: handle exception
		String input = "";
		while (input != "quit") {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Geben Sie einen Grossbuchstaben ein: ");
				input = br.readLine();
				System.out.println(Diamond.print(input.charAt(0)));
			} catch (Exception e) {
				System.out.println("\n!!!FAIL!!!\n");
			}
		}
	}
}
