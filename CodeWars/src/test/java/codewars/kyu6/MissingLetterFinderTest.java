package codewars.kyu6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MissingLetterFinderTest {
	@Test
	public void exampleTests() {
		assertEquals('e', MissingLetterFinder.findMissingLetter(new char[] { 'a', 'b', 'c', 'd', 'f' }));
		assertEquals('P', MissingLetterFinder.findMissingLetter(new char[] { 'O', 'Q', 'R', 'S' }));
	}
}
