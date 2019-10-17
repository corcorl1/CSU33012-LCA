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
	
	@Test
	public void testLCAForNonDAG()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 4);
		
		assertEquals(-1, graph.findLCA(3, 2));
		assertEquals(-1, graph.findLCA(2, 4));
		assertEquals(-1, graph.findLCA(1, 3));
		assertEquals(-1, graph.findLCA(0, 3));
		assertEquals(-1, graph.findLCA(1, 2));
		
	}
	
	@Test
	public void testLCA(){
		DAG lcaTest = new DAG(10);

		lcaTest.addEdge(0, 1);
		lcaTest.addEdge(1, 2);
		lcaTest.addEdge(1, 3);
		lcaTest.addEdge(2, 5);
		lcaTest.addEdge(3, 4);
		lcaTest.addEdge(4, 6);
		lcaTest.addEdge(5, 6);
		lcaTest.addEdge(6, 8);
		lcaTest.addEdge(5, 7);
		lcaTest.addEdge(7, 8);
		lcaTest.addEdge(8, 9);
		
		assertEquals("4 and 5", 1, lcaTest.findLCA(5, 4));
		assertEquals("7 and 8", 7, lcaTest.findLCA(8, 7));
		assertEquals("6 and 8", 6, lcaTest.findLCA(6, 8));
		assertEquals("Special case where both parameters are same vertex", 2, lcaTest.findLCA(2,2));
	

	}

}
