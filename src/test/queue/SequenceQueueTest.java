package test.queue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.queue.SequenceQueue;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SequenceQueueTest {
	private SequenceQueue<String> queue;
	
	@Before
	public void before() {
		queue = new SequenceQueue<>(4);
	}
	
	@Test
	public void testIsFullAndEmpty() {
		assertTrue(queue.isEmpty());
		for(int i = 0; i < 3; i++) {
			queue.push("a" + i);
		}
		assertFalse(queue.isFull());
		queue.push("a3");
		assertTrue(queue.isFull());
		for(int i = 0; i < 4; i++) {
			queue.pop();
		}
		assertTrue(queue.isEmpty());
		queue.push("T");
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testPushAndTop() {
		for(int i = 0; i < 4; i++) {
			queue.push("a" + i);
		}
		assertEquals("a0", queue.pop());
		queue.push("a4");
		assertEquals("a1", queue.top());
	}
}
