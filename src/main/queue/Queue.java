package main.queue;

/**
 * 队列 先进先出（First In First Out）的线性序列，称为队列。
 * 队列也是一种线性表，只不过它是操作受限的线性表，只能在两端操作：一端进，一端出。
 * 进的一端称为队尾（rear），出的一端称为队头（front）。队列可以用顺序存储，也可以用链式存储。
 * @author pankarl
 *
 */
public interface Queue<T> {
	/**
	 * 判断是否队满
	 * @return
	 */
	boolean isFull();
	
	/**
	 * 判断是否队空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 入队
	 * @param t
	 * @return
	 */
	boolean push(T t);
	
	/**
	 * 出队
	 * @return
	 */
	T pop();
	
	/**
	 * 取队头
	 * @return
	 */
	T top();
}
