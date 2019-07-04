package main.graph;

/**
 * 使用邻接矩阵实现tarjan算法
 * @author pankarl
 *
 */
public class AdjacencyMatrixForTarjan<T> {
	private int[][] graph; //邻接矩阵
	private T[] nodes; //顶点集合
	private int[] dfn; //tarjan算法中节点的时间戳
	private int[] low; //tarjan算法中节点的回溯点
	
	public AdjacencyMatrixForTarjan() {}
	
	/**
	 * 创建邻接矩阵
	 * @param nodes 图的节点集合
	 * @param edges 图的边集
	 * @param flag 标志，有向图还是无向图
	 */
	public AdjacencyMatrixForTarjan(T[] nodes, Edge<T>[] edges, boolean flag) {
		this.nodes = nodes;
		
	}
}
