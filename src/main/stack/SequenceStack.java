package main.stack;

/**
 * 顺序栈
 * @author pankarl
 *
 */
public class SequenceStack<T> implements Stack<T> {
	private final static int DEFAULT_SIZE = 16; //数组的长度，默认为16
	
	private T[] data; //存储数据
	
	private int top = 0; //栈的顶点地址
	
	@SuppressWarnings("unchecked")
	public SequenceStack() {
		data = (T[]) new Object[DEFAULT_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public SequenceStack(int size) {
		data = (T[]) new Object[size];
	}
	
	@Override
	public boolean isFull() {
		return top == data.length;
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}
	
	@Override
	public boolean push(T t) {
		if(isFull())
			return false;
		else {
			data[top++] = t;
			return true;
		}
	}

	@Override
	public T pop() {
		if(isEmpty())
			return null;
		else
			return data[--top];
	}

	@Override
	public T top() {
		if(isEmpty())
			return null;
		else
			return data[top - 1];
	}

	public String toString() {
		return String.format("当前栈顶指针%d", top);
	}
}
