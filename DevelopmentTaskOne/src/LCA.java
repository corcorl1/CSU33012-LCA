class Node {

		int data;
		Node left, right;

		Node(int value) {
			data = value;
			left = null;
			right = null;
		}
	
public class LCA {
		
		Node root;

		Node findLCA(int node1, int node2) {

			return findLCA(root, node1, node2);
		}

		Node findLCA(Node node, int node1, int node2) {

			if (node == null) {
				return null;
			}

			if (node.data == node1 || node.data == node2) {
				return node;
			}

			Node left = findLCA(node.left, node1, node2);
			Node right = findLCA(node.right, node1, node2);

			if (left != null && right != null) {
				return node;
			}

			if (left != null) {
				return left;
			} else {
				return right;
			}

		}

		
	}
}
