package codewars.kyu6;

public class MissingLetterFinder {
	public static char findMissingLetter(char[] letters) {
		char missingLetter = ' ';
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] + 1 != letters[i + 1]) {
				missingLetter = (char) (letters[i] + 1);
				break;
			}
		}
		return missingLetter;
	}
}
