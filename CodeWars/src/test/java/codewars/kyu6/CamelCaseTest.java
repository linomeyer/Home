package codewars.kyu6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codewars.kyu6.CamelCase;

public class CamelCaseTest {
	@Test
	public void testSomeUnderscoreLowerStart() {
		String input = "the_Stealth_Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
	}

	@Test
	public void testSomeDashLowerStart() {
		String input = "the-Stealth-Warrior";
		System.out.println("input: " + input);
		assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
	}
}
