package main.graph;

/**
 * 邻阶矩阵
 * 
 * @author pankarl
 *
 */
public class AdjacencyMatrixGraph<T> {
	private T[] nodes; //顶点集合
	private int[][] amGraph; //邻阶矩阵数据
	
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
		createAdjacencyMatrixGraph(edges, flag);
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
