package test.tree;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.tree.HuffmanArrayTree;

@RunWith(JUnit4.class)
public class HuffmanArrayTreeTest {
	private HuffmanArrayTree tree;
	
	@Before
	public void init() {
		char[] data = new char[] {
				'a', 'b', 'c', 'd', 'e', 'f'
		};
		int[] weights = new int[] {
				45, 13, 12, 16, 9, 5
		};
		tree = new HuffmanArrayTree(data, weights);
	}
	
	@Test
	public void testLevelTraversal() {
		System.out.println(tree.levelTraversal());
	}
	
	@Test
	public void testHuffmanCode() {
		System.out.println(tree.huffmanCode());
	}
}
