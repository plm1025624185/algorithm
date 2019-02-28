package main.stack;

/**
 * 链栈
 * @author pankarl
 *
 */
public class LinkedStack<T> implements Stack<T> {
	
	private final static int DEFAULT_SIZE = 16; //链栈的默认大小
	
	private int size; //栈的大小
	
	private Node<T> top; //栈顶指针
	
	private int length; //栈的当前长度
	
	public LinkedStack() {
		size = DEFAULT_SIZE;
		length = 0;
		top = new Node<>();
	}
	
	public LinkedStack(int size) {
		this.size = size;
		length = 0;
		top = new Node<>();
	}

	@Override
	public boolean isFull() {
		return length == size;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public boolean push(T t) {
		if(isFull())
			return false;
		else {
			Node<T> tmp = new Node<>(t);
			tmp.next = top.next;
			top.next = tmp;
			length++;
			return true;
		}
	}

	@Override
	public T pop() {
		if(isEmpty())
			return null;
		else {
			Node<T> tmp = top.next;
			top.next = top.next.next;
			length--;
			return tmp.data;
		}
	}

	@Override
	public T top() {
		if(isEmpty())
			return null;
		else
			return top.next.data;
	}
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		T data; //存储的数据
		Node<T> next; //指向下一个的指针
		
		public Node() {}
		
		public Node(T t) {
			this.data = t;
		}
	}
}
