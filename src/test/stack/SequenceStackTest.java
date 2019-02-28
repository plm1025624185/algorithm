package test.stack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.stack.SequenceStack;
import main.stack.Stack;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SequenceStackTest {
	private Stack<String> stack;
	
	@Before
	public void init() {
		stack = new SequenceStack<>(8);
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testIsFull() {
		assertFalse(stack.isFull());
		for(int i = 0; i < 8; i++) {
			stack.push("a" + i);
		}
		assertTrue(stack.isFull());
	}
	
	@Test
	public void testPop() {
		assertNull(stack.pop());
		stack.push("top");
		assertEquals("top", stack.pop());
	}
	
	@Test
	public void testTop() {
		assertNull(stack.top());
		stack.push("top");
		assertEquals("top", stack.top());
	}
}
