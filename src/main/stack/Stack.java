package main.stack;

/**
 * 后进先出（Last In First Out, LIFO）的线性序列，称为栈。
 * 栈也是一种线性表，只不过它是操作受限的线性表，只能在一端进出操作。
 * 进出的一端称为栈顶（top），另一端称为栈底（base）。
 * 栈可以用顺序存储，也可以用链式存储，分别称为顺序栈和链栈
 * @author pankarl
 *
 */
public interface Stack<T> {
	/**
	 * 是否满栈
	 * @return
	 */
	boolean isFull();
	
	/**
	 * 是否空栈
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 入栈
	 * @param t
	 * @return
	 */
	boolean push(T t);
	
	/**
	 * 出栈
	 * @return
	 */
	T pop();
	
	/**
	 * 获取栈顶元素
	 * @return
	 */
	T top();
}
