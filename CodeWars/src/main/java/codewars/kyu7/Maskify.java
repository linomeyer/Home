package codewars.kyu7;

public class Maskify {
	public static String maskify(String input) {
		int length = input.length();
		StringBuilder output = new StringBuilder(input);
		for (int index = 0; index < length - 4; index++) {
			output.setCharAt(index, '#');
		}

		return output.toString();
	}
}
