
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG
{
	private int V;						//no. vertices
	private int E;						//no. edges
	private ArrayList<Integer>[] adj;   //adj[V] = adjacency list for vertex V
	private int [] indegree;			//indegree[V] = indegree of vertex V
	private int [] outdegree;			//outdegree[V] = outdegree of vertex V
	private boolean marked [];			//list of visited vertices
	private boolean hasCycle;			//True if graph has cycle
	private boolean stack [];			//
	
	
	public DAG(int V)
	{
		if(V < 0)
		{
			throw new IllegalArgumentException("Number of vertices must be greater than 0");
		}
		
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		marked = new boolean[V];
		stack = new boolean[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for(int v = 0; v < V; v++)
		{
			adj[v] = new ArrayList<Integer>();
		}
	}
	
	//Returns current vertex
	public int V()
	{
		return V;
	}
	
	public int E()
	{
		return E;
	}
	
	//Adds directed edge from v to w
	public void addEdge(int v, int w)
	{
		if((validateVertex(v) > 0) && (validateVertex(w) > 0))
		{
			adj[v].add(w);
			indegree[w]++;
			E++;
		}
		else
		{
			System.out.println("Please enter numbers between 0 and " + (V-1));
		}		
	}
	
	private int validateVertex(int v)
	{
		if(v < 0 || v >= V)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	//Returns number of directed edges to vertex v
	public int indegree(int v)
	{
		if(validateVertex(v) > 0)
		{
			return indegree[v];
		}
		else
		{
			return -1;
		}
		
	}
	
	//Returns number of directed edges from vertex v
	public int outdegree(int v)
	{
		if(validateVertex(v) > 0)
		{
			return adj[v].size();
		}
		else
		{
			return -1;
		}
	}

	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
}