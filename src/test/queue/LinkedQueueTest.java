package test.queue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import main.queue.LinkedQueue;

@RunWith(JUnit4.class)
public class LinkedQueueTest {
	private LinkedQueue<String> queue;
	
	@Before
	public void init() {
		queue = new LinkedQueue<>(4);
		queue.push("A");
		queue.push("B");
		queue.push("C");
		queue.push("D");
	}
	
	@Test
	public void testFullAndEmpty() {
		assertTrue(queue.isFull());
		while(!queue.isEmpty()) {
			System.out.println(queue.pop());
		}
		assertTrue(queue.isEmpty());
		queue.push("t");
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testPushAndPop() {
		assertEquals("A", queue.pop());
		queue.push("E");
		assertEquals("B", queue.top());
	}
}
