package test.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import main.string.BF;

@RunWith(JUnit4.class)
public class BFTest {
	
	@Test
	public void testBF() {
		int index = BF.findStringByBF("abccd", "cca");
		assertEquals(index, "abccd".indexOf("cca"));
		index = BF.findStringByBF("aaaaaaab", "ab");
		assertEquals(index, "aaaaaaab".indexOf("ab"));
	}

}
