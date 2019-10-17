
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
	private int V;
	private int E;
	private ArrayList<Integer>[] adj;
	private int[] indegree;
	private boolean marked[];
	private boolean hasCycle;
	private boolean stack[];

	public DAG(int V) {
		if (V < 0) {
			throw new IllegalArgumentException("Number of vertices must be greater than 0");
		}

		this.V = V;
		this.E = 0;
		indegree = new int[V];
		marked = new boolean[V];
		stack = new boolean[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];

		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		if ((validateVertex(v) > 0) && (validateVertex(w) > 0)) {
			adj[v].add(w);
			indegree[w]++;
			E++;
		} else {
			System.out.println("Please enter numbers between 0 and " + (V - 1));
		}
	}

	private int validateVertex(int v) {
		if (v < 0 || v >= V) {
			return -1;
		} else {
			return 1;
		}
	}

	public int indegree(int v) {
		if (validateVertex(v) > 0) {
			return indegree[v];
		} else {
			return -1;
		}

	}

	public int outdegree(int v) {
		if (validateVertex(v) > 0) {
			return adj[v].size();
		} else {
			return -1;
		}

	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public boolean hasCycle() {
		return hasCycle;
	}

	public void findCycle(int v) {
		marked[v] = true;
		stack[v] = true;

		for (int w : adj(v)) {
			if (!marked[w]) {
				findCycle(w);
			} else if (stack[w]) {
				hasCycle = true;
				return;
			}
		}
		stack[v] = false;
	}

	public int findLCA(int v, int w) {

		findCycle(0);
		if (hasCycle) {
			return -1;
		}
		if (validateVertex(v) < 0 || validateVertex(v) < 0) {
			return -1;
		}
		if (E == 0) {
			return -1;
		}

		DAG backwards = reverse();
		ArrayList<Integer> arr1 = backwards.BFS(v);
		ArrayList<Integer> arr2 = backwards.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
		boolean found = false;
		for (int i = 0; i < arr1.size(); i++) {
			for (int t = 0; t < arr2.size(); t++) {
				if (arr1.get(i) == arr2.get(t)) {
					commonAncestors.add(arr1.get(i));
					found = true;
				}
			}
		}
		if (found)
			return commonAncestors.get(0);
		else
			return -1;
	}

	public DAG reverse() {
		DAG reverse = new DAG(V);
		for (int array1 = 0; array1 < V; array1++) {
			for (int array2 : adj(array1)) {
				reverse.addEdge(array2, array1);
			}
		}
		return reverse;
	}

	public ArrayList<Integer> BFS(int s) {
		boolean visited[] = new boolean[V];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> order = new ArrayList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			order.add(s);
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

		return order;

	}
}