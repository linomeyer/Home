package codewars.kyu6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codewars.kyu6.Persist;

public class PersistTest {
	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals(3, Persist.persistence(39));
		assertEquals(0, Persist.persistence(4));
		assertEquals(2, Persist.persistence(25));
		assertEquals(4, Persist.persistence(999));
	}
}
