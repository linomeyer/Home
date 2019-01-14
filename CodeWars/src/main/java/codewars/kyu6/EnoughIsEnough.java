package codewars.kyu6;

import java.util.ArrayList;

public class EnoughIsEnough {

	public static int[] deleteNth(int[] numbers, int maxOccurences) {
		for (int i : numbers) {
			int counter = 0;
			for (int j : numbers) {
				if (i == j) {
					counter++;
				}
			}
			if (counter > maxOccurences) {
				int occurencesToDelete = counter - maxOccurences;
				for (int j = numbers.length - 1; j >= 0; j--) {
					if (i == numbers[j] && occurencesToDelete > 0) {
						numbers[j] = -1;
						occurencesToDelete--;
					}
				}
			}
		}
		ArrayList<Integer> numbersList = new ArrayList<>();
		for (int j : numbers) {
			if (j != -1) {
				numbersList.add(j);
			}
		}
		int[] arr = numbersList.stream().mapToInt(i -> i).toArray();
		return arr;
	}

}
