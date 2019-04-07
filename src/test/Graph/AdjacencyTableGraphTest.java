package test.Graph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.graph.AdjacencyTableGraph;
import main.graph.Edge;

@RunWith(JUnit4.class)
public class AdjacencyTableGraphTest {
	private AdjacencyTableGraph<String> atGraph;
	private AdjacencyTableGraph<String> atGraphOrder;
	
	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		// 无向邻接表
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
		atGraph = new AdjacencyTableGraph<>(nodes, edges, false);
		// 有向邻接表
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
		atGraphOrder = new AdjacencyTableGraph<>(nodesOrder, edgesOrder, true);
	}
	
	@Test
	public void create() {
		System.out.println("-------------邻接无向图------------");
		System.out.println(atGraph.toString());
		System.out.println("-------------邻接有向图------------");
		System.out.println(atGraphOrder.toString());
	}
	
	@Test
	public void testDepthFirstSearch() {
		assertEquals("abcd", atGraph.depthFirstSearch());
		assertEquals("abcde", atGraphOrder.depthFirstSearch());
	}
	
	@Test
	public void testBreadthFirstSearch() {
		assertEquals("abdc", atGraph.breadthFirstSearch());
		assertEquals("abced", atGraphOrder.breadthFirstSearch());
	}
}
