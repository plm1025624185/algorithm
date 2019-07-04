package main.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻阶矩阵
 * 
 * @author pankarl
 *
 */
public class AdjacencyMatrixGraph<T> {
	private T[] nodes; //顶点集合
	private int[][] amGraph; //邻阶矩阵数据
	
	
	private boolean[] visited; //是否被访问过的集合
	
	public AdjacencyMatrixGraph() {}
	
	/**
	 * 创建邻阶矩阵
	 * @param nodes
	 * @param edges
	 * @param flag flag为true则是有向，false为无向
	 */
	public AdjacencyMatrixGraph(T[] nodes, Edge<T>[] edges, boolean flag) {
		this.nodes = nodes;
		this.amGraph = new int[nodes.length][nodes.length];
		this.visited = new boolean[nodes.length];
		createAdjacencyMatrixGraph(edges, flag);
	}
	
	/**
	 * 初始化访问数组
	 */
	private void initVisited() {
		for(int i = 0; i < this.visited.length; i++) {
			this.visited[i] = false;
		}
	}
	
	private void createAdjacencyMatrixGraph(Edge<T>[] edges, boolean flag) {
		for(Edge<T> edge : edges) {
			//获取左右两边的索引
			int left = findIndexByNodes(edge.getLeft());
			int right = findIndexByNodes(edge.getRight());
			//判断是有序还是无序，无序图对称的点上也需要赋值
			amGraph[left][right] = edge.getWeight();
			if(!flag) {
				amGraph[right][left] = edge.getWeight();
			}
		}
	}
	
	/**
	 * 根据节点获取对应的索引
	 * @param node
	 * @return
	 */
	private int findIndexByNodes(T node) {
		for(int i = 0; i < nodes.length; i++) {
			if(node.equals(nodes[i])) {
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
	 * 深度优先搜索（Depth First Search，DFS）
	 * 注意：这里搜索的都是强连通图，非强连通图还需要一个循环来查询哪些节点未被访问
	 * @param sb
	 * @param node
	 * @return
	 */
	private void depthFirstSearch(StringBuilder sb, int node) {
		//首先对节点的值进行储存
		sb.append(this.nodes[node].toString());
		//设置该节点已被访问过
		this.visited[node] = true;
		//遍历节点的邻接点
		for(int i = 0; i < this.amGraph[node].length; i++) {
			//如果当前节点是邻接节点并且该节点未被访问过，则递归调用
			if(this.amGraph[node][i] > 0 && !this.visited[i]) {
				depthFirstSearch(sb, i);
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
		initVisited();
		return sb.toString();
	}
	
	/**
	 * 广度优先搜索（Breadth First Search，BFS）
	 * 注意：这里搜索的都是强连通图，非强连通图还需要一个循环来查询哪些节点未被访问
	 * @param sb
	 * @param queue 用来储存节点
	 */
	private void breadthFirstSearch(StringBuilder sb, Queue<Integer> queue) {
		while(!queue.isEmpty()) {
			//节点出队
			int node = queue.poll();
			//存入节点信息
			sb.append(this.nodes[node].toString());
			//获取没有访问过的邻接点存入到队列中
			for(int i = 0; i < this.amGraph[node].length; i++) {
				if(this.amGraph[node][i] > 0 && !this.visited[i]) {
					queue.add(i);
					//修改访问标志
					this.visited[i] = true;
				}
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < amGraph.length; i++) {
			if(i != 0) {
				sb.append("\n");
			}
			for(int j = 0; j < amGraph[i].length; j++) {
				if(j != 0) {
					sb.append("\t");
				}
				sb.append(amGraph[i][j]);
			}
		}
		return sb.toString();
	}
	
	public T[] getNodes() {
		return nodes;
	}

	public void setNodes(T[] nodes) {
		this.nodes = nodes;
	}

	public int[][] getAmGraph() {
		return amGraph;
	}

	public void setAmGraph(int[][] amGraph) {
		this.amGraph = amGraph;
	}
	
}
