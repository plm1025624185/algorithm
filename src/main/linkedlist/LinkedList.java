package main.linkedlist;

/**
 * 链表接口
 *     链表是线性表的链式存储方式
 * @author pankarl
 *
 */
public interface LinkedList<T> {
	/**
	 * 头插法
	 * @param obj
	 * @return
	 */
	boolean insertHead(T obj);
	
	/**
	 * 尾插法
	 * @param obj
	 * @return
	 */
	boolean insertTail(T obj);
	
	/**
	 * 将对象插入到某个索引上
	 * @param obj
	 * @param index
	 * @return
	 */
	boolean insert(T obj, int index);
	
	/**
	 * 根据索引进行查找
	 * @param index
	 * @return
	 */
	T findByIndex(int index);
	
	/**
	 * 获取倒数第k个节点
	 * @param index
	 * @return
	 */
	T findLastByIndex(int index);
	
	/**
	 * 根据对象进行查找
	 * @param obj
	 * @return
	 */
	T findByObj(T obj);
	
	/**
	 * 获取链表的中间值
	 * @return
	 */
	T findMiddle();
	
	/**
	 * 删除某个对象
	 * @param obj
	 * @return
	 */
	boolean delete(T obj);
	
	/**
	 * 删除索引上的对象
	 * @param index
	 * @return
	 */
	boolean delete(int index);
}
