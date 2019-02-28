package test.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.exception.IllegalTypeException;
import main.linkedlist.SingleLinkedList;

@RunWith(JUnit4.class)
public class SingleLinkedListTest {
	
	private SingleLinkedList<String> hlist; //头插入列表
	private SingleLinkedList<String> tlist; //尾插入列表
	
	private final String FORMAT = "%s操作后，%s链表的值为%s";
	
	@Before
	public void init() throws IllegalTypeException {
		String[] array = new String[] {
				"a", "b", "c"
		};
		hlist = new SingleLinkedList<>(array, 0);
		tlist = new SingleLinkedList<>(array, 1);
	}
	
	@Test
	public void testfindByIndex() {
		String hstr = hlist.findByIndex(0);
		String tstr = tlist.findByIndex(0);
		Assert.assertEquals("c", hstr);
		Assert.assertEquals("a", tstr);
		Assert.assertEquals("c", tlist.findLastByIndex(0));
		Assert.assertEquals("b", hlist.findMiddle());
		System.out.println(String.format(FORMAT, "testfindByIndex", "hlist", hlist.toString()));
		System.out.println(String.format(FORMAT, "testfindByIndex", "tlist", tlist.toString()));
	}
	
	@Test
	public void testFindByObj() {
		String hstr = hlist.findByObj("a");
		String tstr = tlist.findByObj("d");
		Assert.assertEquals("a", hstr);
		Assert.assertNull(tstr);
		System.out.println(String.format(FORMAT, "testFindByObj", "hlist", hlist.toString()));
		System.out.println(String.format(FORMAT, "testFindByObj", "tlist", tlist.toString()));
	}
	
	@Test
	public void testInsert() {
		Assert.assertFalse(hlist.insert("d", 4));
		Assert.assertTrue(tlist.insert("d", 1));
		Assert.assertEquals("d", tlist.findByIndex(1));
		System.out.println(String.format(FORMAT, "testInsert", "hlist", hlist.toString()));
		System.out.println(String.format(FORMAT, "testInsert", "tlist", tlist.toString()));
	}
	
	@Test
	public void testDelete() {
		Assert.assertTrue(hlist.delete(0));
		Assert.assertFalse(hlist.delete(4));
		Assert.assertTrue(tlist.delete("b"));
		System.out.println(String.format(FORMAT, "testDelete", "hlist", hlist.toString()));
		System.out.println(String.format(FORMAT, "testDelete", "tlist", tlist.toString()));
	}
}
