package codewars.kyu6;

public class DuplicateEncoder {
	static String encode(String word) {
		String result = "";
		word = word.toLowerCase();

		for (char c : word.toCharArray()) {
			int counted = countChar(c, word);
			if (counted > 1) {
				result += ")";
			} else {
				result += "(";
			}
		}

		return result;
	}

	private static int countChar(char c, String word) {
		int counted = 0;

		for (char wc : word.toCharArray()) {
			if (wc == c) {
				counted++;
			}
		}
		return counted;
	}
}
