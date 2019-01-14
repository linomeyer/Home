package codewars.kyu6;

public class MiddleOfArray {
	public static int findEvenIndex(int[] numbers) {
		int evenIndex = -1;
		for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
			int addedLeftSide = 0;
			int addedRightSide = 0;

			for (int i = currentIndex - 1; i >= 0; i--) {
				addedLeftSide += numbers[i];
			}
			for (int i = currentIndex + 1; i < numbers.length; i++) {
				addedRightSide += numbers[i];
			}
			if (addedLeftSide == addedRightSide) {
				evenIndex = currentIndex;
				break;
			}
		}
		return evenIndex;
	}
}
