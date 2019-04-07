package main.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 邻接表
 * @author pankarl
 *
 */
public class AdjacencyTableGraph<T> {
	private T[] vertexes; //顶点集合
	private boolean[] visited; //访问过的集合
	private Node<T>[] atGraph;
	
	public AdjacencyTableGraph() {}
	
	public AdjacencyTableGraph(T[] nodes, Edge<T>[] edges, boolean flag) {
		this.vertexes = nodes;
		init();
		createAdjacencyTableGraph(edges, flag);
	}
	
	@SuppressWarnings("unchecked")
	private void init() {
		this.atGraph = new Node[this.vertexes.length];
		for(int i = 0; i < this.vertexes.length; i++) {
			this.atGraph[i] = new Node<T>(i, -1);
		}
		this.visited = new boolean[this.vertexes.length];
	}
	
	/**
	 * 初始化访问数组
	 */
	private void initVisited() {
		for(int i = 0; i < this.visited.length; i++) {
			this.visited[i] = false;
		}
	}
	
	private void createAdjacencyTableGraph(Edge<T>[] edges, boolean flag) {
		Node<T> tmp;
		int left;
		int right;
		for(Edge<T> edge : edges) {
			left = findIndexByValue(edge.getLeft());
			right = findIndexByValue(edge.getRight());
			tmp = new Node<T>(right, edge.getWeight());
			tmp.next = this.atGraph[left].next;
			this.atGraph[left].next = tmp;
			if(!flag) {
				//无向图两边节点都要添加
				tmp = new Node<T>(left, edge.getWeight());
				tmp.next = this.atGraph[right].next;
				this.atGraph[right].next = tmp;
			}
		}
	}
	
	/**
	 * 获取对应的索引
	 * @param value
	 * @return
	 */
	private int findIndexByValue(T value) {
		for(int i = 0; i < vertexes.length; i++) {
			if(vertexes[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 深度优先搜索
	 * @return
	 */
	public String depthFirstSearch() {
		StringBuilder sb = new StringBuilder();
		depthFirstSearch(sb, 0);
		initVisited();
		return sb.toString();
	}
	
	/**
	 * 深度优先搜索
	 * @param sb
	 * @param node
	 */
	private void depthFirstSearch(StringBuilder sb, int node) {
		List<Integer> list = new ArrayList<>();
		//储存值
		sb.append(vertexes[node].toString());
		//更新访问标记
		this.visited[node] = true;
		//获取邻接点
		Node<T> tmp = this.atGraph[node].next;
		while(tmp != null) {
			list.add(tmp.value);
			tmp = tmp.next;
		}
		//对节点进行排序，值小的在前面
		list.sort(new IntegerComparator());
		for(Integer t : list) {
			if(!this.visited[t]) {
				//如果没被访问过就进行迭代
				depthFirstSearch(sb, t);
			}
		}
	}
	
	/**
	 * 广度优先搜索
	 * @return
	 */
	public String breadthFirstSearch() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		this.visited[0] = true;
		breadthFirstSearch(sb, queue);
		return sb.toString();
	}
	
	private void breadthFirstSearch(StringBuilder sb, Queue<Integer> queue) {
		List<Integer> list = new ArrayList<>(); //主要用于排序
		while(!queue.isEmpty()) {
			//节点出队
			int node = queue.poll();
			sb.append(this.vertexes[node].toString());
			//获取未被访问的邻接点
			Node<T> tmp = atGraph[node].next;
			while(tmp != null) {
				if(!this.visited[tmp.value]) {
					list.add(tmp.value);
					this.visited[tmp.value] = true;
				}
				tmp = tmp.next;
			}
			list.sort(new IntegerComparator());
			queue.addAll(list);
			list.clear();
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> head;
		Node<T> cur;
		for(int i = 0; i < vertexes.length; i++) {
			head = atGraph[i];
			cur = head.next;
			while(cur != null) {
				sb.append(String.format("%d-%d的权重为%d", head.value, cur.value, cur.weight));
				cur = cur.next;
				sb.append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * 节点数据结构
	 * @author pankarl
	 *
	 */
	@SuppressWarnings("hiding")
	private class Node<T>{
		private int weight; //权重
		private int value; //对应的顶点索引
		private Node<T> next; //邻接的节点索引
		
		public Node(int value, int weight) {
			this.value = value;
			this.weight = weight;
			this.next = null;
		}
	}
}
