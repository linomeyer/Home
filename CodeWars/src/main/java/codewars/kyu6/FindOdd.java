package codewars.kyu6;

public class FindOdd {
	public static int findIt(int[] a) {
		for (int number : a) {
			int counter = 0;
			for (int i : a) {
				if (number == i) {
					counter++;
				}
			}
			if (counter % 2 != 0) {
				return number;
			}
		}
		return 0;
	}
}
