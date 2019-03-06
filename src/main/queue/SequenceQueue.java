package main.queue;

/**
 * 顺序队列又称为循环队列
 * 这里为了防止数据的假溢出，故使用取余进行循环
 * 这里MAX_SIZE的值为用户设置的size + 1，这里预留一个字段用于判断队列是否已满
 * @author pankarl
 *
 */
public class SequenceQueue<T> implements Queue<T> {
	private final static int DEFAULT_MAXSIZE = 16;
	
	private T[] base; //基础数据结构
	
	private int front; //头指针
	
	private int rear; //尾指针
	
	@SuppressWarnings("unchecked")
	public SequenceQueue() {
		base = (T[]) new Object[DEFAULT_MAXSIZE + 1];
		front = 0;
		rear = 0;
	}
	
	@SuppressWarnings("unchecked")
	public SequenceQueue(int size) {
		base = (T[]) new Object[size + 1];
		front = 0;
		rear = 0;
	}

	@Override
	public boolean isFull() {
		return front == (rear + 1) % base.length;
	}

	@Override
	public boolean isEmpty() {
		return rear == front;
	}

	@Override
	public boolean push(T t) {
		if(isFull())
			return false;
		else {
			base[rear] = t;
			rear = (rear + 1) % base.length;
			return true;
		}
	}

	@Override
	public T pop() {
		if(isEmpty())
			return null;
		else {
			T tmp = base[front];
			front = (front + 1) % base.length;
			return tmp;
		}
	}

	@Override
	public T top() {
		return base[front];
	}

}
