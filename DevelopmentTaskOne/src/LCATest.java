import static org.junit.Assert.*;

import org.junit.Test;


public class LCATest {

	
	@Test
	public void testNodeConstructor(){
		
		Node temp = new Node(1);
		assertNotNull("Testing Node constructor: ", temp);
	}
	
	@Test 
	public void testEmptyTree(){
			LCA isTreeEmpty = new LCA();
			assertEquals("Find LCA for empty tree: ", -1 ,isTreeEmpty.findLCA(0, 0));

	}
	
	@Test
	public void testTwoNodes(){

		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);

		assertEquals("Find LCA of tree with only one root and one child: ", 1, tree.findLCA(1, 2));	
	}
	
	@Test 
	public void testOddTree () { 
		LCA oddTree = new LCA();
		oddTree.root = new Node(1);
		oddTree.root.right = new Node(2);
		oddTree.root.right.right = new Node(3);
		oddTree.root.right.right.right = new Node(4);
		oddTree.root.right.right.right.right = new Node(5);
	
		assertEquals("Odd tree with five nodes: ", 1, oddTree.findLCA(3, 1));
		assertEquals("Odd tree with five nodes: ", 4, oddTree.findLCA(5, 4));

	}
	
	@Test 
	public void testEvenTree () { 
		LCA evenTree = new LCA();
		evenTree.root = new Node(1);
		evenTree.root.right = new Node(2);
		evenTree.root.right.right = new Node(3);
		evenTree.root.right.right.right = new Node(4);
	
		assertEquals("Even tree with four nodes: ", 3, evenTree.findLCA(3,4));	
		assertEquals("Even tree with four nodes: ", 1, evenTree.findLCA(2, 1));
	
	}
	
	public void sameNodeTest() {
		LCA sameNode = new LCA();
		sameNode.root = new Node(4);
		sameNode.root.left = new Node(4);
		sameNode.root.right = new Node(4);
		
		assertEquals("LCA of 4 and 4: ",4,sameNode.findLCA(4, 4));
	}
	
	@Test
	public void testCommonAncestor(){
		
		LCA tree = new LCA();
		tree.root = new Node(2);
		tree.root.left = new Node(4);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(10);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(14);

		assertEquals("LCA of 12 and 14: ", 6, tree.findLCA(12, 14));
		assertEquals("LCA of 4 and 6: ", 2, tree.findLCA(4, 6));
		assertEquals("LCA of 8 and 10: ", 4, tree.findLCA(8, 10));
		assertEquals("LCA of 8 and 14: ", 2, tree.findLCA(8, 14));

	}
	
	public void nonExistentNodeTest() {
		
		LCA nonExTest = new LCA();
		nonExTest.root = new Node(3);
		nonExTest.root.left = new Node(6);
		nonExTest.root.right = new Node(9);
		nonExTest.root.left.left = new Node(12);
		nonExTest.root.left.right = new Node(15);
		nonExTest.root.right.left = new Node(18);
		nonExTest.root.right.right = new Node(21);
		
		assertEquals("LCA of 6 and 9: ", 3, nonExTest.findLCA(6,9));
		assertEquals("LCA of 12 and 28: ", -1, nonExTest.findLCA(12,28));
		assertEquals("LCA of 17 and 40: ", -1, nonExTest.findLCA(17,40));

	}
}

