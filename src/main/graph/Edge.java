package main.graph;

/**
 * 数据结构图中边的类型
 * 
 * 如果边为有向边，则left为弧尾，right为弧头
 * 
 * @author pankarl
 *
 */
public class Edge<T> {
	private T left; 
	private T right;
	private int weight;
	
	private final int DEFAULT_WEIGHT = 1; //默认权重为1
	
	public Edge() {
		this.weight = DEFAULT_WEIGHT;
	}
	
	public Edge(T left, T right) {
		this.left = left;
		this.right = right;
		this.weight = DEFAULT_WEIGHT;
	}
	
	public Edge(T left, T right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	public T getLeft() {
		return left;
	}

	public void setLeft(T left) {
		this.left = left;
	}

	public T getRight() {
		return right;
	}

	public void setRight(T right) {
		this.right = right;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
