package codewars.kyu6;

import java.util.ArrayList;

public class MexicanWave {
	public static String[] wave(String str) {
		ArrayList<String> arrayList = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			StringBuilder stringBuilder = new StringBuilder(str);
			if (str.charAt(i) != ' ') {
				String waveChar = (str.charAt(i) + "").toUpperCase();
				stringBuilder.setCharAt(i, waveChar.charAt(0));
				String waveStr = stringBuilder.toString();
				arrayList.add(waveStr);
			}
		}
		return arrayList.toArray(new String[0]);
	}
}
