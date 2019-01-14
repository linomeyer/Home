package codewars.kyu5;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SumOfDistancesTest {
	@Test
	public void BasicTests1() {
		System.out.println("****** Basic Tests small numbers******");
		List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
		int n = SumOfDistances.chooseBestSum(163, 3, ts);
		assertEquals(163, n);
		ts = new ArrayList<>(Arrays.asList(50));
		Integer m = SumOfDistances.chooseBestSum(163, 3, ts);
		assertEquals(null, m);
		ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
		n = SumOfDistances.chooseBestSum(230, 3, ts);
		assertEquals(228, n);
	}
}
