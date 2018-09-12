package home.trainee17;

import java.util.ArrayList;
import java.util.List;

public class Diamond {
	char letter;

	public Diamond(char letter) {
		this.letter = letter;
	}

	public static String print(char letter) {
		String output = "";
		List<List<Character>> rows = new Diamond(letter).getRows();
		for (int i = 0; i < rows.size(); i++) {
			List<Character> row = rows.get(i);
			for (int j = 0; j < row.size(); j++) {
				output += String.valueOf(row.get(j));
			}
			if (i < rows.size() - 1) {
				output += "\n";
			}
		}
		return output;
	}

	public List<Character> getLetterSequence() {
		ArrayList<Character> letters = new ArrayList<>();
		for (int i = 'A'; i < letter; i++) {
			letters.add((char) i);
		}
		for (int i = letter; i >= 'A'; i--) {
			letters.add((char) i);
		}
		return letters;
	}

	public List<Integer> getIndentationSequence() {
		ArrayList<Integer> amountOfSpaces = new ArrayList<>();
		for (int i = letter - 65; i > 'A' - 65; i--) {
			amountOfSpaces.add(i);
		}
		for (int i = 'A' - 65; i <= letter - 65; i++) {
			amountOfSpaces.add(i);
		}
		return amountOfSpaces;
	}

	public List<Integer> getBetweenSequence() {
		ArrayList<Integer> amountOfSpaces = new ArrayList<>();
		for (int i = 'A' - 65; i < letter - 65; i++) {
			int spaces = i == 0 ? 0 : i * 2 - 1;
			amountOfSpaces.add(spaces);
		}
		for (int i = letter - 65; i >= 'A' - 65; i--) {
			int spaces = i == 0 ? 0 : i * 2 - 1;
			amountOfSpaces.add(spaces);
		}
		return amountOfSpaces;
	}

	public List<Character> getOneRow(char letter, int preSpaces, int midSpaces) {
		ArrayList<Character> row = new ArrayList<>();

		for (int i = 0; i < preSpaces; i++) {
			row.add(' ');
		}
		row.add(letter);
		if (midSpaces > 0) {
			for (int i = 0; i < midSpaces; i++) {
				row.add(' ');
			}
			row.add(letter);
		}
		return row;
	}

	public List<List<Character>> getRows() {
		ArrayList<List<Character>> rows = new ArrayList<>();
		List<Integer> amountOfPreSpaces = getIndentationSequence();
		List<Character> letters = getLetterSequence();
		List<Integer> amountOfMidSpaces = getBetweenSequence();

		for (int i = 0; i < letters.size(); i++) {
			rows.add(getOneRow(letters.get(i), amountOfPreSpaces.get(i), amountOfMidSpaces.get(i)));
		}
		return rows;
	}

}
