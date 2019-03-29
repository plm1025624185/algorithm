package test.Graph;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.graph.AdjacencyMatrixGraph;
import main.graph.Edge;

@RunWith(JUnit4.class)
public class AdjacencyMatrixGraphTest {
	
	private AdjacencyMatrixGraph<String> amGraph;
	
	private AdjacencyMatrixGraph<String> amGraphOrder;
	
	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		String[] nodes = new String[] {
				"a", "b", "c", "d"
		};
		Edge<String>[] edges = new Edge[] {
				new Edge<String>("a", "b"),
				new Edge<String>("a", "d"),
				new Edge<String>("b", "d"),
				new Edge<String>("b", "c"),
				new Edge<String>("c", "d")
		};
		//创建无向图
		amGraph = new AdjacencyMatrixGraph<>(nodes, edges, false);
		
		String[] nodesOrder = new String[] {
				"a", "b", "c", "d", "e"
		};
		Edge<String>[] edgesOrder = new Edge[] {
				new Edge<String>("a", "b"),
				new Edge<String>("a", "c"),
				new Edge<String>("a", "e"),
				new Edge<String>("b", "c"),
				new Edge<String>("c", "d"),
				new Edge<String>("c", "e"),
				new Edge<String>("d", "e"),
				new Edge<String>("d", "a")
		};
		//创建有向图
		amGraphOrder = new AdjacencyMatrixGraph<>(nodesOrder, edgesOrder, true);
	}
	
	@Test
	public void testCreate() {
		System.out.println("无向图的邻阶矩阵：");
		System.out.println(amGraph.toString());
		System.out.println("有向图的邻阶矩阵：");
		System.out.println(amGraphOrder.toString());
	}
	
}
