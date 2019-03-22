package test.tree;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import main.tree.BinaryTree;

@RunWith(JUnit4.class)
public class BinaryTreeTest {
	private BinaryTree btree;
	private BinaryTree pmBtree;
	private BinaryTree mpBtree;
	
	@Before
	public void init() {
		btree = new BinaryTree("ABD##E##CF#G###", '#');
		pmBtree = new BinaryTree(new char[] {
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'I'
		}, new char[] {
			'B', 'C', 'D', 'A', 'F', 'E', 'J', 'H', 'I', 'G'	
		}, "PM");
		mpBtree = new BinaryTree(new char[] {
			'B', 'C', 'D', 'A', 'F', 'E', 'J', 'H', 'I', 'G'	
		}, new char[] {
			'D', 'C', 'B', 'F', 'J', 'I', 'H', 'G', 'E', 'A'	
		}, "MP");
	}
	
	@Test
	public void testPreOrder() {
		assertEquals(btree.dlr(), "ABD##E##CF#G###");
		assertEquals(pmBtree.dlr(), "ABCDEFGHJI");
		assertEquals(mpBtree.dlr(), "ABCDEFGHJI");
	}
	
	@Test
	public void testMiddleOrder() {
		assertEquals(pmBtree.ldr(), "BCDAFEJHIG");
		assertEquals(mpBtree.ldr(), "BCDAFEJHIG");
	}
	
	@Test
	public void testPostOrder() {
		assertEquals(pmBtree.lrd(), "DCBFJIHGEA");
		assertEquals(mpBtree.lrd(), "DCBFJIHGEA");
	}
	
	@Test
	public void testDepth() {
		assertEquals(btree.depth(), 4);
	}

}
