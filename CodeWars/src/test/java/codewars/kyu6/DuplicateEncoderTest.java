package codewars.kyu6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import codewars.kyu6.DuplicateEncoder;

public class DuplicateEncoderTest {
	@Test
	public void test() {
		assertThat(DuplicateEncoder.encode("Prespecialized"), is(")()())()(()()("));
		assertEquals("))))())))", DuplicateEncoder.encode("   ()(   "));
	}
}
