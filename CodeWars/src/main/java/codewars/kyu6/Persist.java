package codewars.kyu6;

public class Persist {

	public static int persistence(long i) {
		String iString = Long.toString(i);
		int[] digits = stringToDigitArray(iString);
		int counter = 0;

		while (digits.length > 1) {
			int number = digits[0];
			for (int x = 1; x < digits.length; x++) {
				number *= digits[x];
			}

			digits = stringToDigitArray(String.valueOf(number));
			counter++;
		}
		return counter;
	}

	private static int[] stringToDigitArray(String iString) {
		int[] digits = new int[iString.length()];

		for (int i = 0; i < iString.length(); i++) {
			digits[i] = Integer.parseInt(String.valueOf(iString.charAt(i)));
		}
		return digits;
	}

}
