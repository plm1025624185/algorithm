package test.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import main.string.KMP;

@RunWith(JUnit4.class)
public class KMPTest {
	
	@Test
	public void testKMP() {
		assertEquals(KMP.findStringByKMP("abccd", "cc"), "abccd".indexOf("cc"));
		assertEquals(KMP.findStringByKMP("abccderfa", "cbac"), "abccderfa".indexOf("cbac"));
		
	}
}
