package main.linkedlist;

import main.exception.IllegalTypeException;

/**
 * 单链表的实现
 * @author pankarl
 *
 */
public class SingleLinkedList<T> implements LinkedList<T> {
	private Node<T> head; //头节点
	
	private int size; //链表大小
	
	public SingleLinkedList() {
		//初始化头节点
		head = new Node<T>();
		size = 0;
	}
	
	public SingleLinkedList(T[] array, int type) throws IllegalTypeException{
		//初始化头节点
		head = new Node<T>();
		size = 0;
		for(int i = 0; i < array.length; i++) {
			if(type == 0) {
				//如果是0为头插入
				insertHead(array[i]);
			}else if(type == 1) {
				//如果是1为尾插入
				insertTail(array[i]);
			}else {
				throw new IllegalTypeException("非法的插入类型！");
			}
		}
	}
	
	private Node<T> findNodeByIndex(int index) {
		//索引小于0时直接返回
		if(index < -1) {
			return null;
		}
		if(index == -1) {
			return head;
		}
		Node<T> tmp = head.next;
		int i = 0;
		while(i != index) {
			if(tmp.next == null) {
				return null;
			}
			tmp = tmp.next;
			i++;
		}
		return tmp;
	}
 	
	/**
	 * 根据对象查找节点
	 * @param obj
	 * @param isPrevious 如果为true返回与对象相等的前一个节点，如果为false返回与对象相等的节点
	 * @return
	 */
	private Node<T> findNodeByObj(T obj, boolean isPrevious){
		Node<T> tmp = head;
		while(tmp.next != null) {
			if(tmp.next.data.equals(obj)) {
				return isPrevious ? tmp : tmp.next;
			}
			tmp = tmp.next;
		}
		return null;
	}
	
	/**
	 * 根据对象查找相等的节点
	 */
	private Node<T> findNodeByObj(T obj){
		return findNodeByObj(obj, false);
	}
	
	/**
	 * 找到尾节点
	 * @return
	 */
	private Node<T> findTailNode(){
		Node<T> node = head;
		while(node.next != null) {
			node = node.next;
		}
		return node;
	}

	@Override
	public boolean insertHead(T obj) {
		Node<T> tmp = new Node<T>(obj);
		if(head.next == null) {
			head.next = tmp;
		}else {
			tmp.next = head.next;
			head.next = tmp;
		}
		size++;
		return true;
	}

	@Override
	public boolean insertTail(T obj) {
		Node<T> tmp = new Node<T>(obj);
		Node<T> tail = findTailNode();
		tail.next = tmp;
		size++;
		return true;
	}

	@Override
	public boolean insert(T obj, int index) {
		Node<T> node = findNodeByIndex(index - 1);
		if(node == null)
			return false;
		else {
			Node<T> tmp = new Node<>(obj);
			tmp.next = node.next;
			node.next = tmp;
			size++;
			return true;
		}
	}
	
	@Override
	public T findByIndex(int index) {
		//索引小于0时直接返回
		Node<T> tmp = findNodeByIndex(index);
		return tmp == null ? null : tmp.data;
	}

	/**
	 * 如果不用size来标记，那可以借鉴快慢索引来设计，两个临时指针a,b, 
	 * a比b先走index步，然后一起往后，a到了尾节点，则返回b
	 */
	@Override
	public T findLastByIndex(int index) {
		if(index > -1 && index < size) {
			return findByIndex(size - index - 1);
		}else {
			return null;
		}
	}
	
	/**
	 * 使用快慢节点来实现查找中间节点
	 */
	@Override
	public T findMiddle() {
		Node<T> quick = head.next;
		Node<T> slow = head.next;
		while(quick.next != null && quick.next.next != null) {
			quick = quick.next.next;
			slow = slow.next;
		}
		return slow.data;
	}
	
	@Override
	public T findByObj(T obj) {
		Node<T> tmp = findNodeByObj(obj);
		return tmp == null ? null : tmp.data;
	}

	@Override
	public boolean delete(T obj) {
		Node<T> node = findNodeByObj(obj, true);
		if(node == null)
			return false;
		else {
			Node<T> tmp = null;
			tmp = node.next.next;
			node.next = tmp;
			size--;
			return true;
		}
	}

	@Override
	public boolean delete(int index) {
		Node<T> node = findNodeByIndex(index - 1);
		if(node == null || node.next == null)
			return false;
		else {
			Node<T> tmp = node.next.next;
			node.next = tmp;
			size--;
			return true;
		}
		
	}
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node() {}
		
		private Node(T data) {
			this.data = data;
		}
	}
	
	public String toString() {
		Node<T> tmp = head;
		StringBuilder s = new StringBuilder();
		while(tmp.next != null) {
			s.append(tmp.next.data.toString());
			if(tmp.next.next != null) {
				s.append("---");
			}
			tmp = tmp.next;
		}
		return s.toString();
	}

}
