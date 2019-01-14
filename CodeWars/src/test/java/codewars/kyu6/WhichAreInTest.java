package codewars.kyu6;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import codewars.kyu6.WichAreIn;

public class WhichAreInTest {
	@Test
	public void test1() {
		String a[] = new String[] { "arp", "live", "strong" };
		String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };

		String r[] = new String[] { "arp", "live", "strong" };

		assertArrayEquals(r, WichAreIn.inArray(a, b));
	}
}
