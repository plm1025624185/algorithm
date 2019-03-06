package main.queue;

public class LinkedQueue<T> implements Queue<T> {
	private final static int DEFAULT_SIZE = 16;
	
	private int size;
	
	private int maxSize;
	
	private Node<T> rear;
	
	private Node<T> front;
	
	
	public LinkedQueue() {
		maxSize = DEFAULT_SIZE;
		rear = front = new Node<>(null);
		size = 0;
	}
	
	public LinkedQueue(int maxSize) {
		this.maxSize = maxSize;
		rear = front = new Node<>(null);
		size = 0;
	}

	@Override
	public boolean isFull() {
		return maxSize == size;
	}

	@Override
	public boolean isEmpty() {
		return front.next == null;
	}

	@Override
	public boolean push(T t) {
		if(isFull()) {
			return false;
		}else{
			Node<T> node = new Node<>(t);
			rear.next = node;
			rear = node;
			size++;
			return true;
		}
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			return null;
		}else {
			Node<T> tmp = front.next;
			front.next = front.next.next;
			size--;
			if(size == 0) {
				rear = front;
			}
			return tmp.value;
		}
		
	}

	@Override
	public T top() {
		if(isEmpty()) {
			return null;
		}else {
			return front.next.value;
		}
	}
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		private T value;
		private Node<T> next;
		
		public Node(T t) {
			this.value = t;
			next = null;
		}
	}

}
