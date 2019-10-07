import java.util.List;
import java.util.ArrayList;

class Node {

	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = null;
		right = null;
	}
}

public class LCA {

	Node root;
	private List<Integer> firstRoute = new ArrayList<Integer>();
	private List<Integer> secondRoute = new ArrayList<Integer>();

	int findLCA(int node1, int node2) {
		firstRoute.clear();
		secondRoute.clear();

		return findInsideLCA(root, node1, node2);
	}

	private int findInsideLCA(Node root2, int node1, int node2) {

		if (!findRoute(root, node1, firstRoute) || !findRoute(root, node2, secondRoute)) {
			return -1;
		}

		int count;
		for (count = 0; count < firstRoute.size() && count < secondRoute.size(); count++) {
			if (!firstRoute.get(count).equals(secondRoute.get(count)))
				break;
		}

		return firstRoute.get(count - 1);
	}

	private boolean findRoute(Node root3, int node, List<Integer> route) {

		if (root3 == null) {
			return false;
		}
		route.add(root3.data);

		if (root3.data == node) {
			return true;
		}
		if (root3.left != null && findRoute(root3.left, node, route)) {
			return true;
		}
		if (root3.right != null && findRoute(root3.right, node, route)) {
			return true;
		}
		route.remove(route.size() - 1);
		return false;
	}

}
