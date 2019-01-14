package codewars.kyu6;

import java.util.ArrayList;
import java.util.Arrays;

public class WichAreIn {
	public static String[] inArray(String[] array1, String[] array2) {
		ArrayList<String> result = new ArrayList<>();

		for (String element1 : array1) {
			for (String element2 : array2) {
				if (element2.contains(element1)) {
					result.add(element1);
					break;
				}
			}
		}
		String[] resultArray = result.toArray(new String[0]);

		Arrays.sort(resultArray);

		return resultArray;
	}
}
