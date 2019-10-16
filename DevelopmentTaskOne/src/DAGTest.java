import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {
	
 	
	@Test
	public void testForDAG()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		
		assertEquals(1, graph.indegree(4));
		assertEquals(2, graph.outdegree(4));
		assertEquals(5, graph.E());
		assertEquals(10, graph.V());
		String adj = "[6, 7]";
		assertEquals(adj, graph.adj(4).toString());
	}
	
	@Test
	public void testAdj()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		graph.addEdge(4, 3);
		
		String adj = "[4]";
		assertEquals(adj, graph.adj(2).toString());
	}

	@Test
	public void addEdgeTest() {
		DAG edgeTest = new DAG(5);
		edgeTest.addEdge(0, 1);
		edgeTest.addEdge(-2, -5);
		
		assertEquals("Testing edge count is 1", 1, edgeTest.E());
		
		edgeTest.addEdge(1, 2);
		
		assertEquals("Testing edge count is 2", 2, edgeTest.E());
		
	}
	
	@Test
	public void inDegreeTest(){
		DAG graph = new DAG(5);
		assertEquals("", -1, graph.indegree(-3));
	}
	
	@Test
	public void outDegreeTest(){
		DAG graph = new DAG(5);
		assertEquals("", -1, graph.outdegree(8));	
	}

	@Test 
	public void testV()
	{
		DAG VTest = new DAG(6);
		assertEquals(6, VTest.V());
	}
	
	@Test
	public void testE(){
		
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		
		assertEquals(4, graph.E());
	}
	
	@Test
	public void cycleTest(){
		DAG isCyclic = new DAG(20);
		isCyclic.addEdge(0, 1);
		isCyclic.addEdge(1, 2);
		isCyclic.addEdge(2, 0);
		
		isCyclic.findCycle(0);
		assertTrue(isCyclic.hasCycle());
		
		DAG isAcyclic = new DAG(20);
		isAcyclic.addEdge(0, 1);
		isAcyclic.addEdge(1, 3);
		isAcyclic.addEdge(2, 4);
		isAcyclic.findCycle(0);
		assertFalse(isAcyclic.hasCycle());
	}
}
